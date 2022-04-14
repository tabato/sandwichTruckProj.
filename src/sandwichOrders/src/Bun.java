package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Part of the decorator method, adds a bun
 */

public class Bun extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Bun(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of a bun
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Bun";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given a bun is added
 */
    public double cost() {
        return .15 + sandwich.cost();
    }
}

