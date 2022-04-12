package sandwichOrders2.src;

public class Ketchup extends CondimentDecorator {
    Sandwich sandwich;

    public Ketchup(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Ketchup";
    }

    public double cost() {
        return .25 + sandwich.cost();
    }
}

