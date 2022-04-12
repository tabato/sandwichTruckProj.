package sandwichOrders2.src;

public class WheatBread extends CondimentDecorator {
    Sandwich sandwich;

    public WheatBread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Wheat Bread";
    }

    public double cost() {
        return .45 + sandwich.cost();
    }
}

