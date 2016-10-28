package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.dao.ITireDao;
import com.qaprosoft.models.Tire;

public class TireDaoImpl implements ITireDao{

	@Override
	public void insertTires(ArrayList<Tire> tires) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertTires", tires);
			session.commit();
		} finally {
			session.close();
		}		
	}

	@Override
	public List<Tire> getAllTires() {
		List<Tire> list = new ArrayList<>();
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			list = session.selectList("mappers.getAllTires");
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void insertTire(Tire tire) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertTire", tire);
			session.commit();
		} finally {
			session.close();
		}
	}
	

}
