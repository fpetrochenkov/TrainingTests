package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.qaprosoft.dao.ICarTireDao;
import com.qaprosoft.models.CarTire;

public class CarTireDaoImpl implements ICarTireDao{


	@Override
	public List<CarTire> getAllCarTires() {
		List<CarTire> list = new ArrayList<>();
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("mappers.getAllCarTires");
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void insertCarTire(CarTire carTire) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertCarTire", carTire);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void insertCarType(String carType) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertCarType", carType);
			session.commit();
		} finally {
			session.close();
		}		
	}	

}
