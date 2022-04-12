package sandwichOrders2.src;

public class Lettuce extends CondimentDecorator {
    Sandwich sandwich;

    public Lettuce(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Lettuce";
    }

    public double cost() {
        return .3 + sandwich.cost();
    }
}

