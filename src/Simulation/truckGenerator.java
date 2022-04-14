package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.io.IOException;

    /*
    Author: @ Thomas Abato

    Directions - Interface to construct the truck into the GUI and also to the observers
    */
public interface
truckGenerator {

        /*
        Author: @ Thomas Abato

        Directions - Registers the truck as an observer
        */
    void registerObserver(Observer display);

        /*
        Author: @ Thomas Abato

        Directions - Removes the truck as an observer
        */
    void removeObserver(Observer display);

        /*
            Author: @ Thomas Abato

            Directions - Notifys the observers acting as an update method
            */
    void notifyObserver(Order location) throws IOException;
}
