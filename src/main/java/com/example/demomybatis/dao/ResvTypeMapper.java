package com.example.demomybatis.dao;

import com.example.demomybatis.entity.ResvType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResvTypeMapper {
    int deleteByPrimaryKey(String resvType);

    int insert(ResvType record);

    int insertSelective(ResvType record);

    List<ResvType> selectByPrimaryKey(ResvType resvType);

    int updateByPrimaryKeySelective(ResvType record);

    int updateByPrimaryKey(ResvType record);
}