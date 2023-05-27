package com.example.demo.device;

import java.net.InetAddress;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Computer {
    private String name;
    private InetAddress ip;
    private InetAddress subnetMask;
    private InetAddress gateway;

    private String mac;

    private Map<String, String> ports;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ports.forEach((key, value) -> str.append("{" + key + " : " + value +"} "));
        
        return "name : " + name + "\n" +
                "ip : " + ip.getHostAddress() + "\n" +
                "subnetMask : " + subnetMask.getHostAddress() + "\n" +
                "gateway : " + gateway.getHostAddress() + "\n" +
                "MAC : " + mac + "\n" +
                "port : " + str + "\n";
    }
}