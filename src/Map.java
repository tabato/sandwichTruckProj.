/**
 * Map of Addresses
 * Author: Colin Conway
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Map {


    public Map() throws IOException {
        HashSet<String> set = new HashSet<>();
        String filename = "houseNumbers.txt";


        BufferedReader in = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = in.readLine()) != null) {
            line = line.trim();
            if ("".equals(line))
                continue;
            // If we get here, we have a valid word
            set.add(line.toLowerCase());
        }


        in.close();

        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

        System.out.println(set);





    }
}
