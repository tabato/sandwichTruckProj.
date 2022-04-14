package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Part of the decorator method, adds Tomato
 */
public class Tomato extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause
Description - Constructor given a sandwich
 */
    public Tomato(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of Tomato
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Tomato";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given Tomato is added
 */
    public double cost() {
        return .40 + sandwich.cost();
    }
}

