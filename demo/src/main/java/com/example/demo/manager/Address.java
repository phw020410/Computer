package com.example.demo.manager;

import java.util.ArrayList;
import java.util.List;

public class Address {
    private List<String> ips;
    private List<String> MACs;

    private Address() {
        this.ips = new ArrayList<>();
        this.MACs = new ArrayList<>();
    }
}

//design pattern 