package sandwichOrders2.src;

public class Tomato extends CondimentDecorator {
    Sandwich sandwich;

    public Tomato(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Tomato";
    }

    public double cost() {
        return .40 + sandwich.cost();
    }
}

