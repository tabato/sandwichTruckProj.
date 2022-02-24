package com.company;

import java.awt.*;

public class Destination {

    private Position destination;

    Destination(Position destination){
        this.destination = destination;
    }


    // Paints the destination of the truck
    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.BLUE);
        g.fillOval(destination.xCoordinate(), destination.yCoordinate(), 5, 5);
    }
}
