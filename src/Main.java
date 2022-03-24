package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;


/*
Author :
@ Thomas Abato

Description: - Will cause the random houses code to run
- Call the mainframe where the standard GUI is built
 */


public class Main {

    public static void main(String[] args) throws IOException {
        addressWriter();
        mainFrame mainframe = new mainFrame();
    }

    /*
    Author :
    @ Jake Clause

    - Writes the orders (Address, Time, etc.) Into our bash file for use later

    Editors :
    @ Colin Conway
    - Added TimeStamps to be added to the batch file
    time is in military time in hours and minutes ranging from 11:00 to 16:59
    @ Thomas Abato
    - Cleaned up integration from seperate file to this file
     */
    public static void addressWriter() throws IOException {
        PrintStream file = new PrintStream(new File("something.txt")); // creates a file with a path stream
        for (int i = 0; i < 100; i++) { // Replace the number after "i < " for many addresses you want
            Random rnd = new Random();
            int street1 = (rnd.nextInt(10) + 1);
            int house = (rnd.nextInt(9) + 1);
            int block = (rnd.nextInt(9) + 1);
            char street2 = (char) ('a' + rnd.nextInt(10));
            int random1or2 = (rnd.nextInt(2) + 1);
            String nHouse = String.valueOf(block) + String.valueOf(house) + "0"; // Merges block and house to create the house number
            //String address = (i+1) +".) (Street 1 (x): " + (street1) + ", Street 2 (y): " + street2 + ", House: " + nHouse + ")";

            // gets a random time in hours from 11 to 16 (military time)
            int hour = rnd.nextInt(6) + 11;
            String hourString = Integer.toString(hour);
            // gets a random time in minutes from 0 to 59
            int minute = rnd.nextInt(61) + 1;
            String minuteString = Integer.toString(minute);

            // concatenates hour and minute to a string called time
            // is now ready to be added to batch file
            String time = hourString + minuteString;

            if(random1or2 ==1)
            {
                String ezAddress = street1 + ", " + nHouse + ", " + time;
                System.setOut(file); // Selects file as output directory for everything below
                System.out.println(ezAddress); // Prints the address to the file. Replace "address" with "ezAdress" when needed
            }
            else
            {
                String ezAddress = street2 + ", " + nHouse + ", " + time;
                System.setOut(file); // Selects file as output directory for everything below
                System.out.println(ezAddress); // Prints the address to the file. Replace "address" with "ezAdress" when needed
            }
        }
    }
}
