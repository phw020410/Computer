package com.example.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.device.factory.ComputerFactory;
import com.example.demo.device.factory.ComputerFactoryImpl;
import com.example.demo.manager.ComputerManager;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		File computerDir = new File("resources/computer");
		File[] computerFiles = computerDir.listFiles();

		ComputerFactory computerFactory = new ComputerFactoryImpl();
		
		for (File computerFile : computerFiles) {
			ComputerManager.addComputer(computerFactory.buildComputer(computerFile));
		}
		ComputerManager.addComputer(computerFactory.buildComputer("TestName"));
		ComputerManager.getComputers().forEach(System.out::println);
	}
}