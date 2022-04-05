package sandwichOrders.src;

// Concrete factory
public class SimpleSandwichFactory {

	public Sandwich createSandwich(String type) {
		Sandwich sandwich = null;
		if (type.equals("hamburger")) {
		sandwich = new Hamburger();
		}if (type.equals("turkey")) {
			sandwich = new Turkey();
		}if (type.equals("ham")) {
			sandwich = new Ham();
		}if (type.equals("tuna")) {
			sandwich = new Tuna();
		}if (type.equals("cheese")) {
			sandwich = new GrilledCheese();
		}if (type.equals("egg")) {
			sandwich = new Egg();
		}if (type.equals("roast")) {
			sandwich = new RoastBeef();
		}if (type.equals("nutella")) {
			sandwich = new Nutella();
		}if (type.equals("chicken")) {
			sandwich = new GrilledChicken();
		}if (type.equals("meatball")) {
			sandwich = new Meatball();
		}
		return sandwich;
	}
}
