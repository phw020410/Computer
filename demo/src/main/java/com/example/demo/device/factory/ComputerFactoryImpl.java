package com.example.demo.device.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import com.example.demo.device.Computer;
import com.example.demo.manager.AddressManager;

public class ComputerFactoryImpl implements ComputerFactory {
    @Override
    public Computer buildComputer(File jsonInfo) {
        try {
            BufferedReader jsonReader = new BufferedReader(new FileReader(jsonInfo));
    
            StringBuilder content = new StringBuilder();
            jsonReader.lines().forEach(content::append);
    
            JsonParser jsonParser = JsonParserFactory.getJsonParser();
            Map<String, Object> info = jsonParser.parseMap(content.toString());
    
            String name = (String) info.get("name");
            InetAddress ip = Inet4Address.getByName((String) info.get("ip"));
            InetAddress subnetMask = Inet4Address.getByName((String) info.get("subnet-mask"));
            InetAddress gateway = Inet4Address.getByName((String) info.get("gateway"));
            String mac = (String) info.get("MAC");
            Map<String, String> ports = (Map<String, String>) info.get("ports");

            if(!AddressManager.checkAddress(ip, mac)) {
                jsonReader.close();
                return null;
            }

            AddressManager.addIp(ip);
            AddressManager.addMac(mac);

            jsonReader.close();
    
            return new Computer(name, ip, subnetMask, gateway, mac, ports);
        } catch (IOException e) {
            System.out.println(e);

            return null;
        }
    }

    @Override
    public Computer buildComputer(String computerName) {
        String name;
        InetAddress ip;
        InetAddress subnetMask;
        InetAddress gateway;
        String mac;
        Map<String, String> ports = new HashMap<>();

        String privateIp = "192.168.";
        String newIp = privateIp + (int) Math.random() * 2550 + "." + (int) Math.random() * 2550;
        String newGateway = privateIp + (int) Math.random() * 2550 + ".1";
        
        StringBuilder newMac = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            newMac.append(Integer.toHexString((int) Math.random() * 160));
            
            if(i % 2 == 1) {
                newMac.append(":");
            }
        }
        
        try {
            name = computerName;
            ip = Inet4Address.getByName(newIp);
            subnetMask = Inet4Address.getByName("255.255.255.0");
            gateway = Inet4Address.getByName(newGateway);
            mac = newMac.toString();
            ports.put("eth1", "");
            ports.put("eth2", "");

            return new Computer(name, ip, subnetMask, gateway, mac, ports);
        } catch (UnknownHostException e) {
            System.out.println(e);

            return null;
        }
    }
}