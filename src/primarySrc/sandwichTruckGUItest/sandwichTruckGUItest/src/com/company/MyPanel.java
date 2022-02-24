package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

//Will be used to draw anything on the map

public class MyPanel extends JPanel {

    // Creates dimensions, constructor...
    MyPanel(){
        this.setPreferredSize(new Dimension(900, 900));
    }

        // Calls functions to paint onto the GUI
    public void paint(Graphics g) {
        try {
            drawRoads(g);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

        // Paints the roads
    public void drawRoads(Graphics g) throws FileNotFoundException {

        // Establishes Graphics
        Graphics2D g2D = (Graphics2D) g;

        // ROADS CREATION SPECIFCATIONS
        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(3));

        // Horizontal Roads
        g2D.drawLine(0, 0, 900, 0);
        g2D.drawLine(0, 100, 900, 100);
        g2D.drawLine(0, 200, 900, 200);
        g2D.drawLine(0, 300, 900, 300);
        g2D.drawLine(0, 400, 900, 400);
        g2D.drawLine(0, 500, 900, 500);
        g2D.drawLine(0, 600, 900, 600);
        g2D.drawLine(0, 700, 900, 700);
        g2D.drawLine(0, 800, 900, 800);
        g2D.drawLine(0, 900, 900, 900);

        // Vertical Roads
        g2D.drawLine(0,0, 0, 900);
        g2D.drawLine(100,0, 100, 900);
        g2D.drawLine(200,0, 200, 900);
        g2D.drawLine(300,0, 300, 900);
        g2D.drawLine(400,0, 400, 900);
        g2D.drawLine(500,0, 500, 900);
        g2D.drawLine(600,0, 600, 900);
        g2D.drawLine(700,0, 700, 900);
        g2D.drawLine(800,0, 800, 900);
        g2D.drawLine(900,0, 900, 900);

        // Draws Destinations
        g2D.setPaint(Color.RED);
        ArrayList<Position> addressBook = new ArrayList<>();
        addressBook = Address.createAddressBook();
        for (int i = 0; i < addressBook.size(); i++) {
            Destination nextDestination = new Destination(addressBook.get(i));
            g.fillOval(nextDestination.getX(nextDestination), nextDestination.getY(nextDestination), 10, 10);
        }
        // Destination nextDestination = new Destination(addressBook.get(0));
        // g.fillOval(nextDestination.getX(nextDestination), nextDestination.getY(nextDestination), 10, 10);
    }

    // Creating the Supply Center ! FOR NEXT SPRINT !
    /*
    public void createSupplyCenter(){
        Position scPosition = new Position(500,500);

    }
     */

    // Creating the object that will represent the truck on the map ! FOR NEXT SPRINT
    /*
    public void createTruck()
    {
        Position stPosition = new Position(500,500);
    }
     */

    // Mind Freedom !!!!!
    // ArrayList<Position> addressBook = new ArrayList<>();
    public void createDestinations() throws FileNotFoundException {
        /*
        addressBook = Address.createAddressBook();
        Destination nextDestination = new Destination(addressBook.get(0));

        nextDestination.drawDestination();

         */
    }

    // Create Destination / ORDERS
    public void createDesination(){

    }

    // Draw the Destinations / ORDERS
    public void drawDestination(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.RED);


        // Iterator<E> iterator =
        /*
        while (iterator.hasNext())
        {
            Address dotForOrder = iterator.next().getAddress();
            x = dotForOrder.getX();
        }
         */
    }


}
