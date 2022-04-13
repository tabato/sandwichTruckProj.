package sandwichOrders2.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;

import static java.lang.Thread.sleep;
/*
Author: Jake Clause


This program makes randomly generated sandwich orders. While it is all randomly generated it is set up to allow customers
pick whatever they want on the sandwich, and they can even have extra toppings or sauce on them. The final result is the
sandwich type listed with the ingredients and total cost.


 */
public class Main {

	private static final DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) throws FileNotFoundException {
		float cashregister = 0;

		PrintStream file = new PrintStream(new File("SandwichOrders.txt"));
		// Print to file
		System.setOut(file); // Selects file as output directory for everything below
		for (int i = 0; i < 100; i++) {
			makeSandwiches sandwich = new makeSandwiches();


			cashregister += sandwich.cost();
		}
		System.out.println("Total: $"+df.format(cashregister));
	}
}
