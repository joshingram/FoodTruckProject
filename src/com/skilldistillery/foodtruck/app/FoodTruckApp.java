package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {

		//Creates a new FoodTruckApp instance which is used to call non static methods
		FoodTruckApp FTA = new FoodTruckApp();

		System.out.println("**Welcome to the Food Truck App**");

		// Gather user input on at least one and up to five trucks
		FoodTruck[] arrTrucks = FTA.makeTrucks();

		//Produces the menu, accepts choice input into switch, calls math methods based on choice
		FTA.runMenu(FTA, arrTrucks);
	}
	// Gather user input on at least one and up to five trucks, make a new truck with each set of arguments
	private FoodTruck[] makeTrucks() {
		int nextTruckId = 1;
		FoodTruck[] arrTrucks = new FoodTruck[5];
		for (int i = 0; i < arrTrucks.length; i++) {
			Scanner kb = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter the name of a food truck");
			System.out.print("or enter \"quit\" to finish entries: ");
			String name = kb.next();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.print("Enter the type of food: ");
			String typeOfFood = kb.next();

			System.out.print("Enter a rating on scale of 1-5: ");
			int rating = kb.nextInt();

			// Create a new food truck with the user's input (aka arguments)
			FoodTruck foodTruck = new FoodTruck(name, typeOfFood, rating);

			// Place the new food truck into the array
			arrTrucks[i] = foodTruck;
			
			// increment counter of how many food trucks have been entered
			nextTruckId++;
			if (nextTruckId > 5) {
				System.out.println();
				System.out.println("Whoa there! That's five food trucks, no more please.");
			}
		}
		return arrTrucks;
	}
	//Produces the menu, accepts choice input into switch, calls math methods based on choice
	private void runMenu(FoodTruckApp FTA, FoodTruck[] arrTrucks) {
		while (true) {

			// Call method to print out the menu
			FTA.printMenu();

			Scanner kb1 = new Scanner(System.in);
			int menuChoice = kb1.nextInt();

			// Call method to determine the number of trucks in the array, store as int counter
			int counter = FTA.countTrucks(arrTrucks);
			
			// Prints results from user choice, calls methods for calculations
			switch (menuChoice) {
			case 1:
				//returns a list of all trucks
				for (int j = 0; j < counter; j++) {
					System.out.println(arrTrucks[j]);
				}
				break;
			case 2:
				//calls method to calc the average rating
				FTA.getAverage(arrTrucks, counter);

				break;
			case 3:
				//calls method to determine the highest rated truck
				FTA.getHighest(arrTrucks, counter);
				break;
			case 4:
				//prints closing message and exits the program
				System.out.println("Thanks for using the Food Truck App.");
				System.out.println("Please leave us a good review on the App Store!");
				System.exit(0);
				break;
			default:
				//Because users make mistakes
				System.out.println("Invalid entry, try again - with feeling!");
			}
		}
	}
	// Determine the number of trucks in the array, store as int counter
	private int countTrucks(FoodTruck[] arrTrucks) {
		int counter = 0;
		for (int i = 0; i < arrTrucks.length; i++) {
			if (arrTrucks[i] != null) {
				counter++;
			}
		}
		return counter;
	}
	// Print out the menu
	private void printMenu() {
		System.out.println();
		System.out.println("** Option Menu **");
		System.out.println("1. List all existing food trucks");
		System.out.println("2. See the average rating of food trucks");
		System.out.println("3. Display the highest rated food truck");
		System.out.println("4. Quit the program");
	}
	//Calculate the average rating for all food trucks
	private void getAverage(FoodTruck[] arrTrucks, int counter) {
		double sum = 0;
		double twoDecimalAvg = 0;
		for (int j = 0; j < counter; j++) {
			sum = sum + (arrTrucks[j].getRating()); 
			double avg = sum / counter;
			double avgX100 = avg * 100;
			double avgCast = ((int)avgX100);
			twoDecimalAvg = avgCast/100;
		}
		System.out.println("The average rating of all food trucks is " + twoDecimalAvg);
	}
	//Determine the which truck has the highest rating and report if there is a tie
	private void getHighest(FoodTruck[] arrTrucks, int counter) {
		int starter = 0;
		int highest = 0;
		int tieCounter = -1;
		for (int j = 0; j < counter; j++) {
			starter = (arrTrucks[j].getRating());
			if (starter > highest) {
				highest = starter;
			}
		}
		for (int k = 0; k < counter; k++) {
			if (arrTrucks[k].getRating() == highest) {
				System.out.println("The truck with the highest rating is: " + arrTrucks[k]);
				tieCounter++;
			}
		}
		if (tieCounter > 0) {
			System.out.println("Wow, it's a tie!  Better go back for more data (e.g., food).");
		}
	}

}
