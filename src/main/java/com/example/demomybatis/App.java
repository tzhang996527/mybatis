package com.example.demomybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App {

//	private final TourMapper tourMapper;
//
//	public App(TourMapper tourMapper) {
//		this.tourMapper = tourMapper;
//	}

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args) -> {
//			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//			String password1 =  "Admin";
//			String encoding_password1 = bCryptPasswordEncoder.encode(password1);
//
//			boolean match1 = bCryptPasswordEncoder.matches(password1,encoding_password1);
//			System.out.println("Encoding_password1: " + encoding_password1);
//			System.out.println("matches " + password1 + "boolean = " + match1);

		};
	}


}
