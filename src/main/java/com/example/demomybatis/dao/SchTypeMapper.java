package com.example.demomybatis.dao;

import com.example.demomybatis.entity.SchType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SchTypeMapper {
    int deleteByPrimaryKey(String schType);

    int insert(SchType record);

    int insertSelective(SchType record);

    List<SchType> selectByPrimaryKey(SchType schType);

    int updateByPrimaryKeySelective(SchType record);

    int updateByPrimaryKey(SchType record);
}