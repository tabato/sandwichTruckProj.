package sandwichOrders2.src;

public class Mayonnaise extends CondimentDecorator {
    Sandwich sandwich;

    public Mayonnaise(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Mayonnaise";
    }

    public double cost() {
        return .25 + sandwich.cost();
    }
}

