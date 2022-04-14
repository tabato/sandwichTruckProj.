package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Part of the decorator method, adds Rye Bread
 */
public class RyeBread extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public RyeBread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of Rye Bread
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Rye Bread";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given Rye Bread is added
 */
    public double cost() {
        return .30 + sandwich.cost();
    }
}

