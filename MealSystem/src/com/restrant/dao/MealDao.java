package com.restrant.dao;

import java.util.List;

import com.restrant.entity.Meal;

public interface MealDao {
public List getAllMeal(int page);//���ָ��ҳ����ʾ�Ĳ�Ʒ�б�
public Integer getCountOfAllMeal();//ͳ�����в�Ʒ����
public List getMealByCondition(Meal condition,int page);//���ݲ�ѯ��������ȡָ��ҳ��ʾ��Ʒ�б�
public Integer getCountOfMeal(Meal condition);//��÷��ϲ�ѯ���������в�Ʒ����
}
