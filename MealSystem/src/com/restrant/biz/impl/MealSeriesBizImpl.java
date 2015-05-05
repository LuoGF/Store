package com.restrant.biz.impl;

import java.util.List;

import com.restrant.biz.MealSeriesBiz;
import com.restrant.dao.MealDao;
import com.restrant.dao.MealseriesDao;
import com.restrant.entity.Mealseries;

public class MealSeriesBizImpl implements MealSeriesBiz{
   
	public MealseriesDao getMealseriesDao() {
		return mealseriesDao;
	}
	public void setMealseriesDao(MealseriesDao mealseriesDao) {
		this.mealseriesDao = mealseriesDao;
	}
	MealseriesDao mealseriesDao;
	public List getMealSeries() {
		// TODO Auto-generated method stub
		return mealseriesDao.getMealseries();
		
	}

}
