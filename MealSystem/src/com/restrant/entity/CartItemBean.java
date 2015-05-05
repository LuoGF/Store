package com.restrant.entity;

import java.io.Serializable;

public class CartItemBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setCartItemBean(Meal meal,int quantity){
		this.meal=meal;
		this.quantity=quantity;
	}
	private Meal meal;
	private int quantity;
	

}
