package com.podrao;

public class Dessert extends Dish <String, Boolean, Integer> {

	public Dessert(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, Integer Extras) {
		super(dishName, gfd, vgd, hmd, sfd, Extras);
		// TODO Auto-generated constructor stub
	}
	
	private final String dishType = "Dessert";
	
	@Override
	public Integer setExtras() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getExtras() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getDishName() {
		// TODO Auto-generated method stub
		return super.getDishName();
	}

	public String getDishType() {
		return dishType;
	}

	@Override
	public String toString() {
		return "This is a Dessert of "+ getDishName()+"\n" ;
	}
}
