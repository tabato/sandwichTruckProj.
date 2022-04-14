package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

/*
    Author: @ Thomas Abato

    Description:
    - JFrame / GUI that both selects the route, and then displays the town and the truck moving forward
     */

public class NeighborhoodFrame extends JFrame {

    private static int guiSize;
    private static int blocks;
    private static Point distributionCenter;

    private double ratioSizeOfAddressesToMap;
    private double markerSize;
    private double blockWidth;
    private double offset;
    private Truck truck;

    /*
    Author: @ Thomas Abato

    Description:
    - Constructor for our GUI
    - Takes size, blocks and the center point
    - Establishes the basis of our GUI window
     */
    NeighborhoodFrame(int guiSize, int blocks, Point distributionCenter) {
        NeighborhoodFrame.guiSize = guiSize;
        NeighborhoodFrame.blocks = blocks;
        NeighborhoodFrame.distributionCenter = distributionCenter;
        truck = new Truck(new Address((int) distributionCenter.getX(), (int) distributionCenter.getY()));
        updateGuiSettings();

        setTitle("NeighborhoodFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(guiSize + roundToInt(offset + markerSize / 2), guiSize + roundToInt(offset + markerSize / 2) + 22);
        setResizable(false);
        setLocationRelativeTo(null); // center the map
    }

    /*
    Author: @ Thomas Abato

    Description:
    - update Gui to be called given any changes in the constructor
     */
    private void updateGuiSettings() {
        blockWidth = 1.0 * guiSize / (blocks - 1);
        if (blockWidth < 1)
            blockWidth = 1;
        markerSize = blockWidth / 10.0;
        if (markerSize < 1)
            markerSize = 1;
        ratioSizeOfAddressesToMap = guiSize / ((blocks - 1) * 100.0);
        offset = markerSize / 2;
    }

    /*
    Author: @ Thomas Abato

    Description:
    - Update function to draw the roads, home center, and destinations
    - Uses the repaint method to simulate the illusion of motion for our truck
     */
    public void update(PriorityQueue<Order> orders, ArrayList<Order> deliveredOrders) {
        JPanel canvas = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLUE);
                for (int x = 0; x < blocks - 1; x++)
                    for (int y = 0; y < blocks - 1; y++)
                        g.drawRect(roundToInt(blockWidth * x + offset), roundToInt(blockWidth * y + offset), roundToInt(blockWidth), roundToInt(blockWidth));

                g.setColor(Color.BLUE);
                double x = distributionCenter.getX() - 100; // Lowest address is at 110 so we subtract
                double y = distributionCenter.getY() - 100; // 100 to convert to GUI coordinates
                g.fillRect(getCoordinate(x), getCoordinate(y), roundToInt(markerSize), roundToInt(markerSize));

                g.setColor(Color.RED);
                Iterator<Order> iterator = orders.iterator();
                while (iterator.hasNext()) {
                    Address locationOfOrder = iterator.next().getAddress();
                    x = locationOfOrder.getX() - 100; // Lowest address is at 110 so we subtract
                    y = locationOfOrder.getY() - 100; // 100 to convert to GUI coordinates
                    g.fillOval(getCoordinate(x), getCoordinate(y), roundToInt(markerSize), roundToInt(markerSize));
                }
                g.setColor(Color.GREEN);
                iterator = deliveredOrders.iterator();
                while (iterator.hasNext()) {
                    Address locationOfOrder = iterator.next().getAddress();
                    x = locationOfOrder.getX() - 100; // Lowest address is at 110 so we subtract
                    y = locationOfOrder.getY() - 100; // 100 to convert to GUI coordinates
                    g.fillOval(getCoordinate(x), getCoordinate(y), roundToInt(markerSize), roundToInt(markerSize));
                }

                g.setColor(Color.BLACK);
                x = truck.getAddress().getX() - 100; // Lowest address is at 110 so we subtract
                y = truck.getAddress().getY() - 100; // 100 to convert to GUI coordinates
                g.fillRect(getCoordinate(x), getCoordinate(y), roundToInt(markerSize), roundToInt(markerSize));
            }
        };

        getContentPane().add(canvas);
        repaint();
    }

    /*
    Author: @ Thomas Abato

    Description:
    - Basic getter function for our coordinate
     */
    private int getCoordinate(double val) {
        return (int) (ratioSizeOfAddressesToMap * (val + offset - markerSize / 2));
    }

    /*
    Author: @ Thomas Abato

    Description:
    - Function to change a double to an integer(therefore rounding to the closest INT)
     */
    private int roundToInt(double val) {
        return (int) Math.round(val);
    }

    /*
        Author: @ Thomas Abato

        Description:
        - Basic getter function to return the truck
         */
    public Truck getTruck() {
        return truck;
    }

    /*
        Author: @ Thomas Abato

        Description:
        - Basic setter function to set a truck into the gui
         */
    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    /*

    Author: @ Thomas Abato

    Explanation - Anticipated methods to be called that proved not to be called this far into the sprint

    public double getMarkerSize() {
        return markerSize;
    }

    public double getBlockWidth() {
        return blockWidth;
    }

    public double getRatioSizeOfAddressesToMap() {
        return ratioSizeOfAddressesToMap;
    }

    public void setMarkerSize(int markerSize) {
        this.markerSize = markerSize;
    }

    public void setBlockWidth(int blockWidth) {
        this.blockWidth = blockWidth;
    }

    public void setRatioSizeOfAddressesToMap(double ratioSizeOfAddressesToMap) {
        this.ratioSizeOfAddressesToMap = ratioSizeOfAddressesToMap;

    }
    */
}
