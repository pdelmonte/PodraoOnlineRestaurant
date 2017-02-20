package com.podrao;

public abstract class Dish <T, S, U>
{
	public Dish(T dishName, S gfd, S vgd, S hmd, S sfd, U Extras) {
		this.dishName = dishName;
		this.gfd = gfd;
		this.vgd = vgd;
		this.hmd = hmd;
		this.sfd = sfd;
		this.Extras = Extras;
	}
	
	private T dishName;
	private S gfd;
	private S vgd;
	private S hmd;
	private S sfd;
	private U Extras;
		
	public T getDishName() {
		return dishName;
	}

	public void setDishName(T dishName) {
		this.dishName = dishName;
	}

	public S getGfd() {
		return gfd;
	}

	public void setGfd(S gfd) {
		this.gfd = gfd;
	}
	
	public S isGfd(){
		return gfd;
	}

	public S getVgd() {
		return vgd;
	}

	public void setVgd(S vgd) {
		this.vgd = vgd;
	}
	
	public S isVgd(){
		return vgd;
	}

	public S getHmd() {
		return hmd;
	}

	public void setHmd(S hmd) {
		this.hmd = hmd;
	}

	public S isHmd(){
		return hmd;
	}
	
	public S getSfd() {
		return sfd;
	}

	public void setSfd(S sfd) {
		this.sfd = sfd;
	}
	
	public S isSfd(){
		return sfd;
	}

	public abstract U setExtras(); 
	public abstract U getExtras();
	public abstract String getDishType();
}
