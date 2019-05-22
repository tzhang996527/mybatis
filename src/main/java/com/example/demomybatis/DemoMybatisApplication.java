package com.example.demomybatis;

import com.example.demomybatis.mapper.CityMapper;
import com.example.demomybatis.mapper.HotelMapper;
import com.example.demomybatis.mapper.TourMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoMybatisApplication {

	private final CityMapper cityMapper;

	private final HotelMapper hotelMapper;

	private final TourMapper tourMapper;

	public DemoMybatisApplication(CityMapper cityMapper, HotelMapper hotelMapper, TourMapper tourMapper) {
		this.cityMapper = cityMapper;
		this.hotelMapper = hotelMapper;
		this.tourMapper = tourMapper;
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoMybatisApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args) -> {
			//test
			System.out.println(this.tourMapper.findTourById("2"));

//			City city = new City();
//			city.setName("San Francisco");
//			city.setState("CA");
//			city.setCountry("US");
//			cityMapper.insert(city);
//			System.out.println(this.cityMapper.findById(city.getId()));
//
//			Hotel hotel = new Hotel();
//			hotel.setCity((long) 10);
//			hotel.setAddress("San Francisco");
//			hotel.setName("Lucky Inner");
//			hotel.setZip("200000");
//			hotelMapper.insert(hotel);
//			System.out.println(this.hotelMapper.selectByCityId(10));
		};
	}


}
