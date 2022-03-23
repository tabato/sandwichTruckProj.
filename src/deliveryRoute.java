package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class deliveryRoute extends Position{

    Position truck;
    Position destination;
    ArrayList<Position> orderedAddressBook;

    public deliveryRoute(Position truck, ArrayList<Position> orderedAddressBook){
        this.truck = truck;
        this.orderedAddressBook = orderedAddressBook;
    }

    //Gets position of the next address in the order
    public Position getTruckDestination(){
        int xCoordinate = orderedAddressBook.get(0).xCoordinate();
        int yCoordinate = orderedAddressBook.get(0).yCoordinate();
        destination.setLocation(xCoordinate, yCoordinate);
        return destination;
    }


    public double getDistanceBetweenTruckAndAddress(){
        return getDistance(truck, getTruckDestination());
    }

    /*
    Moves the truck horizontally by comparing the trucks coordinates to the destinations
    If we want the truck to move faster we can increase from 1 to 5, 10, etc.
    To make the truck move you'll have to call this method in a loop until the x coordinate of the
    destination equals the trucks x coordinate.
     */
    public void moveTruckHorizontally(){
        int destinationXCoordinate = orderedAddressBook.get(0).xCoordinate();
        if(truck.xCoordinate() > destinationXCoordinate){
            truck.setLocation(truck.xCoordinate() - 1, truck.yCoordinate());
        }
        else if(truck.xCoordinate() < destinationXCoordinate){
            truck.setLocation(truck.xCoordinate() + 1, truck.yCoordinate());
        }
        else {
            truck.setLocation(truck.xCoordinate(), truck.yCoordinate());
        }
    }

    /*
    Moves the truck vertically by comparing the trucks coordinates to the destinations
    If we want the truck to move faster we can increase from 1 to 5, 10, etc.
    To make the truck move you'll have to call this method in a loop until the y coordinate of the
    destination equals the trucks y coordinate.
     */
    public void moveTruckVertically(){
        int destinationYCoordinate = orderedAddressBook.get(0).yCoordinate();
        if(truck.yCoordinate() > destinationYCoordinate){
            truck.setLocation(truck.xCoordinate(), truck.yCoordinate() - 1);
        }
        else if(truck.yCoordinate() < destinationYCoordinate){
            truck.setLocation(truck.xCoordinate(), truck.yCoordinate() + 1);
        }
        else {
            truck.setLocation(truck.xCoordinate(), truck.yCoordinate());
        }
    }
}
