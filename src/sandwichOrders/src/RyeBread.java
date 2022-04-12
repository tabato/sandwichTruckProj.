package sandwichOrders2.src;

public class RyeBread extends CondimentDecorator {
    Sandwich sandwich;

    public RyeBread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Rye Bread";
    }

    public double cost() {
        return .30 + sandwich.cost();
    }
}

