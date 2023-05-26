package com.example.demo.device.factory;

import java.io.File;
import java.io.FileNotFoundException;

import com.example.demo.device.Computer;

public interface ComputerFactory {
    Computer buildComputer(File jsonInfo) throws FileNotFoundException;
    Computer buildComputer(String name);
}