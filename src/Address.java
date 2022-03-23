package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
/*
Authors :
@ Thomas Abato
@ Colin Conway

Description: - Constructs our addresses for our address book
- Allows us to convert singular addresses into positions for our GUI
- Allows us build an address book for all of our orders
 */

public class Address {

    private static final String filename = "/Users/colinconway/Courses/Software_engineering/sandwichTruckProj./something.txt";
    // private static final String filename = "/Users/abatotmoravian.edu/MyCourses/234/sandwichTruckProj./something.txt";
    private final String street;
    private final int houseNumber;
    private final String timestamp;
    private static ArrayList<String> orderTime = new ArrayList<>();
    private static ArrayList<Position> addressBook = new ArrayList<>();
    private static HashMap<String, Position> addressBook2 = new HashMap<>();

    // ! DO NOT NEED FOR NOW ! private ArrayList<Address> addressBook;
    // ! DO NOT NEED FOR NOW ! private File filename = new File("houses.txt");

        // Address constructor for street name, house number
    public Address(String street, int houseNumber, String timestamp){
        this.timestamp = timestamp;

        if(isValidHouse(houseNumber)){
            this.houseNumber = houseNumber;
        }
        else {
            this.houseNumber = 0;
        }
        if(isValidStreet(street)){
            this.street = street.toLowerCase();
        }
        else{
            this.street = "Void";
        }
    }

        // returns house number
    public int getHouseNumber(){
        return this.houseNumber;
    }

        // returns street
    public String getStreet(){
        return this.street;
    }

    // public String getTimeStamp(){ return this.timestamp; }

        // Reads from the file & creates the array list for our addresses
//    public static ArrayList<Position> createAddressBook() throws FileNotFoundException {
//        ArrayList<Position> addressBook = new ArrayList<>();
//        Scanner scanner = new Scanner(new File(filename));
//        while(scanner.hasNextLine())
//        {
//            String line = scanner.nextLine();
//            String[] values = line.split(", ");
//            String[] address = values[1].split(", ");
//            String[] timestamp = line.split(", ");
//
//            if(Character.isDigit(values[0].charAt(0)))
//            {
//                int secondVal = Integer.parseInt(values[1]);
//                int firstVal = Integer.parseInt(values[0]);
//                Position nextPosition = new Position(((firstVal)*100-100), (secondVal-100));
//                addressBook.add(nextPosition);
//            }
//            else
//            {
//                char streetChar = values[0].charAt(0);
//                int streetCoord = alphabetConv(streetChar) + 1;
//                int firstValue = Integer.parseInt(values[1]);
//                Position nextPosition = new Position(((firstValue)-100), (streetCoord)*100 -100);
//                addressBook.add(nextPosition);
//            }
//
//
//            // (address[1])*100-100), address[0]
//            /*
//            Address fitAddress = new Address(address[1], Integer.parseInt(address[0]));
//            addressBook.add(fitAddress);
//             */
//
//            // IGNORE for future purposes.
//            /*
//            if(Character.isDigit(address[1].charAt(1))))
//            {
//                Position address
//            }
//             */
//        }
//
//        return addressBook; // returns the array list
//    }

    public static ArrayList<Position> createAddressBook() throws FileNotFoundException {
        // ArrayList<Position> addressBook = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] values = line.split(", ");
            String[] address = values[1].split(", ");
            String timestamp = String.valueOf(line.split(", "));

            if(Character.isDigit(values[0].charAt(0)))
            {
                int secondVal = Integer.parseInt(values[1]);
                int firstVal = Integer.parseInt(values[0]);
                Position nextPosition = new Position(((firstVal)*100-100), (secondVal-100));
                addressBook.add(nextPosition);
                addressBook2.put(timestamp, nextPosition);
            }
            else
            {
                char streetChar = values[0].charAt(0);
                int streetCoord = alphabetConv(streetChar) + 1;
                int firstValue = Integer.parseInt(values[1]);
                Position nextPosition = new Position(((firstValue)-100), (streetCoord)*100 -100);
                addressBook.add(nextPosition);
                addressBook2.put(timestamp, nextPosition);
            }

            orderTime.add(timestamp);

        }

        return addressBook; // returns the array list
    }

    /*
    Method createPriorityQueue
    returns: ArrayList<Position> orderedAddressBook
    
    The Method sorts an ArrayList of timestamps.  
    Uses a HashMap of timestamps as keys and Positions as values.
    Adds the Positions to a new ordered ArrayList using the ordered ArrayList of timestamps. 
    
    Author: Colin Conway 
     */
    public static ArrayList<Position> createPriorityQueue()
    {
        // ArrayList of Positions in correct timestamp order
        ArrayList<Position> orderedAddressBook = new ArrayList<>();

        // sorts ArrayList of timestamps in order
        Collections.sort(orderTime);

        // loop to add Positions in correct order to ArrayList orderedAddressBook
        for(int i = 0; i < orderTime.size(); i++)
        {
            orderedAddressBook.add(addressBook2.get(orderTime.get(i)));
        }

        // return ArrayList holding Positions in correct timestamp order
        return orderedAddressBook;
    }



    public static int alphabetConv(char input){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        int num = 0;
        for (int i =0; i <= 10; i++){
            if(input == alphabet[i]){
                int alphabetNum = i;
                return alphabetNum;
            }
        }
        return 0;
    }


    // CHECKS IF STREET IS VALID AND CONVERTS DEPENDING ON WHAT YOU NEED
    private boolean isValidStreet(String street){
        try{
            int streetNum = Integer.parseInt(street);
            return streetNum > 0 && streetNum < 11;
        }
        catch (Exception e){
            char streetLet = street.charAt(0);
            streetLet = Character.toLowerCase(streetLet);
            return streetLet >= 'a' && streetLet <= 'j';
        }
    }
    private boolean isValidHouse(int houseNumber){
        return (houseNumber < 991 && houseNumber > 99 && houseNumber % 2 == 0);
    }
}

