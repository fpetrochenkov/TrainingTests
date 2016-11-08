package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.dao.ILightTruckDao;
import com.qaprosoft.models.LightTruck;

public class LightTruckDaoImpl implements ILightTruckDao{

	@Override
	public void insertLightTruck(LightTruck lightTruck) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertTyreTire", lightTruck);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<LightTruck> getAllLightTrucks() {
		List<LightTruck> list = new ArrayList<>();
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("mappers.getAllTyreTires");
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void insertCarType(String carType) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertTyreType", carType);
			session.commit();
		} finally {
			session.close();
		}	
	}

}
