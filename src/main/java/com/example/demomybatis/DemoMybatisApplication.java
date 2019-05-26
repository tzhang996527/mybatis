package com.example.demomybatis;

import com.example.demomybatis.dao.TourMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class DemoMybatisApplication {

	private final TourMapper tourMapper;

	public DemoMybatisApplication(TourMapper tourMapper) {
		this.tourMapper = tourMapper;
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoMybatisApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args) -> {
//		    String test = new BCryptPasswordEncoder().encode("admin");
//		    System.out.println(String.format("admin = %s, length = %d.",test,test.length()));
//			//test
//			//System.out.println(this.tourMapper.findTourById("2"));
//
//            String test2 = new BCryptPasswordEncoder().encode("eddie");
//            System.out.println(String.format("eddie = %s, length = %d.",test2,test2.length()));
		};
	}


}
