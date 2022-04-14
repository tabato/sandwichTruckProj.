package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Part of the decorator method, adds cheese
 */
public class Cheese extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Cheese(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of cheese
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Cheese";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given cheese is added
 */
    public double cost() {
        return .75 + sandwich.cost();
    }
}

