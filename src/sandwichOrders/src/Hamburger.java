package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - A type of sandwich object
 */
public class Hamburger extends Sandwich {

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Hamburger() {
        description = "Hamburger";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandwich cost given a Hamburger sandwich is created
 */
    public double cost() {
        return 2.00;
    }
}
