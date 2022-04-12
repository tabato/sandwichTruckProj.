package sandwichOrders2.src;

public class Bun extends CondimentDecorator {
    Sandwich sandwich;

    public Bun(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Bun";
    }

    public double cost() {
        return .15 + sandwich.cost();
    }
}

