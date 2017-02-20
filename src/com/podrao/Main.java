package com.podrao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.podrao.util.ReadCsv;

public class Main {
	private static Scanner userInput;
	
	public static void p(String x){
		System.out.println(x);
	}

	public static void main(String[] args) {
		int inputOption = 0;
		int selectionOption = 0;
		String inputString = "";
		Operations operations = new Operations();
		userInput = new Scanner(System.in);
		List<Dish<String, Boolean, ? extends Serializable>> dishList = new ArrayList<Dish<String, Boolean, ? extends Serializable>>();
		List<OnlineOrder> orderList = null;
		
			do {
			switch(inputOption) {
			
			case 0:
				p("------------------------------------");
				p("Choose an option");
				p("------------------------------------");
				p("1 - Import CSV.");
				p("2 - Get the total number of orders.");
				p("3 - Get a specific order");
				p("4 - Get all Orders");
				p("5 - Get a specific dish");
				p("6 - Get all Dishes");
				p("7 - Get Dishes by type");
				p("8 - Get Dishes by Feature");
				p("9 - Get Dish types Statistics");
				p("10 - Get Dish features Statistics");
				p("11 - Exit");
				inputOption= userInput.nextInt();
				userInput.nextLine();
				break;
			
			case 1:
				p("Type the filename and press Enter: ");
				inputString = userInput.nextLine();
				orderList = ReadCsv.OpenCSV(inputString);
				dishList = ReadCsv.createDishList(orderList);
				p("File imported!");
				inputOption = 0;
				break;
			case 2:
				p("Number of Orders :"+operations.getNumberOrders(orderList));
				p("###########################");
				inputOption = 0;
				break;
			case 3:
				p("Select an order number from 1 to "+operations.getNumberOrders(orderList)+ ":");
				selectionOption = userInput.nextInt()-1;
				OnlineOrder o = operations.getOrder(orderList, selectionOption);
				p("The order belongs to "+ o.getClientName() + " and " + o.getOrderDish());
				p("###########################");
				inputOption = 0;
				break;
			case 4:
				p("Orders on current file.");
				operations.getAllOrdersToString(orderList);
				p("###########################");
				inputOption = 0;
				break;
			case 5:
				p("Select an dish number from 1 to "+operations.getNumberOrders(orderList)+":");
				selectionOption = userInput.nextInt()-1;
				p(""+operations.getDish(dishList, selectionOption));
				p("###########################");
				inputOption = 0;
				break;
			case 6:
				p("Dishes on current file.");
				operations.getAllDishToString(dishList);
				p("###########################");
				inputOption = 0;
				break;
			case 7:
				p("Select a Dish Type");
				p("1 - Starter");
				p("2 - Main Course");
				p("3 - Dessert");
				selectionOption = userInput.nextInt();
				switch(selectionOption){
				case 1:
					p(operations.getDishesByType(dishList, "Starter").toString());
					p("###########################");
					break;
				case 2:
					p(operations.getDishesByType(dishList, "Main Course").toString());
					p("###########################");
					break;
				case 3:
					p(operations.getDishesByType(dishList, "Dessert").toString());
					p("###########################");
					break;
				default:
				p("Select another option.");
				}
				selectionOption = 0;
				inputOption = 0;
				break;
			case 8:
				p("Select a Feature");
				p("1 - Gluten Free Dish");
				p("2 - Vegetarian Dish");
				p("3 - Hallal Meat Dish");
				p("4 - Seafood Dish");
				p("###########################");
				selectionOption = userInput.nextInt();
				switch(selectionOption){
				case 1:
					p(operations.getDishesByFeature(dishList, "gfd").toString());
					p("###########################");
					break;
				case 2:
					p(operations.getDishesByFeature(dishList, "vgd").toString());
					p("###########################");
					break;
				case 3:
					p(operations.getDishesByFeature(dishList, "hmd").toString());
					p("###########################");
					break;
				case 4:
					p(operations.getDishesByFeature(dishList, "sfd").toString());
					p("###########################");
					break;
				default:
					p("Invalid Option, choose again");
					selectionOption = 0;
				}
				selectionOption = 0;	
				inputOption = 0;
				break;
			case 9:
				p("Select a Dish Type");
				p("1 - Starter");
				p("2 - Main Course");
				p("3 - Dessert");
				selectionOption = userInput.nextInt();
				switch(selectionOption){
				case 1:
					p(operations.getStatsByDishType(dishList, "Starter"));
					p("###########################");
					break;
				case 2:
					p(operations.getStatsByDishType(dishList, "Main Course"));
					p("###########################");
					break;
				case 3:
					p(operations.getStatsByDishType(dishList, "Dessert"));
					p("###########################");
					break;
				default:
				p("Invalid option, please select another option.");
				p("###########################");
				}
				selectionOption = 0;
				inputOption = 0;
				break;
			case 10:
				// TO DO
				p("Select a Feature");
				p("1 - Gluten Free Dish");
				p("2 - Vegetarian Dish");
				p("3 - Hallal Meat Dish");
				p("4 - Seafood Dish");
				selectionOption = userInput.nextInt();
				switch(selectionOption){
				case 1:
					p(operations.getStatsByFeature(dishList, "gfd").toString());
					break;
				case 2:
					operations.getStatsByFeature(dishList, "vgd");
					p(operations.getStatsByFeature(dishList, "vgd").toString());
					break;
				case 3:
					operations.getStatsByFeature(dishList, "hmd");
					p(operations.getStatsByFeature(dishList, "hmd").toString());
					break;
				case 4:
					operations.getStatsByFeature(dishList, "sfd");
					p(operations.getStatsByFeature(dishList, "sfd").toString());
					break;
				default:
					p("Invalid Option, choose again");
					selectionOption = 0;
				}
				selectionOption = 0;	
				inputOption = 0;	
				break;
			case 11:
				p("------------------------------------");
				p("Good bye!");
				p("------------------------------------");
				break;
			default:
				p("Invalid Option, please select again.");
				p("###########################");
				inputOption = 0;
				break;
			}
		} while (inputOption !=11);
		p("Program Finished");
	}
}
