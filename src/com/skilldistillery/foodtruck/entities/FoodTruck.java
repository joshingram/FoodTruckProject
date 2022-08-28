package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	//encapsulated data
	private static int totalTrucks = 1;
	private int id;
	private String name;
	private String typeOfFood;
	private int rating;

	// 3 arg constructor, automatically assigns Truck ID# and increments totalTruck
	// counter
	public FoodTruck(String name, String typeOfFood, int rating) {
		this.id = totalTrucks;
		this.name = name;
		this.typeOfFood = typeOfFood;
		this.rating = rating;
		totalTrucks++;
	}

	// no arg constructor for good practice
	public FoodTruck() {
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOfFood() {
		return typeOfFood;
	}

	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	// creates an explicit toString
	public String toString() {
		String output = "Truck ID#: " + id + ", Name: " + name + ", Food Type: " + typeOfFood + ", Rating: " + rating;
		return output;
	}

}
