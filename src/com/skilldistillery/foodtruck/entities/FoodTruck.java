package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private int id;
	private String name;
	private String typeOfFood;
	private int rating;

	// TODO Be sure this is well encapsulated! ID, name, foodtype, rating 1-5

	public FoodTruck(int id, String name, String typeOfFood, int rating) {
		this.id = id;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String toString() {
	    String output = "Truck ID#: " + id + ", Name: " + name + 
	    		", Food Type: " + typeOfFood + ", Rating: " + rating;
	    return output;
	  }
	
}
//TODO be sure to include: constructors / setters and getters / a toString
