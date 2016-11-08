package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.qaprosoft.dao.ISuvDao;
import com.qaprosoft.models.Suv;

public class SuvDaoImpl implements ISuvDao{

	@Override
	public void insertSuv(Suv suv) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertOffRoadTire", suv);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Suv> getAllSuves() {
		List<Suv> list = new ArrayList<>();
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
			session.insert("mappers.insertOffRoadType", carType);
			session.commit();
		} finally {
			session.close();
		}	
	}

}
