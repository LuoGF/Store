package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Meal;
import com.restrant.entity.Pager;

public interface MealBiz{
	public List getAllMeal(int page);//���ָ��ҳ����ʾ�Ĳ�Ʒ�б�
	public Pager getPagerOfAllMeal();//��ȡ���в�Ʒ��������ʼ����ҳ��pager����������perpagerrows��rowcount����
	public List getMealByCondition(Meal condition,int page);//���ݲ�ѯ��������ȡָ��ҳ��ʾ��Ʒ�б�
	public Pager getPagerOfMeal(Meal condition);//������perpagerrows��rowcount����
}
