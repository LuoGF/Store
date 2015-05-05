package com.restrant.entity;

import java.sql.Timestamp;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer oid;
	private User user;
	private Timestamp orderTiem;
	private String orderState;
	private Double orderPrice;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(User user, Timestamp orderTiem, String orderState,
			Double orderPrice) {
		this.user = user;
		this.orderTiem = orderTiem;
		this.orderState = orderState;
		this.orderPrice = orderPrice;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getOrderTiem() {
		return this.orderTiem;
	}

	public void setOrderTiem(Timestamp orderTiem) {
		this.orderTiem = orderTiem;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Double getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

}