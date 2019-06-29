package com.example.demomybatis.dao;

import com.example.demomybatis.entity.ResvItem;
import com.example.demomybatis.entity.ResvItemKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResvItemMapper {
    int deleteByPrimaryKey(ResvItemKey key);

    int insert(ResvItem record);

    int insertSelective(ResvItem record);

    List<ResvItem> selectByPrimaryKey(ResvItemKey key);

    int updateByPrimaryKeySelective(ResvItem record);

    int updateByPrimaryKey(ResvItem record);
}