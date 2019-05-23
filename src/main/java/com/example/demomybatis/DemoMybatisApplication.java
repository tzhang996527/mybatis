package com.example.demomybatis;

import com.example.demomybatis.dao.TourMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


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
			//test
			//System.out.println(this.tourMapper.findTourById("2"));
		};
	}


}
