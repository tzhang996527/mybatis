package com.example.demomybatis.dao;

import com.example.demomybatis.entity.SchType;

public interface SchTypeMapper {
    int deleteByPrimaryKey(String schType);

    int insert(SchType record);

    int insertSelective(SchType record);

    SchType selectByPrimaryKey(String schType);

    int updateByPrimaryKeySelective(SchType record);

    int updateByPrimaryKey(SchType record);
}