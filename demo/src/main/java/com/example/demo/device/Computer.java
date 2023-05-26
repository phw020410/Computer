package com.example.demo.device;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Computer {
    private String name;
    private String ip;
    private String subnetMask;
    private String gateway;

    private String MAC;

    private Map<String, String> ports;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ports.forEach((key, value) -> str.append("{" + key + ":" + value +"}"));
        return String.format("name : %s, ip : %s, subnetMask : %s, gateway : %s, MAC : %s, ports : %s", name, ip, subnetMask, gateway, MAC, str);
    }
}