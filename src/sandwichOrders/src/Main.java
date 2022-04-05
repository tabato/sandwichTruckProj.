package sandwichOrders.src;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;
/*
Creator: Jake Clause

This program randomly generates sandwich orders with a timestamp and prints them to a file.




 */

public class Main {

	private static final DecimalFormat df = new DecimalFormat("0.00");
	private static final HashMap <Integer, Sandwich> sandwiches = new HashMap<>();
	private static float total = 0;
	private static final Random rnd = new Random();
	private static PrintStream file; // creates a file with a path stream
	// vv For the PrintStream file vv
	static {
		try {
			file = new PrintStream("SandwichOrders.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args){
		initializeHashMap();
		getSandwichOrder();
		System.out.println("\nThe total is: $"+ df.format(total));
	}

	// Generates a sandwich order with timestamp and writes to file
	private static void getSandwichOrder() {
		for (int i = 0; i < 100; i++) {
			int sandwichType = rnd.nextInt((10));
			Sandwich sandwich = sandwiches.get(sandwichType + 1);
			total += Float.parseFloat(String.valueOf(sandwich.getcost()));
			// Print to file
			System.setOut(file); // Selects file as output directory for everything below
			System.out.println(sandwich.getName() + ", " + getTime()); // Prints the address to the file.
		}
	}

	// Adds sandwichs to hashmap
	private static void initializeHashMap(){
		SimpleSandwichFactory factory = new SimpleSandwichFactory();
		SandwichStore store = new SandwichStore(factory);
		sandwiches.put(1, (store.orderSandwich("hamburger")));
		sandwiches.put(2, (store.orderSandwich("turkey")));
		sandwiches.put(3, (store.orderSandwich("ham")));
		sandwiches.put(4, (store.orderSandwich("tuna")));
		sandwiches.put(5, (store.orderSandwich("cheese")));
		sandwiches.put(6, (store.orderSandwich("egg")));
		sandwiches.put(7, (store.orderSandwich("roast")));
		sandwiches.put(8, (store.orderSandwich("nutella")));
		sandwiches.put(9, (store.orderSandwich("chicken")));
		sandwiches.put(10, (store.orderSandwich("meatball")));

	}

	// Creates a timestamp for sandwich order
	private static String getTime(){
		int hour = (rnd.nextInt(12) + 1);
		int min = (rnd.nextInt(59) + 1);
		// Time Configuration:
		String time = null;
		if (min < 10){ // If min value is less than 10 then a 0 is added before the value
			time = hour +":0" + min;
		} else{
			time = hour +":" + min; // Merges hour and min value together
		}
		if (hour < 10 || hour == 12){
			time += "PM";
		}if (hour == 10 || hour == 11){
			time += "AM";
		}
		return time;

	}

}
