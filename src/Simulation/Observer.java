package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.io.IOException;


public interface Observer {


    void update(Order order) throws IOException;
}
