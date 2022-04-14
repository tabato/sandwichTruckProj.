package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - A type of sandwich object
 */
public class Turkey extends Sandwich {

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Turkey() {
        description = "Turkey Sandwich";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandwich cost given a Turkey sandwich is created
 */
    public double cost() {
        return 1.50;
    }
}
