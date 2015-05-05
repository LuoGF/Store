package com.restrant.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.restrant.dao.MealDao;
import com.restrant.entity.Meal;

public class MealDaoImpl implements MealDao{
public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

SessionFactory sessionFactory;
//查询指定页显示的餐品列表
	public List getAllMeal(int page) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Meal.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
//统计所有餐品数量
	public Integer getCountOfAllMeal() {
		// TODO Auto-generated method stub
		Integer count=null;
		try {String hql="select count(*)from Meal";
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			count=Integer.parseInt(query.uniqueResult().toString());
		
		} catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
		}
		
		return count;
	}
//更具查询条件。获取指定页显示的餐品列表
	public List getMealByCondition(Meal condition, int page) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Meal.class);
		if(condition!=null){
			if(condition.getMealName()!=null&& !condition.getMealName().equals("")){//按菜名进行帅选
				c.add(Restrictions.like("mealName",condition.getMealName(),MatchMode.ANYWHERE));
				
			}
			if((condition.getMealseries()!=null)&&(condition.getMealseries().getSeriesId()!=null)){//按菜系进行帅选
				c.add(Restrictions.eq("mealseries.seriesId", condition.getMealseries().getSeriesId()));
		}}
			c.setFirstResult(6*(page-1));
			c.setMaxResults(6);
			return c.list();
	}
	//统计符合查询条件的餐品总数
	
	public Integer getCountOfMeal(Meal condition) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Meal.class);
		if(condition!=null){
			if(condition.getMealName()!=null&& !condition.getMealName().equals("")){//按菜名进行帅选
				c.add(Restrictions.like("mealName",condition.getMealName(),MatchMode.ANYWHERE));
				
			}
			if((condition.getMealseries()!=null)&&(condition.getMealseries().getSeriesId()!=null)){//按菜系进行帅选
				c.add(Restrictions.eq("mealseries.seriesId", condition.getMealseries().getSeriesId()));
		}}
		return c.list().size();
	}

}
