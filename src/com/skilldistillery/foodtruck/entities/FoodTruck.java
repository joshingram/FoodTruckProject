package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private int ID;
	private String name;
	private String typeOfFood;
	private double rating;

	/// Be sure this is well encapsulated! ID, name, foodtype, rating 1-5

	public FoodTruck(String name, String typeOfFood, double rating) {
		this.name = name;
		this.typeOfFood = typeOfFood;
		this.rating = rating;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String toString() {
	    String output = "Truck ID#: " + ID + "Name: " + name + "Food Type:" + typeOfFood + "Rating: " + rating;
	    return output;
	  }
	
}
//be sure to include: constructors / setters and getters / a toString
