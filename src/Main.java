package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import javax.swing.*;
import java.awt.*;
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