package com.example.demomybatis.dao;

import com.example.demomybatis.entity.ResvType;

public interface ResvTypeMapper {
    int deleteByPrimaryKey(String resvType);

    int insert(ResvType record);

    int insertSelective(ResvType record);

    ResvType selectByPrimaryKey(String resvType);

    int updateByPrimaryKeySelective(ResvType record);

    int updateByPrimaryKey(ResvType record);
}