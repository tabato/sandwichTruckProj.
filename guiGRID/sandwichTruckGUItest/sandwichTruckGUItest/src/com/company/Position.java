package com.company;

public class Position {
    private int x;
    private int y;

    Position() {
        //Constructor to clear a blank slate for the location of future objects.
        x = 0;
        y = 0;
    }

    Position(int x, int y) {
        //Constructor for when we are establishing a location with parameters
        this.x = x;
        this.y = y;
    }

    int xCoordinate(){
        return x;
    }

    int yCoordinate(){
        return y;
    }

    public Position setLocation (int x, int y){
        //Setting the next location our truck will move to
        this.x = x;
        this.y = y;
        Position destination = new Position(this.x, this.y);
        return destination;
    }

    public static double getDistance(Position p1, Position p2){
        double distance;
        distance = 0;
        return distance;
    }






}
