package com.qaprosoft.dao.mybatis;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.qaprosoft.dao.IFreightTireDao;
import com.qaprosoft.models.FreightTire;

public class FreightTireDaoImpl implements IFreightTireDao{

	@Override
	public void insertFreightTire(FreightTire freightTire) {
		SqlSession session = SessionFactory.getInstance().getSqlSessionFactory().openSession();
		try {
			session.insert("mappers.insertFreightTire", freightTire);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public List<FreightTire> getAllFreightTires() {
		List<FreightTire> list = new ArrayList<>();
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
			session.insert("mappers.insertCarType", carType);
			session.commit();
		} finally {
			session.close();
		}	
	}

}
