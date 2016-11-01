package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.qaprosoft.dao.IOffRoadTireDao;
import com.qaprosoft.models.OffRoadTire;

public class OffRoadTireDaoImpl implements IOffRoadTireDao{

	@Override
	public void insertOffRoadTire(OffRoadTire offRoadTire) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertOffRoadTire", offRoadTire);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<OffRoadTire> getAllOffRoadTires() {
		List<OffRoadTire> list = new ArrayList<>();
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("mappers.getAllOffRoadTires");
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
			session.insert("mappers.insertCarType", carType);
			session.commit();
		} finally {
			session.close();
		}	
	}

}
