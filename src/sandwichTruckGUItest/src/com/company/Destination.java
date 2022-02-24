package com.company;

import java.awt.*;

// Declares positions onto the map, where we can call for, and paint onto the GUI
public class Destination {

    private Position destination;

        // Constructor to establish a position as a destination
    Destination(Position destination){
        this.destination = destination;
    }

    public int getX(Destination destination){
        return this.destination.xCoordinate();
    }

    public int getY(Destination destination){
        return this.destination.yCoordinate();
    }

        // Paints the destination of the truck onto our map.
    public void drawDestination(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.RED);
        g.fillOval(destination.xCoordinate(), destination.yCoordinate(), 5, 5);
    }
}
