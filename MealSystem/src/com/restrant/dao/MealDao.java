package com.restrant.dao;

import java.util.List;

import com.restrant.entity.Meal;

public interface MealDao {
public List getAllMeal(int page);//获得指定页数显示的餐品列表
public Integer getCountOfAllMeal();//统计所有餐品总数
public List getMealByCondition(Meal condition,int page);//根据查询条件，获取指定页显示餐品列表
public Integer getCountOfMeal(Meal condition);//获得符合查询条件的所有餐品总数
}
