package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.qaprosoft.dao.ITruckDao;
import com.qaprosoft.models.Truck;

public class TruckDaoImpl implements ITruckDao{

	@Override
	public void insertTruck(Truck truck) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertFreightTire", truck);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Truck> getAllTrucks() {
		List<Truck> list = new ArrayList<>();
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("mappers.getAllFreightTires");
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
			session.insert("mappers.insertFreightType", carType);
			session.commit();
		} finally {
			session.close();
		}	
	}

}
