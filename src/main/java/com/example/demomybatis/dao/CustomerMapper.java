package com.example.demomybatis.dao;

import com.example.demomybatis.entity.Customer;
import com.example.demomybatis.entity.CustomerKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int deleteByPrimaryKey(CustomerKey key);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByPrimaryKey(String id, String type);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}