package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - Abstract class for the sandwiches to be made after, works a lot like an interface
 */
public abstract class Sandwich {
    String description = "Unknown Sandwich";

    /*
Author : @ Jake Clause

Description - Abstract class method for all of the sandwiches to have a way of getting their general description
 */
    public String getDescription() {
        return description;
    }

    /*
Author : @ Jake Clause

Description - Abstract class method for all of the sandwiches to have a way of getting their total cost for the sandwich
 */
    public abstract double cost();
}
