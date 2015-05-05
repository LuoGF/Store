package com.restrant.biz.impl;

import java.util.List;

import com.restrant.biz.MealBiz;

import com.restrant.dao.MealDao;
import com.restrant.entity.Meal;
import com.restrant.entity.Pager;

public class MealBizImpl implements MealBiz {
 public MealDao getMealDao() {
		return mealDao;
	}

	public void setMealDao(MealDao mealDao) {
		this.mealDao = mealDao;
	}

MealDao mealDao;
	public List getAllMeal(int page) {
		// TODO Auto-generated method stub
		
		return mealDao.getAllMeal(page);
	}
	//获取所有餐品数量，初始化分页类pager对象，设置其perpagerrows和rowcount属性
	public Pager getPagerOfAllMeal() {
		// TODO Auto-generated method stub
		int count=mealDao.getCountOfAllMeal();
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置对象中perpagerrows属性。表示每页显示的记录数
		pager.setPerPageRows(6);
		//设置pager对象中的rowcount属性，表示记录总数
		pager.setRowCount(count);
		//返回pager对象
		return pager;
	}
	//根据查询条件，获取指定页显示餐品列表
	public List getMealByCondition(Meal condition, int page) {
		// TODO Auto-generated method stub
		
		return mealDao.getMealByCondition(condition, page);
	}
//统计符合查询条件的餐品数量。初始化分页类pager对象。设置perpagerrows和rowcount属性
	public Pager getPagerOfMeal(Meal condition) {
		// TODO Auto-generated method stub
		int count=mealDao.getCountOfMeal(condition);
		//使用分页类pager定义对象
			Pager pager=new Pager();
			//设置对象中perpagerrows属性。表示每页显示的记录数
			pager.setPerPageRows(6);
			//设置pager对象中的rowcount属性，表示记录总数
			pager.setRowCount(count);
			//返回pager对象
			return pager;
	}

}
