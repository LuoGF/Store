package com.restrant.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.MealBiz;
import com.restrant.biz.MealSeriesBiz;

public class CartAction extends ActionSupport implements SessionAware{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MealSeriesBiz getMealSeriesBiz() {
		return mealSeriesBiz;
	}
	public void setMealSeriesBiz(MealSeriesBiz mealSeriesBiz) {
		this.mealSeriesBiz = mealSeriesBiz;
	}
Map<String,Object>session;
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	//��װ���������Ĳ�Ʒ���mealId����ֵ
	private Integer mealId;
	int quantity;
	MealBiz mealBiz;
	MealSeriesBiz mealSeriesBiz;
	//����Ʒ��ӹ��ﳵ
	public String addtoshopcart(){
		return null;
	}

}
