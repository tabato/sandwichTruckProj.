package sandwichOrders2.src;

public abstract class Sandwich {
    String description = "Unknown Sandwich";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
