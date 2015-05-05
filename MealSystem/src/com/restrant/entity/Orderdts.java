package com.restrant.entity;

/**
 * Orderdts entity. @author MyEclipse Persistence Tools
 */

public class Orderdts implements java.io.Serializable {

	// Fields

	private Integer odid;
	private Meal meal;
	private Integer oid;
	private Double mealPrice;
	private Integer mealCount;

	// Constructors

	/** default constructor */
	public Orderdts() {
	}

	/** full constructor */
	public Orderdts(Meal meal, Integer oid, Double mealPrice, Integer mealCount) {
		this.meal = meal;
		this.oid = oid;
		this.mealPrice = mealPrice;
		this.mealCount = mealCount;
	}

	// Property accessors

	public Integer getOdid() {
		return this.odid;
	}

	public void setOdid(Integer odid) {
		this.odid = odid;
	}

	public Meal getMeal() {
		return this.meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getMealPrice() {
		return this.mealPrice;
	}

	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}

	public Integer getMealCount() {
		return this.mealCount;
	}

	public void setMealCount(Integer mealCount) {
		this.mealCount = mealCount;
	}

}