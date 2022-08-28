# Food Truck Project

## Details
This application asks users to enter data on up to five food trucks.  This data includes the truck's name, type of food served, and a rating from 1-5.  After entering the data, the user can choose from a menu which will display any of the following: 1) a list of all existing food trucks 2) the average rating of the food trucks 3) the highest-rated food truck or 4) Quit the program.  Upon quitting, the user is shown a parting message and the application ends.  Null fields resulting from entering fewer than five trucks will not be shown, nor will they impact the correct calculation of averages.  

## What I Learned
The main lesson of this application is the implications of static vs non-static methods and data.  Static methods/data belong to the class, while non-static data/methods must be accessed by an object.  Therefore, in order for the static main method in FoodTruckApp to access non-static methods in FoodTruckApp, it was necessary to create an instance (instantiate) of FoodTruckApp.

### Technologies Used
Java, Eclipse, git/gitHub, Zoom

### Java Functions Used
for loops, while loops, if/else if statements (with break), arrays, iterating over arrays, object creation, getters and setters, scanner, switch, private data, invoking methods, methods invoking methods, no argument constructor, constructors
