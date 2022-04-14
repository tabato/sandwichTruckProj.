package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Part of the decorator method, adds Wheat Bread
 */
public class WheatBread extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public WheatBread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of Wheat Bread
 */
    public String getDescription() {
        return sandwich.getDescription() + ", Wheat Bread";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given Wheat Bread is added
 */
    public double cost() {
        return .45 + sandwich.cost();
    }
}

