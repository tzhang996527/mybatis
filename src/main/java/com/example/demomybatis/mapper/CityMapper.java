package com.example.demomybatis.mapper;

import org.apache.ibatis.annotations.*;
import com.example.demomybatis.entity.City;

import java.util.List;

@Mapper
public interface CityMapper {
    @Select("select id, name, state, country from city where state = #{state}")
    City findByState(@Param("state") String state);

    @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);

    @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    City findById(long id);

    @Select("SELECT id, name, state, country FROM city")
    List<City> getAllCities();
}
