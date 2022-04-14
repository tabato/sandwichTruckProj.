package sandwichOrders2.src;
/*
Author : @ Jake Clause

Description - Part of the decorator method, adds Ketchup
 */
public class Ketchup extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Ketchup(Sandwich sandwich) {
        this.sandwich = sandwich;
    }


    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of Ketchup
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Ketchup";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given ketchup is added
 */
    public double cost() {
        return .25 + sandwich.cost();
    }
}

