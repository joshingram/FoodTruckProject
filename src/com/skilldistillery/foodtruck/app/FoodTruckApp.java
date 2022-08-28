package com.skilldistillery.foodtruck.app;

import java.lang.reflect.Method;
import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {

		FoodTruckApp FTA = new FoodTruckApp();

		System.out.println("**Welcome to the Food Truck App**");

		// Gather user input on at least one and up to five trucks
		int nextTruckId = 1;
		FoodTruck[] arrTrucks = new FoodTruck[5];
		for (int i = 0; i < arrTrucks.length; i++) {
			Scanner kb = new Scanner(System.in);
			System.out.println();
			System.out.println("Enter the name of a food truck");
			System.out.print("or enter \"quit\" to finish entries: ");
			String name = kb.next();
			if (name.equals("quit")) {
				break;
			}
			System.out.print("Enter the type of food: ");
			String typeOfFood = kb.next();

			System.out.print("Enter a rating on scale of 1-5: ");
			int rating = kb.nextInt();

			// Create a new food truck with the user's input, auto-assign an ID number
			FoodTruck foodTruck = new FoodTruck(name, typeOfFood, rating);

			// Place the new food truck into the array
			arrTrucks[i] = foodTruck;
			System.out.println(foodTruck.getId());
			// increment counter of how many food trucks have been entered
			nextTruckId++;
			if (nextTruckId > 5) {
				System.out.println();
				System.out.println("Whoa there! That's five food trucks, no more please.");
			}

		}
		while (true) {

			// Print out the menu
			FTA.printMenu();
			Scanner kb1 = new Scanner(System.in);
			int menuChoice = kb1.nextInt();

			// Determine the number of trucks in the array, store as int counter
			int counter = 0;
			for (int i = 0; i < arrTrucks.length; i++) {
//			for (FoodTruck truck : arrTrucks ) {
				if (arrTrucks[i] != null) {
					counter++;
				}
			}
			// Perform calculations based on menu choice and print out answers
			switch (menuChoice) {
			case 1:
				for (int j = 0; j < counter; j++) {
					System.out.println(arrTrucks[j]);
				}
				break;
			case 2:
				FTA.getAverage(arrTrucks, counter);

				break;
			case 3:
				FTA.getHighest(arrTrucks, counter);
				break;
			case 4:
				System.out.println("Thanks for using the Food Truck App.");
				System.out.println("Please leave us a good review on the App Store!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid entry, try again - with feeling!");
			}
		}
	}

	private void printMenu() {
		System.out.println();
		System.out.println("** Option Menu **");
		System.out.println("1. List all existing food trucks");
		System.out.println("2. See the average rating of food trucks");
		System.out.println("3. Display the highest rated food truck");
		System.out.println("4. Quit the program");
	}

	private void getAverage(FoodTruck[] arrTrucks, int counter) {
		double sum = 0;
		double avg = 0;
		for (int j = 0; j < counter; j++) {
			sum = sum + (arrTrucks[j].getRating()); // TODO possible double rounding error
			avg = sum / counter;
		}
		System.out.println("The average rating of all food trucks is " + avg);
	}

	private void getHighest(FoodTruck[] arrTrucks, int counter) {
		int starter = 0;
		int highest = 0;
		int tieCounter = 0;
		for (int j = 0; j < counter; j++) {
			starter = (arrTrucks[j].getRating());
			if (starter > highest) {
				highest = starter;
			} else if (starter == highest) {
				tieCounter++;
			}
		}
		for (int k = 0; k < counter; k++) {
			if (arrTrucks[k].getRating() == highest) {
				System.out.println("The truck with the highest rating is: " + arrTrucks[k]);
			}
		}
		if (tieCounter > 0) {  //TODO Tie function has a glitch, will return tie if two lower scores are equal
			System.out.println("Wow, it's a tie!  Better go back for more data (e.g., food).");
		}
	}

}
