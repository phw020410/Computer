package com.example.demo.device.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import com.example.demo.device.Computer;

public class ComputerFactoryImpl implements ComputerFactory {
    @Override
    public Computer buildComputer(File jsonInfo) throws FileNotFoundException {
        BufferedReader jsonReader = new BufferedReader(new FileReader(jsonInfo));

        StringBuilder content = new StringBuilder();
        jsonReader.lines().forEach(content::append);

        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> info = jsonParser.parseMap(content.toString());

        String name = (String) info.get("name");
        String ip = (String) info.get("ip");
        String subnetMask = (String) info.get("subnet-mask");
        String gateway = (String) info.get("gateway");
        String MAC = (String) info.get("MAC");
        Map<String, String> ports = (Map<String, String>) info.get("ports");
        
        return new Computer(name, ip, subnetMask, gateway, MAC, ports);
    }

    @Override
    public Computer buildComputer(String name) {
        return null;
    }
}
