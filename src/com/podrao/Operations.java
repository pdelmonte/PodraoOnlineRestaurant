package com.podrao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Operations implements OnlineOrderOps<OnlineOrder, Dish<String, Boolean,? extends Serializable>> {

	@Override
	public int getNumberOrders(List<OnlineOrder> orderList) {
		int count = orderList.size();
		return count;
	}

	@Override
	public OnlineOrder getOrder(List<OnlineOrder> orderList, int orderIndex) {
		return orderList.get(orderIndex);
	}

	@Override
	public String getAllOrdersToString(List<OnlineOrder> orderList) {
		for(OnlineOrder o: orderList) {
			System.out.println("The client "+o.getClientName()+" ordered " + o.getOrderDish().getDishName());
		}
		return null;
	}

	@Override
	public Dish<String, Boolean, ? extends Serializable> getDish(List<Dish<String, Boolean, ? extends Serializable>> dishList, int dishIndex) {
		return dishList.get(dishIndex);
	}

	@Override
	public String getAllDishToString(List<Dish<String, Boolean, ? extends Serializable>> dishList) {
		for(Dish<String, Boolean, ? extends Serializable> o: dishList) {
			System.out.println(o.getDishName());
		}
		return null;
	}

	@Override
	public List<Dish<String, Boolean, ? extends Serializable>> getDishesByType(
			List<Dish<String, Boolean, ? extends Serializable>> dishList, String dishType) {
		List<Dish<String, Boolean, ? extends Serializable>> typeList = new ArrayList<Dish<String, Boolean, ? extends Serializable>>();
		for(Dish<String, Boolean, ? extends Serializable> o: dishList) {
			if (o.getDishType() == dishType){
				typeList.add(o);
			} 
		}
		return typeList;
	}

	@Override
	public List<Dish<String, Boolean, ? extends Serializable>> getDishesByFeature(
			List<Dish<String, Boolean, ? extends Serializable>> dishList, String feature) {
		List<Dish<String, Boolean, ? extends Serializable>> featureList = new ArrayList<Dish<String, Boolean, ? extends Serializable>>();
		for(Dish<String, Boolean, ? extends Serializable> f: dishList) {
			switch (feature) {
			case "gfd":
				if (f.isGfd()) {
					featureList.add(f);
				}
				break;
			case "vgd":
				if (f.isVgd()) {
					featureList.add(f);
				}
				break;
			case "hmd":
				if (f.isHmd()) {
					featureList.add(f);
				}
				break;
			case "sfd":
				if (f.isSfd()) {
					featureList.add(f);
				}
				break;
			}
		}
		return featureList;
	}

	@Override
	public String getStatsByDishType(List<Dish<String, Boolean, ? extends Serializable>> dishList, String dishType) {
		List<Dish<String, Boolean, ? extends Serializable>> typeList = new ArrayList<Dish<String, Boolean, ? extends Serializable>>();
		int listtotal = dishList.size();
		for(Dish<String, Boolean, ? extends Serializable> o: dishList) {
			if (o.getDishType() == dishType){
				typeList.add(o);
			} 
		}
		int typecount = typeList.size();
		float result = typecount * 100 / listtotal;
		return "Percentage of dishes Type "+ dishType + " equals to " +result+"%";
	}

	public String getStatsByFeature(List<Dish<String, Boolean, ? extends Serializable>> dishList, String feature) {
		List<Dish<String, Boolean, ? extends Serializable>> typeList = new ArrayList<Dish<String, Boolean, ? extends Serializable>>();
		int listtotal = dishList.size();
		for(Dish<String, Boolean, ? extends Serializable> o: dishList) {
			switch (feature) {
			case "gfd":
				if (o.isGfd()) {
					typeList.add(o);
				}
				break;
			case "vgd":
				if (o.isVgd()) {
					typeList.add(o);
				}
				break;
			case "hmd":
				if (o.isHmd()) {
					typeList.add(o);
				}
				break;
			case "sfd":
				if (o.isSfd()) {
					typeList.add(o);
				}
			}
		}
		int typecount = typeList.size();
		float result = typecount * 100 / listtotal;
		return "Percentage of feature Type "+ feature + " equals to " +result+"%";
	}
	

}
