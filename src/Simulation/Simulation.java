package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
    Author: @ Thomas Abato
            @ Luka Suppa
            @ Colin Conway
            @ Jake Clause

    Description:
    - Serves as our main method
    - Runs a simulation/model for what our end product is going to look like for our customer
     */

public class Simulation
{
    // Constants
    private static final String FILE = "src/files/OrderList.txt";
    private static final String CONFIG_FILE = "src/files/config.txt";
    private static final int    NUM_VALUES = 8;
    // Config variables
    private static int   blocks;
    private static Point distributionCenter;
    private static int   guiSize;
    private static int   numAddresses;
    private static int   minTime, maxTime;
    private static int   minTimeBetweenOrders;
    // Class variables
    private static Orders orders;
    private static ArrayList<Order>     deliveredOrders;
    private static RouteMethod          routeMethod;
    private static ArrayList<Command>   commands;
    private static Command              currentCommand;

    /*
    Author: @ Thomas Abato

    Description:
    - Load configuration
    - Reads from the files, if there is another address, implememnt it
     */
    private static void loadConfiguration()
    {
        try
        {
            ArrayList<Integer> values = new ArrayList<>();
            Scanner scanner = new Scanner(new File(CONFIG_FILE));
            while (scanner.hasNext())
            {
                if (scanner.hasNextInt())
                    values.add(scanner.nextInt());
                else
                    scanner.next();
            }
            if (values.size() != NUM_VALUES)
                throw new Exception("Wrong number of config values.");
            blocks = values.get(0);
            distributionCenter = new Point(values.get(1), values.get(2));
            guiSize = values.get(3);
            numAddresses = values.get(4);
            minTime = values.get(5);
            maxTime = values.get(6);
            minTimeBetweenOrders = values.get(7);
        }
        catch (IOException e)
        {
            System.out.println("IOException encountered: " + e);
            System.exit(1);
        }
        catch (Exception e)
        {
            System.out.println("Exception encountered: " + e);
            System.exit(1);
        }
    }

        /*
        Author: @ Thomas Abato

        Description:
        - Updates the routes from the current state of the route
         */
    private static Route updateRoute(RouteMethod rm)
    {
        routeMethod = rm;
        Route route = routeMethod.calculateRoute(orders.getOrders(), distributionCenter);
        commands = route.getCommands();
        return route;
    }

    /*
    Author: @Colin Conway

    used to calculate the non chosen routes
    distance and time for comparison
     */
    private static Route updateRoute2(RouteMethod rm)
    {
        routeMethod = rm;
        Route route2 = routeMethod.calculateRoute(orders.getOrders(), distributionCenter);
        commands = route2.getCommands();
        return route2;
    }

    /*
    Author: @Colin Conway
    @param Route

    Displays information regarding RightHandTurnOnly Routes
     */
    private static void displayRightHandTurnResults(Route route)
    {
        int routeTimeHours = route.getTime() / 60;
        int routeTimeMinutes = route.getTime() % 60;

        System.out.println("Right Hand Turn Route: ");
        System.out.println("Route distance: " + (route.getDistance() / 10) + " miles");

        if(routeTimeHours != 0)
            if(routeTimeHours == 1)
                System.out.println("Route time = " + routeTimeHours + " hour, " + routeTimeMinutes + " minutes");
            else
                System.out.println("Route time = " + routeTimeHours + " hours, " + routeTimeMinutes + " minutes");
        else
            System.out.println("Route time = " + routeTimeMinutes + " minutes");

        System.out.println(" ");
    }

    /*
   Author: @Colin Conway
   @param Route

   Displays information regarding NoUTurn Routes
    */
    private static void displayNoUTurnResults(Route route)
    {
        int routeTimeHours = route.getTime() / 60;
        int routeTimeMinutes = route.getTime() % 60;

        System.out.println("No U Turn route: ");
        System.out.println("Route distance: " + (route.getDistance() / 10) + " miles");

        if(routeTimeHours != 0)
            if(routeTimeHours == 1)
                System.out.println("Route time = " + routeTimeHours + " hour, " + routeTimeMinutes + " minutes");
            else
                System.out.println("Route time = " + routeTimeHours + " hours, " + routeTimeMinutes + " minutes");
        else
            System.out.println("Route time = " + routeTimeMinutes + " minutes");

        System.out.println(" ");
    }


