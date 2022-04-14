package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.io.IOException;

/*
Authors :
        @ Thomas Abato

        Description: - Interface for the observer implmentation taught in class
        - Implemented through our Truck object

 */

public interface Observer {
    void update(Order order) throws IOException;
}
