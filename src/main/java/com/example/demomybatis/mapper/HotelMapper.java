package com.example.demomybatis.mapper;

import com.example.demomybatis.entity.Hotel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelMapper {

    Hotel selectByCityId(int cityId);

}
