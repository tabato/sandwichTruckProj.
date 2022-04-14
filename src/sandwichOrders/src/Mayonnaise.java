package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Part of the decorator method, adds Mayonnaise
 */
public class Mayonnaise extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Mayonnaise(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of Mayonnaise
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Mayonnaise";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given Mayonnaise is added
 */
    public double cost() {
        return .25 + sandwich.cost();
    }
}

