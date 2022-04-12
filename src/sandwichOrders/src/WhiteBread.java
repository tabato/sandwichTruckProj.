package sandwichOrders2.src;

public class WhiteBread extends CondimentDecorator {
    Sandwich sandwich;

    public WhiteBread(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", White Bread";
    }

    public double cost() {
        return .35 + sandwich.cost();
    }
}

