import java.io.*;
import java.util.Random;

    /*
    Creator:
    Jake Clause

    Description:
    This creates 10 randomly generated address (coordinates) for the sandwich truck and puts them into a file called
    "Houses.txt".

    Variables:
    int street1 = x values (0-10)
    char street2 = y values (a-z)
    int house = Number value (0-10)
    int block = Number value (0-9) + 1
    String address = Randomly generated address neatly formatted
    String ezAddress = Same values as address but only contains values for easy manipulation
    String nHouse = Merges the house and block values together to create a new house value
     */

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream file = new PrintStream(new File("Houses.txt")); // creates a file with a path stream
        for (int i = 0; i < 100; i++) { // Replace the number after "i < " for many addresses you want
            Random rnd = new Random();
            int street1 = (rnd.nextInt(10) +1);
            int house = (rnd.nextInt(9) + 1);
            int block = (rnd.nextInt(9)+1);
            char street2 = (char) ('a' + rnd.nextInt(26));
            String nHouse = String.valueOf(block)+String.valueOf(house)+"0"; // Merges block and house to create the house number
            //String address = (i+1) +".) (Street 1 (x): " + (street1) + ", Street 2 (y): " + street2 + ", House: " + nHouse + ")";
            String ezAddress = "(" + street1 + ", " + street2 + ", " + nHouse + ")";
            System.setOut(file); // Selects file as output directory for everything below
            System.out.println(ezAddress); // Prints the address to the file. Replace "address" with "ezAdress" when needed
        }
    }
}
