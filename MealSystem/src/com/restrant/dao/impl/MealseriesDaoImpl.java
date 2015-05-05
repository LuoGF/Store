package com.restrant.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.restrant.dao.MealseriesDao;
import com.restrant.entity.Meal;
import com.restrant.entity.Mealseries;

public class MealseriesDaoImpl implements MealseriesDao{
public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取菜系列表
	SessionFactory sessionFactory;
	public List getMealseries() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		System.out.println("session值"+session);
		Criteria c=session.createCriteria(Mealseries.class);
		
		return c.list();
	}

}
