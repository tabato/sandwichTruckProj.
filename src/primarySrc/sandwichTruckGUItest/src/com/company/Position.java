package primarySrc.sandwichTruckGUItest.src.com.company;


// Creates actual coordinates for us to paint objects onto our GUI

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
        distance = 0;
        return distance;
    }






}
