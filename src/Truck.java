package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Truck extends JPanel {

    public Position position;
    public ArrayList<Position> destinations;
    public deliveryRoute route;

    Truck(Position position, ArrayList<Position> destinations, deliveryRoute route){
        this.position = position;
        this.destinations = destinations;
        this.route = route;
    }

    public Position getPosition(Truck t){
        this.position = position;
        return position;
    }

public boolean hasDestinations(){
        return !destinations.isEmpty();
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        Position destinationNow = destinations.get(0);

        if(position.equals(destinationNow)){
        destinations.remove(0);
        this.update(g);
        }
        else{
            if (destinationNow.yCoordinate() > position.yCoordinate()){

                if(position.yCoordinate() % 100 == 0 && position.yCoordinate() % 100 == 0)
                    position.setLocation(position.xCoordinate(), position.yCoordinate()+1);
                else{
                    position.setLocation(position.xCoordinate(), position.yCoordinate()+1);
                    destinations.add(0, destinationNow);
                }

            }
            else if (destinationNow.yCoordinate() < position.yCoordinate())
            {
                if(position.xCoordinate() % 100 == 0 && position.yCoordinate() % 100 == 0)
                    position.setLocation(position.xCoordinate(), position.yCoordinate()-1);
                else {
                    position.setLocation(position.xCoordinate(), position.yCoordinate()-1);
                    destinations.add(0, destinationNow);
                }
            }
            else if(destinationNow.xCoordinate() > position.xCoordinate()){
                if(position.xCoordinate() % 100 == 0 && position.yCoordinate() % 100 == 0)
                    position.setLocation(position.xCoordinate(), position.yCoordinate()-1);
                else {
                    position.setLocation(position.xCoordinate()+1, position.yCoordinate());
                    destinations.add(0, destinationNow);
                }
            }
            else if(destinationNow.xCoordinate() < position.xCoordinate()){
                if(position.xCoordinate() % 100 == 0 && position.yCoordinate() % 100 == 0)
                    position.setLocation(position.xCoordinate()-1, position.yCoordinate());
                else{
                    position.setLocation(position.xCoordinate()-1, position.yCoordinate());
                    destinations.add(0, destinationNow);
                }

            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(position.xCoordinate()-5, position.yCoordinate(), 11, 11);
    }

}
