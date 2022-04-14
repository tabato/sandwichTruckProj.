package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

    /*
    Author: @ Thomas Abato

    Description:
    - Updates the observer interface and those watching on call (Updates the truck every 300 milliseconds)
     */

public class display implements Observer {
    
    @Override
    public void update(Order address) throws IOException {
        System.out.println(address.getAddress());
        try {
            Thread.sleep(300);
        } catch (Exception ex) {
        }
    }
}
