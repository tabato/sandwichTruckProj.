package sandwichOrders2.src;

/*
Author : @ Jake Clause

Description - A type of sandwich object
 */
public class Ham extends Sandwich {

    /*
Author : @ Jake Clause

Description - Constructor given a sandwich
 */
    public Ham() {
        description = "Ham Sandwich";
    }

    /*
Author : @ Jake Clause

Description - Basic return method for the sandiwch cost given a ham sandwich is created
 */
    public double cost() {
        return 1.50;
    }
}
