package com.example.demo.manager;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.device.Computer;

public class ComputerManager {
    private static final List<Computer> COMPUTERS = new ArrayList<>();

    private ComputerManager() {}
    
    public static void addComputer(Computer computer) {
        if(computer == null) {
            return;
        }

        COMPUTERS.add(computer);
    }

    public static List<Computer> getComputers() {
        return COMPUTERS;
    }
}
