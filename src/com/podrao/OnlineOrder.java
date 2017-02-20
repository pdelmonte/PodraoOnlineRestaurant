package com.podrao;

import java.io.Serializable;

public class OnlineOrder {
	
	private String ClientName;
	private Dish<String, Boolean, ? extends Serializable> OrderDish;

	public OnlineOrder() {
	}
	
	public OnlineOrder(String ClientName) {
		this.ClientName = ClientName;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	public Dish<String, Boolean, ? extends Serializable> getOrderDish() {
		return OrderDish;
	}

	public void setOrderDish(Dish<String, Boolean, ? extends Serializable> orderDish) {
		OrderDish = orderDish;
	}


}
