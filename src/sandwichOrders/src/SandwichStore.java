package sandwichOrders.src;


public class SandwichStore {
	SimpleSandwichFactory factory;
 
	public SandwichStore(SimpleSandwichFactory factory) {
		this.factory = factory;
	}
 
	public Sandwich orderSandwich(String type) {
		Sandwich sandwich;
 
		sandwich = factory.createSandwich(type);
 
		//sandwich.prepare();
		//sandwich.box();

		return sandwich;
	}

}
