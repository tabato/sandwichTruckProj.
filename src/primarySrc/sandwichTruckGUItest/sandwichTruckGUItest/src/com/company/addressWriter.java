package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;
import java.io.*;
import java.util.Random;

/*
Authors :
@ Thomas Abato
@ Colin Conway

Description: - Adaptation of the code written by Jake Clause
- Allows for it to be more easily read by our Address Book function within our address class
- Creates strings with the street and the house number to later be configured into destinations
    or postions to be drawn onto our GUI
 */

public class addressWriter {

    public static void addressWriter() throws IOException {
        PrintStream file = new PrintStream(new File("Houses.txt")); // creates a file with a path stream
        for (int i = 0; i < 100; i++) { // Replace the number after "i < " for many addresses you want
            Random rnd = new Random();
            int street1 = (rnd.nextInt(10) + 1);
            int house = (rnd.nextInt(9) + 1);
            int block = (rnd.nextInt(9) + 1);
            char street2 = (char) ('a' + rnd.nextInt(10));
            int random1or2 = (rnd.nextInt(2) + 1);
            String nHouse = String.valueOf(block) + String.valueOf(house) + "0"; // Merges block and house to create the house number
            //String address = (i+1) +".) (Street 1 (x): " + (street1) + ", Street 2 (y): " + street2 + ", House: " + nHouse + ")";
            if(random1or2 ==1)
            {
                String ezAddress = street1 + ", " + nHouse;
                System.setOut(file); // Selects file as output directory for everything below
                System.out.println(ezAddress); // Prints the address to the file. Replace "address" with "ezAdress" when needed
            }
            else
            {
                String ezAddress = street2 + ", " + nHouse;
                System.setOut(file); // Selects file as output directory for everything below
                System.out.println(ezAddress); // Prints the address to the file. Replace "address" with "ezAdress" when needed
            }
        }
    }
}
