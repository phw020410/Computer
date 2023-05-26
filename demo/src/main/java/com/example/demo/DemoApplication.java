package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.device.Computer;
import com.example.demo.device.factory.ComputerFactory;
import com.example.demo.device.factory.ComputerFactoryImpl;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		try {
			File file = new File("resources/computer");
			File[] files = file.listFiles();
			ComputerFactory computerFactory = new ComputerFactoryImpl();
			Computer pc1 = computerFactory.buildComputer(files[0]);
			System.out.println(pc1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}