package sandwichOrders.src;

import java.util.ArrayList;

// abstract product
abstract public class Sandwich {
	String name;
	String bread;
	String cost;
	ArrayList ingredients = new ArrayList();


	public String getName() {
		return name;
	}
	public String getcost() {
		return cost;
	}

	/*
	public void prepare() {
		System.out.println("Preparing " + name);
	}

	public void box() {
		System.out.println("Boxing " + name);
	}

	 */

	public void cost(){

	}
	/*
	public String toString() {
		// code to display pizza name and ingredients
		StringBuffer display = new StringBuffer();
		display.append(name);
		//-
		display.append(bread + "\n");
		display.append(sauce + "\n");
		for (int i = 0; i < toppings.size(); i++) {
			display.append((String )toppings.get(i) + "\n");
		}
		display.append("$"+cost + "\n");
		//-
		display.append("The total is: $" + cost);
		return display.toString();
	}
	 */
}

