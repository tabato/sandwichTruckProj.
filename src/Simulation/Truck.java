package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.io.IOException;
import java.util.ArrayList;

/*
    @author Thomas Abato
    Truck Class implements truckGenerator
    Gives the truck direction to next addresses
 */
public class Truck implements truckGenerator
{
    private Address   address;
    private double    x, y;
    private Direction direction;
    private ArrayList<Observer> observers;

    /*
    instantiates a new ArrayList and sets parameters
        @param double x x coordinate
        @param double y y coordinate
        @param Direction direction (direction to move up, down, left, or right)
        @author Thomas Abato
     */
    Truck(double x, double y,  Direction direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.observers = new ArrayList();
    }

    /*
    sets parameters
        @param Address address
        @param boolean moving
        @param Direction direction
        @author Thomas Abato
     */
    Truck(Address address, boolean moving, Direction direction)
    {
        this.address = address;
        this.direction = direction;
    }

    /*
    sets parameters
    @param x coord
    @param y coord
    @author Thomas Abato
    */
    Truck(double x, double y)
    {
        this(x, y, null);
    }

    /*
    sets parameters
    @param address
    @author Thomas Abato
    */
    Truck(Address address)
    {
        this(address, false, null);
    }

    Truck()
    {
        this(0, 0);
    }

    /*
    @return address
    @author Thomas Abato
     */
    public Address getAddress()
    {
        return address;
    }

    /*
    @return x
    @author Thomas Abato
     */
    public double getX()
    {
        return x;
    }

    /*
    @return y
    @author Thomas Abato
     */
    public double getY()
    {
        return y;
    }

    /*
    @return direction
    @author Thomas Abato
     */
    public Direction getDirection()
    {
        return direction;
    }

    /*
    @param address
    @author Thomas Abato
     */
    public void setAddress(Address address)
    {
        this.address = address;
    }

    /*
    @param x
    @author Thomas Abato
     */
    public void setX(double x)
    {
        this.x = x;
    }


    /*
    @param y
    @author Thomas Abato
     */
    public void setY(double y)
    {
        this.y = y;
    }


    /*
    @param direction
    @author Thomas Abato
     */
    public void setDirection(Direction direction)

    {
        this.direction = direction;
    }


    @Override
    public void registerObserver(Observer display) {
        observers.add(display);

    }

    @Override
    public void removeObserver(Observer display) {
        observers.remove(display);

    }

    @Override
    public void notifyObserver(Order location) throws IOException {
        for (Observer display : observers) {
            display.update(location);
        }

    }
}

