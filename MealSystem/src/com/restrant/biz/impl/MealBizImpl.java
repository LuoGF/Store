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
	//��ȡ���в�Ʒ��������ʼ����ҳ��pager����������perpagerrows��rowcount����
	public Pager getPagerOfAllMeal() {
		// TODO Auto-generated method stub
		int count=mealDao.getCountOfAllMeal();
		//ʹ�÷�ҳ��Pager�������
		Pager pager=new Pager();
		//���ö�����perpagerrows���ԡ���ʾÿҳ��ʾ�ļ�¼��
		pager.setPerPageRows(6);
		//����pager�����е�rowcount���ԣ���ʾ��¼����
		pager.setRowCount(count);
		//����pager����
		return pager;
	}
	//���ݲ�ѯ��������ȡָ��ҳ��ʾ��Ʒ�б�
	public List getMealByCondition(Meal condition, int page) {
		// TODO Auto-generated method stub
		
		return mealDao.getMealByCondition(condition, page);
	}
//ͳ�Ʒ��ϲ�ѯ�����Ĳ�Ʒ��������ʼ����ҳ��pager��������perpagerrows��rowcount����
	public Pager getPagerOfMeal(Meal condition) {
		// TODO Auto-generated method stub
		int count=mealDao.getCountOfMeal(condition);
		//ʹ�÷�ҳ��pager�������
			Pager pager=new Pager();
			//���ö�����perpagerrows���ԡ���ʾÿҳ��ʾ�ļ�¼��
			pager.setPerPageRows(6);
			//����pager�����е�rowcount���ԣ���ʾ��¼����
			pager.setRowCount(count);
			//����pager����
			return pager;
	}

}
