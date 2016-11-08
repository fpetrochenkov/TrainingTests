package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.qaprosoft.dao.ICarDao;
import com.qaprosoft.models.Car;

public class CarDaoImpl implements ICarDao{


	@Override
	public List<Car> getAllCars() {
		List<Car> list = new ArrayList<>();
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
	public void insertCar(Car car) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertCarTire", car);
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
