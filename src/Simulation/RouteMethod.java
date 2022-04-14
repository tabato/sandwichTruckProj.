package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.awt.Point;
import java.util.PriorityQueue;

/*
    interface routeMethod
    The Route interface is the implementation of a Strategy design pattern within Simulation. The calculateRoute method
    is passed a PriorityQueue of orders and the distribution center's location.
    @author Colin Conway
 */
public interface RouteMethod
{
    Route calculateRoute(PriorityQueue<Order> orders, Point distrCenter);
}
