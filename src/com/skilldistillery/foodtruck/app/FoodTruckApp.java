package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {

		System.out.println("**Welcome to the Food Truck App**");

		// Gather user input on at least one and up to five trucks
		int numOfTrucksEntered = 1;
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
			Scanner kb1 = new Scanner(System.in);
			System.out.print("Enter the type of food: ");
			String typeOfFood = kb1.next();

			Scanner kb2 = new Scanner(System.in);
			System.out.print("Enter a rating on scale of 1-5: ");
			int rating = kb2.nextInt();

			// Create a new truck with the user's input, auto-assign an ID number
			FoodTruck foodTruck = new FoodTruck(numOfTrucksEntered, name, typeOfFood, rating);

			// Place the new truck into the array
			arrTrucks[i] = foodTruck;

			// increment counter of how many trucks have been entered
			numOfTrucksEntered++;
			if (numOfTrucksEntered > 4) { //why doesn't == 5 work here??
				System.out.println("That's five trucks, no more please.");
			}
		}
		while (true) {
			
			// Print out the menu
			System.out.println();
			System.out.println("** Option Menu **");
			System.out.println("1. List all existing food trucks");
			System.out.println("2. See the average rating of food trucks");
			System.out.println("3. Display the highest rated food truck");
			System.out.println("4. Quit the program");
			Scanner kb3 = new Scanner(System.in);
			int menuChoice = kb3.nextInt();

			//Determine the number of trucks in the array, store as int counter
			int counter = 0;
			for (int i = 0; i < arrTrucks.length; i++) {
				if (arrTrucks[i] != null) {
					counter++;
				}
			}
			//Perform calculations based on menu choice and print out answers
			switch (menuChoice) {
			case 1:
				for (int j = 0; j < counter; j++) {
					System.out.println(arrTrucks[j]);
				}
				break;
			case 2:
				double sum = 0;
				double avg = 0;
				for (int j = 0; j < counter; j++) {
					sum = sum + (arrTrucks[j].getRating()); // TODO possible double rounding error
					avg = sum / counter;
				}
				System.out.println("The average rating of all food trucks is " + avg);

				break;
			case 3:
				int starter = 0;
				int highest = 0;
				for (int j = 0; j < counter; j++) {
					starter = (arrTrucks[j].getRating());
					if (starter > highest) {
						highest = starter;
					}
				}
				for (int k = 0; k < counter; k++) {
					if (arrTrucks[k].getRating() == highest) {
						System.out.println("The truck with the highest rating is: " + arrTrucks[k]);
					}
				}
				break;
			case 4:
				System.out.println("Thanks for using the Food Truck App.");
				System.out.println("Please leave us a good review on the App Store!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid entry");
			}
		}
	}
}
