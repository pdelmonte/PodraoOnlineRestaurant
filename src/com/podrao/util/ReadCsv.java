package com.podrao.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

import com.podrao.Dessert;
import com.podrao.Dish;
import com.podrao.MainCourse;
import com.podrao.OnlineOrder;
import com.podrao.Starter;

public class ReadCsv {
	 public static List<OnlineOrder> OpenCSV(String csvFileToRead){
		  //csvFileToRead = "./online_order_sample.csv";
		  Path csvFilePath = Paths.get(csvFileToRead);
		  String line = "";
		  String splitBy = ",";
		  List<OnlineOrder> orderList = new ArrayList<OnlineOrder>();
		  OnlineOrder order = new OnlineOrder();
		
		  try (BufferedReader br = Files.newBufferedReader(csvFilePath,StandardCharsets.US_ASCII);) {
		   br.readLine();
		   while ((line = br.readLine()) != null) {
		    String[] itens = line.split(splitBy);
		     order = new OnlineOrder((String) itens[0]);
		   
		    	switch (itens[2]) {
		    		case "st":
		    			Dish<String, Boolean, String> starterDish = new Starter(itens[1], Boolean.valueOf(itens[3]), Boolean.valueOf(itens[4]), Boolean.valueOf(itens[5]), Boolean.valueOf(itens[6]), itens[7]);
		    			order.setOrderDish(starterDish);
		    			break;
		    		case "mc":
		    			Dish<String, Boolean, String> mainCourseDish = new MainCourse(itens[1], Boolean.valueOf(itens[3]), Boolean.valueOf(itens[4]), Boolean.valueOf(itens[5]), Boolean.valueOf(itens[6]), itens[7]);
		    			order.setOrderDish(mainCourseDish);
		    			break;
		    		case "ds":
		    			Dish<String, Boolean, Integer> dessertDish = new Dessert(itens[1], Boolean.valueOf(itens[3]), Boolean.valueOf(itens[4]), Boolean.valueOf(itens[5]), Boolean.valueOf(itens[6]), Integer.valueOf(itens[7]));
		    			order.setOrderDish(dessertDish);
		    			break;
		    		default:
		    	}
		    orderList.add(order);
		   }
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  } catch (IOException e) {
			  e.printStackTrace();
		  } 
		  return orderList;
	 }
	 
	 public static List<Dish<String, Boolean, ? extends Serializable>> createDishList(List<OnlineOrder> orderList)  {
			List<Dish<String, Boolean, ? extends Serializable>> dishList = new ArrayList<>();
			for(OnlineOrder o: orderList){
				dishList.add(o.getOrderDish());
			}
			return dishList;
		}
}