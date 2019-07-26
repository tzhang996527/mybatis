package com.example.demomybatis;

import com.example.demomybatis.dao.TourDetailMapper;
import com.example.demomybatis.entity.TourDetail;
import com.example.demomybatis.entity.TourItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMybatisApplicationTests {

	@Resource
	private TourDetailMapper tourDetailMapper;
	@Test
	public void test1(){
//		List<TourItem> it = null;
//		List<TourDetail> tourDetails = tourDetailMapper.findTourTest();
//		for(TourDetail item :tourDetails){
//			it = item.getTourItem();
//			System.out.println("");
//		}
		System.out.println("");

	}

}
