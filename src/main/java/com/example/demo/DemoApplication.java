package com.example.demo;

import com.example.demo.Repo.FlowerpostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
//		@Autowired
//		FlowerpostRepo flowerpostRepo;

		SpringApplication.run(DemoApplication.class, args);
//		System.out.println(flowerpostRepo.findAll());

	}

}