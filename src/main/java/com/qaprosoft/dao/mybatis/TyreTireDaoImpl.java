package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.dao.ITyreTireDao;
import com.qaprosoft.models.TyreTire;

public class TyreTireDaoImpl implements ITyreTireDao{

	@Override
	public void insertTyreTire(TyreTire tyreTire) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertTyreTire", tyreTire);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<TyreTire> getAllTyreTires() {
		List<TyreTire> list = new ArrayList<>();
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
			session.insert("mappers.insertCarType", carType);
			session.commit();
		} finally {
			session.close();
		}	
	}

}
