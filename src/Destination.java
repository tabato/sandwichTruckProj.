package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import java.awt.*;


/*
Author :
@ Thomas Abato

Description: - Declares positions onto the map, where we can call for, and paint onto the GUI
- Operates very similar to position with some additional features
 */

public class Destination {

    private Position destination;

    /*
    Author : @ Thomas Abato

    Constructor to establish a position as a destination
     */
    Destination(Position destination){
        this.destination = destination;
    }

    /*
    Author : @ Thomas Abato

    Gets the x position of a destination type
     */
    public int getX(Destination destination){
        return this.destination.xCoordinate();
    }

    /*
    Author : @ Thomas Abato

    Gets the y position of a destination type
     */
    public int getY(Destination destination){
        return this.destination.yCoordinate();
    }

        /*
        Author : @ Thomas Abato

        Paints the destination of the truck onto our map. Decided to be relocated
         */

    /*
    public void drawDestination(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.RED);
        g.fillOval(destination.xCoordinate(), destination.yCoordinate(), 5, 5);
    }

     */
}
