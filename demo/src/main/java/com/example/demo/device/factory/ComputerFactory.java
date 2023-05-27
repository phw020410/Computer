package com.example.demo.device.factory;

import java.io.File;

import com.example.demo.device.Computer;

public interface ComputerFactory {
    Computer buildComputer(File jsonInfo);
    Computer buildComputer(String computerName);
}