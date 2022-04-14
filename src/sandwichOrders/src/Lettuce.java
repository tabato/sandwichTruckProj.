package sandwichOrders2.src;
/*
Author : @ Jake Clause

Description - Part of the decorator method, adds Lettuce
 */
public class Lettuce extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Lettuce(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of Lettuce
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Lettuce";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given ketchup is added
 */
    public double cost() {
        return .3 + sandwich.cost();
    }
}