    /*
    Author: @ Thomas Abato

    Description:
    - Main that calls functions above
     */
    public static void main(String[] args)
    {
        loadConfiguration();

        Order.setNumAddresses(numAddresses);
        Order.setMinTimeDiff(minTimeBetweenOrders);
        Order.setMinTime(minTime);
        Order.setMaxTime(maxTime);
        Address.setBlocks(blocks);

        Order.writeOrders(FILE, numAddresses);

        orders = Orders.getInstance();
        PriorityQueue<Order> queueOrders = Order.readOrders(FILE);
        queueOrders.add(new Order(new Address(distributionCenter.x, distributionCenter.y), 1901, null));
        orders.updateOrders(queueOrders);
        deliveredOrders = new ArrayList<Order>();

        /*
    Author: @ Thomas Abato

    Description:
    - GUI that allows the user to select a route
     */
        String[] possibleValues = {"No U-turn Route", "Only Right-turn Route"};
        String selectedValue = (String) JOptionPane.showInputDialog(null, "Choose a Route",
                "Route Choice", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
        Route route;
        Route route2;
        // gets main route selection
        if (selectedValue.equals(possibleValues[0]))
            route = updateRoute(new NoUturnRoute());
        else
            route = updateRoute(new OnlyRightTurnRoute());

        // gets secondary route selection
        if (selectedValue.equals(possibleValues[0]))
            route2 = updateRoute2(new OnlyRightTurnRoute());
        else
            route2 = updateRoute2(new NoUturnRoute());

        // displays main route
        if (selectedValue.equals(possibleValues[0]))
            displayNoUTurnResults(route);
        else
            displayRightHandTurnResults(route);

        // displays secondary route
        if (selectedValue.equals(possibleValues[0]))
            displayRightHandTurnResults(route2);
        else
            displayNoUTurnResults(route2);

        // Draw the neighborhood with the addresses of the orders, distribution center, and truck shown

        NeighborhoodFrame neighborhood = new NeighborhoodFrame(guiSize, blocks, distributionCenter);

        neighborhood.update(orders.getOrders(), deliveredOrders);
        neighborhood.setVisible(true);

        //Getting the first command from the list if there is one
        if (!commands.isEmpty())
            currentCommand = commands.remove(0);
        else
        {
            System.out.println("This simulation had no commands");
            System.exit(1);
        }

        /*
    Author: @ Thomas Abato

    Description:
    - Action performed is a method to iterate through the animations of our GUI
     */
        Timer animationTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (currentCommand != null)
                {
                    if (commands.isEmpty() && currentCommand.getLength() < 1) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        System.exit(0);
                        return;
                    }

                    if (currentCommand.getLength() < 1)
                    {
                        currentCommand = commands.remove(0);
                        System.out.println(currentCommand);
                        return;
                    }
                    else
                        currentCommand.setLength(currentCommand.getLength() - 1);

                    if (currentCommand.getDirection() == Direction.NONE)
                    {

                        if (currentCommand.getLength() == 4)
                            deliveredOrders.add(orders.poll());
                        return;
                    }

                    Truck truck = neighborhood.getTruck();
                    Address truckAddress = truck.getAddress();
                    if (currentCommand.getDirection() == Direction.NORTH)
                        truckAddress.setY(truckAddress.getY() - 10);
                    else if (currentCommand.getDirection() == Direction.SOUTH)
                        truckAddress.setY(truckAddress.getY() + 10);
                    else if (currentCommand.getDirection() == Direction.EAST)
                        truckAddress.setX(truckAddress.getX() + 10);
                    else
                        truckAddress.setX(truckAddress.getX() - 10);
                    truck.setAddress(truckAddress);
                    neighborhood.setTruck(truck);

                    neighborhood.update(orders.getOrders(), deliveredOrders);
                }
            }
        });

        animationTimer.start();
    }
}


