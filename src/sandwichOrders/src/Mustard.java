package sandwichOrders2.src;

public class Mustard extends CondimentDecorator {
    Sandwich sandwich;

    public Mustard(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Mustard";
    }

    public double cost() {
        return .25 + sandwich.cost();
    }
}

