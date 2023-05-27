package com.example.demo.manager;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class AddressManager {
    private static final List<InetAddress> IPS = new ArrayList<>();
    private static final List<String> MACS = new ArrayList<>();

    private AddressManager() {}

    public static List<InetAddress> getIps() {
        return IPS;
    }

    public static List<String> getMacs() {
        return MACS;
    }

    public static void addIp(InetAddress ip) {
        IPS.add(ip);
    }

    public static void addMac(String mac) {
        MACS.add(mac);
    }

    public static boolean checkAddress(InetAddress ip, String mac) {
        if(IPS.contains(ip) || MACS.contains(mac)) {
            return false;
        }

        return true;
    }
}