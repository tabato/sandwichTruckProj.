package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.io.IOException;

public interface
truckGenerator {

    void registerObserver(Observer display);

    void removeObserver(Observer display);


    void notifyObserver(Order location) throws IOException;
}
