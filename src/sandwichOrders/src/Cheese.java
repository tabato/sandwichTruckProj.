package sandwichOrders2.src;

public class Cheese extends CondimentDecorator {
    Sandwich sandwich;

    public Cheese(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Cheese";
    }

    public double cost() {
        return .75 + sandwich.cost();
    }
}

