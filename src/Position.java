package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;
import java.lang.Math;



/*
Author :
@ Thomas Abato

Description: - Creates actual coordinates for us to paint objects onto our GUI
- Can attach a position or set of coordinates to any object or variable
 */
public class Position {
    private int x; // Basic x & y variables.
    private int y;

        //Constructor to clear a blank slate for the location of future objects.
    Position() {
        x = 0;
        y = 0;
    }

        //Constructor for when we are establishing a location with parameters
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

        // Returns x coordinate of our position
    int xCoordinate(){
        return x;
    }

        // Returns y coordinate of our position
    int yCoordinate(){
        return y;
    }

        //Setting the next location our truck will move to
    public Position setLocation (int x, int y){
        this.x = x;
        this.y = y;
        Position destination = new Position(this.x, this.y);
        return destination;
    }

        // Returns the distance between two positions
    public static double getDistance(Position p1, Position p2){
        double distance;
        double x1 = p1.xCoordinate();
        double y1 = p1.yCoordinate();
        double x2 = p2.xCoordinate();
        double y2 = p2.yCoordinate();
        distance = Math.sqrt ((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return distance;
    }






}
