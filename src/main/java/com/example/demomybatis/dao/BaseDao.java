package com.example.demomybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private Class<T> entityClass;

    public BaseDao(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

//    public List<T> selectAll(){
//        return sqlSessionTemplate.selectList(entityClass);
//    }
}

//https://blog.csdn.net/acweilisky0825/article/details/52032867
