package com.example.demomybatis.dao;

import com.example.demomybatis.entity.TourItem;
import com.example.demomybatis.entity.TourItemKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourItemMapper {
    int deleteByPrimaryKey(TourItemKey key);

    int insert(TourItem record);

    int insertSelective(TourItem record);

    List<TourItem> selectByPrimaryKey(TourItem tourItem);

    int updateByPrimaryKeySelective(TourItem record);

    int updateByPrimaryKey(TourItem record);

    int upsert(TourItem record);
}