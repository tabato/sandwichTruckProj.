import java.io.*;
import java.util.Random;

    /*
    Creator:
    Jake Clause

    Description:
    This creates 100 randomly generated address for the sandwich truck and puts them into a file called
    "Houses.txt".

    Variables:
    int street1 = x values (0-10)
    char street2 = y values (a-z)
    int house = Number value (0-10)
    int block = Number value (0-9) + 1
    int min = Number value (0-58) + 1
    int hour = Number value (0-11) + 1
    String address = Produces a complete address for the truck by merging street1, street2, and nHouse
    String time = Produces a complete time for the delivery by merging hour, min, and "0" when needed
    String nHouse = Merges the house and block values together to create a new house value
     */

public class Main {
    public static void main(String[] args) throws IOException {
        PrintStream file = new PrintStream(new File("Houses.txt")); // creates a file with a path stream
        for (int i = 0; i < 100; i++) { // Replace the number after "i < " for many addresses you want
            // Values Configuration:
            Random rnd = new Random();
            int street1 = (rnd.nextInt(10) +1);
            int house = (rnd.nextInt(9) + 1);
            int block = (rnd.nextInt(9)+1);
            char street2 = (char) ('a' + rnd.nextInt(10));
            int random1or2 = (rnd.nextInt(2) + 1);
            int hour = (rnd.nextInt(12) + 1);
            int min = (rnd.nextInt(59) + 1);
            // Time Configuration:
            String time = null;
            if (min < 10){ // If min value is less than 10 then a 0 is added before the value
                time = String.valueOf(hour)+":0" +String.valueOf(min);
            }
            else{
                time = String.valueOf(hour)+":" +String.valueOf(min); // Merges hour and min value together
            }
            // Address Configuration:
            String nHouse = String.valueOf(block)+String.valueOf(house)+"0"; // Merges block and house to create the house number
            String address;
            if(random1or2 == 1){
                address = street1 + ", " + nHouse + ", " + "(" + time + ")";
            }
            else {
                address = street2 + ", " + nHouse + ", " + "(" + time + ")";
            }
            // Print to file
            System.setOut(file); // Selects file as output directory for everything below
            System.out.println(address); // Prints the address to the file.
        }
    }
}
