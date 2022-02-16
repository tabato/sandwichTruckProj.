import java.io.*;
import java.util.Random;

    /*
    Creator:
    Jake Clause

    Description:
    This creates 10 randomly generated address (coordinates) for the sandwich truck and puts them into a file called
    "Houses.txt".

    Variables:
    int street1 = x values
    int street2 = y values
    int house = Number value (1-10)
    String address = Randomly generated address neatly formatted
    String ezAddress = Same values as address but only contains values for easy manipulation
     */

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream file = new PrintStream(new File("Houses.txt")); // creates a file with a path stream
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            int street1 = (rnd.nextInt(10));
            int house = (rnd.nextInt(10));
            char street2 = (char) ('a' + rnd.nextInt(26));
            String address = (i+1) +".) (Street 1 (x): " + (street1+1) + ", Street 2 (y): " + street2 + ", House: " + (house+1)
                    + ")";
            //String ezAddress = (street1+1) + "," + street2 + "," + (house+1) + ")";
            System.setOut(file); // Selects file as output directory for everything below
            System.out.println(address); // Prints the address to the file. Replace "address" with ezAdress" when needed
        }
    }
}
