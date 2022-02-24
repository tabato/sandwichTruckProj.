package com.company;

import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;

//Will be used to draw anything on the map
public class MyPanel extends JPanel {

    MyPanel(){
        this.setPreferredSize(new Dimension(1000, 1000));
    }

        // Paints onto the GUI
    public void paint(Graphics g){
        drawRoads(g);
    }

        // Paints the roads
    public void drawRoads(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        // LABELS
        // g2D.drawString("A", 0, 0);

        // ROADS CREATION
        g2D.setPaint(Color.BLACK);
        g2D.setStroke(new BasicStroke(3));

        //Horizontal Roads
        g2D.drawLine(0, 0, 1000, 0);
        g2D.drawLine(0, 100, 1000, 100);
        g2D.drawLine(0, 200, 1000, 200);
        g2D.drawLine(0, 300, 1000, 300);
        g2D.drawLine(0, 400, 1000, 400);
        g2D.drawLine(0, 500, 1000, 500);
        g2D.drawLine(0, 600, 1000, 600);
        g2D.drawLine(0, 700, 1000, 700);
        g2D.drawLine(0, 800, 1000, 800);
        g2D.drawLine(0, 900, 1000, 900);
        g2D.drawLine(0, 1000, 1000, 1000);

        //Vertical Roads
        g2D.drawLine(0,0, 0, 1000);
        g2D.drawLine(100,0, 100, 1000);
        g2D.drawLine(200,0, 200, 1000);
        g2D.drawLine(300,0, 300, 1000);
        g2D.drawLine(400,0, 400, 1000);
        g2D.drawLine(500,0, 500, 1000);
        g2D.drawLine(600,0, 600, 1000);
        g2D.drawLine(700,0, 700, 1000);
        g2D.drawLine(800,0, 800, 1000);
        g2D.drawLine(900,0, 900, 1000);
        g2D.drawLine(1000,0, 1000, 1000);
    }

    // Creating the Supply Center
    public void createSupplyCenter(){
        Position scPosition = new Position(500,500);

    }

    // Creating the object that will represent the truck on the map
    public void createTruck()
    {
        Position stPosition = new Position(500,500);
    }

    // Creating the Destinations / ORDERS
    public void createDestination(Graphics g){
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
