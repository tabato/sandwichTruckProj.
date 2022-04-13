package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.awt.Point;
import java.util.PriorityQueue;

public interface RouteMethod
{
    Route calculateRoute(PriorityQueue<Order> orders, Point distrCenter);
}
