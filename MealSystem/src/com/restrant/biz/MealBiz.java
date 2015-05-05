package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Meal;
import com.restrant.entity.Pager;

public interface MealBiz{
	public List getAllMeal(int page);//获得指定页数显示的餐品列表
	public Pager getPagerOfAllMeal();//获取所有餐品数量，初始化分页类pager对象，设置其perpagerrows和rowcount属性
	public List getMealByCondition(Meal condition,int page);//根据查询条件，获取指定页显示餐品列表
	public Pager getPagerOfMeal(Meal condition);//设置其perpagerrows和rowcount属性
}
