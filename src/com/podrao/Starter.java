package com.podrao;

public class Starter extends Dish <String, Boolean, String>{
	
	public Starter(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, String Extras) {
		super(dishName, gfd, vgd, hmd, sfd, Extras);
		// TODO Auto-generated constructor stub
	}

	private final String dishType = "Starter";
	
	@Override
	public String setExtras() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getExtras() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDishType() {
		return dishType;
	} 
	
	@Override
	public String toString() {
		return "This is a Starter of "+ getDishName() +"\n";
	}

	
}
