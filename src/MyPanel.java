package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.Delayed;

/*
Author :
@ Thomas Abato

Description: - A majority of the work is done here

There are more comments on the inside to further explain specifics, but as a result of some of the mess of integration,
I was forced to make a lot of the adjustments myself which made for some funky class decisions.
 */

public class MyPanel extends JPanel implements ActionListener{
    /*
    Author : @ Thomas Abato

    Constructor of the mypanel to be called
     */
    MyPanel(){
        this.setPreferredSize(new Dimension(900, 900));
    }

        /*
        Author : @ Thomas Abato

        The caller function that paints using the other classes, puts the pieces together on the GUI
         */

    Position truckPos = new Position(500,500);
    deliveryRoute route = new deliveryRoute(truckPos, Address.createPriorityQueue());
    Truck t = new Truck(truckPos, Address.createPriorityQueue(), route);

    public void paint(Graphics g) {

        try {
            drawRoads(g);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            drawDestinations(g);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            t.paintComponent(g);
        }



/*
    public void createTruck(Graphics g) throws FileNotFoundException {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g.setColor(Color.BLUE);
        g.fillRect(X, 500, 11, 11);
    }

 */

     Timer tm = new Timer(1, this);
     int X=500, velX=1;

    public void movingTruck(Graphics g) throws FileNotFoundException {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g.setColor(Color.BLUE);
        g.fillRect(X, 500, 11, 11);

        tm.start();
    }





        /*
        Author: @ Thomas Abato

        Paints the roads
         */
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

    }

    /*
    Author : @ Thomas Abato

    Paints the desinations of the road
     */
    public void drawDestinations(Graphics g) throws FileNotFoundException {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.RED);
        ArrayList<Position> addressBook = new ArrayList<>();
        addressBook = Address.createAddressBook();
        for (int i = 0; i < addressBook.size(); i++) {
            Destination nextDestination = new Destination(addressBook.get(i));
            g.fillOval(nextDestination.getX(nextDestination), nextDestination.getY(nextDestination), 10, 10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        X = X + velX;
        repaint();
    }



/*
    // Creating the Supply Center ! FOR NEXT SPRINT !
    public void createSupplyCenter(){
        Position scPosition = new Position(500,500);

    }

 */
}



