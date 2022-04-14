package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Part of the decorator method, adds White Bread
 */
public class WhiteBread extends CondimentDecorator {
    Sandwich sandwich;

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public WhiteBread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    /*
Author : @ Jake Clause

Description - Basic getter method, returns description of White Bread
 */
    public String getDescription() {
        return sandwich.getDescription() + ", White Bread";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given White Bread is added
 */
    public double cost() {
        return .35 + sandwich.cost();
    }
}

