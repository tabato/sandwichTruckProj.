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
    private static final String FILE = "/Users/abatotmoravian.edu/MyCourses/234/sandwichTruckProj./src/files/OrderList.txt";
    private static final String CONFIG_FILE = "/Users/abatotmoravian.edu/MyCourses/234/sandwichTruckProj./src/files/config.txt";
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
    Author: @ Thomas Abato

    Description:
    - Main that calls functions above
     */
    public static void main(String[] args)
    {
        // Load configuration
        loadConfiguration();

        Order.setNumAddresses(numAddresses);
        Order.setMinTimeDiff(minTimeBetweenOrders);
        Order.setMinTime(minTime);
        Order.setMaxTime(maxTime);
        Address.setBlocks(blocks);

        // Write the specified number of random orders to a file
        Order.writeOrders(FILE, numAddresses);

        // Read the orders from the file and place them in a PriorityQueue. Instantiate deliveredOrders as an empty list
        orders = Orders.getInstance();
        PriorityQueue<Order> queueOrders = Order.readOrders(FILE);
        queueOrders.add(new Order(new Address(distributionCenter.x, distributionCenter.y), 1901, null));
        orders.updateOrders(queueOrders);
        deliveredOrders = new ArrayList<Order>();

        // Create the route the truck will follow and calculate how much time and distance the trip will take
        String[] possibleValues = {"No U-turn Route", "Only Right-turn Route"};
        String selectedValue = (String) JOptionPane.showInputDialog(null, "Choose a Route",
                "Route Choice", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
        Route route;
        if (selectedValue.equals(possibleValues[0]))
            route = updateRoute(new NoUturnRoute());
        else
            route = updateRoute(new OnlyRightTurnRoute());

        System.out.println("Route distance: " + route.getDistance());

        //Print the time to the standard output
        int routeTimeHours = route.getTime() / 60;
        int routeTimeMinutes = route.getTime() % 60;
        //Checking if there are any hours
        if(routeTimeHours != 0) {
            //Check if the hours is = 1, if so then print "hour" instead of "hours"
            if(routeTimeHours == 1){
                System.out.println("Route time = " + routeTimeHours + " hour, " + routeTimeMinutes + " minutes");

            }
            //Other wise print "hours"
            else {
                System.out.println("Route time = " + routeTimeHours + " hours, " + routeTimeMinutes + " minutes");
            }
        }
        //If not, print the time without the hours
        else {
            System.out.println("Route time = " + routeTimeMinutes + " minutes");
        }


        // Draw the neighborhood with the addresses of the orders, distribution center, and truck shown

        NeighborhoodFrame neighborhood = new NeighborhoodFrame(guiSize, blocks, distributionCenter);
        // Make the neighborhood visible

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


