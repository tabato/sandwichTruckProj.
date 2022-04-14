package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.util.PriorityQueue;

/*
 CLass Orders creates an instance of an order and adds it to the priority queue
 @author COlin Conway
 */
public final class Orders {

    private static Orders INSTANCE = new Orders();
    private static PriorityQueue<Order> orders;

    private Orders() {}

    /*
    @return INSTANCE
    @author Colin Conway
     */
    public static Orders getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new Orders();
        }

        return INSTANCE;
    }

    /*
    @return null
    @return queue of orders
    @author Colin Conway
     */
    public PriorityQueue<Order> getOrders()
    {
        if (orders != null)
            return orders;
        return new PriorityQueue<Order>();
    }

    /*
    @param queue of newOrders
    @author Colin Conway
     */
    public void updateOrders(PriorityQueue<Order> newOrders)
    {
        orders = newOrders;
    }

    /*
    @return orders
    @author Colin Conway
     */
    public Order poll()
    {
        return orders.poll();
    }
}

