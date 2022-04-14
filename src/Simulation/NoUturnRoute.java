package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
/*
    Authors :
    @ Thomas Abato
    @ Luke Suppa

    Description: - Implementation of the RouteMethod interface
    - Uses the route, truck and future destination to calculate a route making no uturns
    (For our esaier understanding, not moving the opposite direction without first making a 90 degree turn)
 */

public class NoUturnRoute implements RouteMethod {
    private static Route route;
    private static Truck truck;

    /*
    Authors :
    @ Luke Suppa

    Description: - Safety by ensuring we have orders
    - Dictates a direction to begin
    - Iterates over until a turn is singaled
 */
    @Override
    public Route calculateRoute(PriorityQueue<Order> orders, Point center) {

        if (orders.isEmpty())
            generalCrash("Either there are no more orders, or we have run into an error.");

        route = new Route(0, 0, new ArrayList<>());
        truck = new Truck(new Address((int) center.getX(), (int) center.getY()));

        if (orders.peek().getAddress().getY() < truck.getAddress().getY())
            truck.setDirection(Direction.NORTH);
        else
            truck.setDirection(Direction.SOUTH);

        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order currentOrder = iterator.next();
            int curX = truck.getAddress().getX();
            int curY = truck.getAddress().getY();
            int destX = currentOrder.getAddress().getX();
            int destY = currentOrder.getAddress().getY();

            int vertDel = curY - destY; // Vertical delta
            int horDel = curX - destX;  // Horizontal delta

            // On vertical street
            if (curY % 100 != 0) {
                // If the truck is moving in the correct direction, move that way
                if (truck.getDirection() == Direction.NORTH && vertDel >= 0)
                    noUturnVertical(Direction.NORTH, horDel, destX, destY);
                else if (truck.getDirection() == Direction.SOUTH && vertDel < 0)
                    noUturnVertical(Direction.SOUTH, horDel, destX, destY);
                    // Else if the truck needs to avoid a U-turn, handle U-turn
                else
                    handleUturn(truck.getDirection(), destX, destY);
            }
            // On horizontal street
            else if (curX % 100 != 0) {
                // If the truck is moving in the correct direction, move that way
                if (truck.getDirection() == Direction.EAST && horDel <= 0)
                    noUturnHorizontal(Direction.EAST, horDel, destX, destY);
                else if (truck.getDirection() == Direction.WEST && horDel > 0)
                    noUturnHorizontal(Direction.WEST, horDel, destX, destY);
                    // Else if the truck needs to avoid a U-turn, handle U-turn
                else
                    handleUturn(truck.getDirection(), destX, destY);
            } else
                cornerCrash();

            // Each stop takes 5 units of time
            route.addCommand(new Command(5, Direction.NONE));
        }

        return route;
    }


    /*
    Authors :
    @ Luke Suppa

    Description: - Assists to create the route
    - Checks whether or not the car is on the correct horizontal street
    - Checks whether or not the car is on the correct vertical street
    - Dictates whether or not it is moving in the right direction
    - Ensures no uturns are made on a vertical access
 */

    private void noUturnVertical(Direction direction, int horDel, int destX, int destY) {
        if (destY % 100 == 0 || (destY % 100 != 0 && horDel != 0)) {
            moveNearestBlockToDestination(direction, truck.getAddress().getX(), truck.getAddress().getY(), destX, destY);
            if ((direction == Direction.SOUTH && horDel > 0) || direction == Direction.NORTH && horDel < 0) {
                route.setTime(route.getTime() + 2);
                if (direction == Direction.SOUTH)
                    direction = Direction.WEST;
                else
                    direction = Direction.EAST;
            } else {
                route.setTime(route.getTime() + 4);
                if (direction == Direction.SOUTH)
                    direction = Direction.EAST;
                else
                    direction = Direction.WEST;
            }
        }
        if (destY % 100 != 0 && horDel != 0) {
            int curY = truck.getAddress().getY();
            if (curY < destY)
                moveNearestBlockToDestination(direction, truck.getAddress().getX(), curY, destX, destY);
            if ((direction == Direction.EAST && curY > destY) || direction == Direction.WEST && curY < destY)
                route.setTime(route.getTime() + 2);
            else
                route.setTime(route.getTime() + 4);
        }
        moveDestination(truck.getAddress().getX(), truck.getAddress().getY(), destX, destY);
    }

    /*
    Authors :
    @ Luke Suppa

    Description: - Assists to create the route
    - Checks whether or not the car is on the correct horizontal street
    - Checks whether or not the car is on the correct vertical street
    - Dictates whether or not it is moving in the right direction
    - Ensures no uturns are made on a horiziontal access
 */
    private void noUturnHorizontal(Direction direction, int vertDel, int destX, int destY) {
        if (destX % 100 == 0 || (destX % 100 != 0 && vertDel != 0)) {
            moveNearestBlockToDestination(direction, truck.getAddress().getX(), truck.getAddress().getY(), destX, destY);

            if ((direction == Direction.EAST && vertDel < 0) || direction == Direction.WEST && vertDel > 0) {
                route.setTime(route.getTime() + 2);
                if (direction == Direction.EAST)
                    direction = Direction.SOUTH;
                else
                    direction = Direction.NORTH;
            } else {
                route.setTime(route.getTime() + 4);
                if (direction == Direction.EAST)
                    direction = Direction.NORTH;
                else
                    direction = Direction.SOUTH;
            }
        }
        if (destX % 100 != 0 && vertDel != 0) {
            int curX = truck.getAddress().getX();
            moveNearestBlockToDestination(direction, curX, truck.getAddress().getY(), destX, destY);
            // We make a turn depending on the shortest route
            if ((direction == Direction.SOUTH && curX > destX) || direction == Direction.NORTH && curX < destX)
                route.setTime(route.getTime() + 2);
            else
                route.setTime(route.getTime() + 4);
        }
        moveDestination(truck.getAddress().getX(), truck.getAddress().getY(), destX, destY);
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Assists to create the route
    - What to do given the best case scenario is making a uturn
    */
    private void handleUturn(Direction direction, int destX, int destY) {

        if (direction != null) {
            moveToEndOfBlock(direction, truck.getAddress().getX(), truck.getAddress().getY());
            moveRightOneBlock(direction, truck.getAddress().getX(), truck.getAddress().getY());
            truck.setDirection(getOppositeDirection(direction));
        } else
            generalCrash("U-Turn related crash");

        route.setTime(route.getTime() + 2);
        if (direction == Direction.NORTH || direction == Direction.SOUTH)
            noUturnVertical(truck.getDirection(), truck.getAddress().getX() - destX, destX, destY);
        else
            noUturnHorizontal(truck.getDirection(), truck.getAddress().getY() - destY, destX, destY);
    }


    /*
    Authors :
    @ Thomas Abato

    Description: - Assists to create the route
    - Changes the direction of the Truck
    */
    private void moveDestination(int curX, int curY, int destX, int destY) {
        Direction direction = null;
        int distance = Math.abs(curX - destX) + Math.abs(curY - destY);

        if (destX % 100 == 0) {
            if ((curY - destY) > 0)
                direction = Direction.NORTH;
            else
                direction = Direction.SOUTH;
        }
        else if (destY % 100 == 0) {
            if ((curX - destX) > 0)
                direction = Direction.WEST;
            else
                direction = Direction.EAST;
        }
        else
            cornerCrash();
        updateTruckAndRoute(direction, new Address(destX, destY), distance / 10, 0);
    }

    /*
     Authors :
     @ Thomas Abato

     Description: - Assists to create the route
     - Creates the next destination in relation to the nearest block
     */
    private void moveNearestBlockToDestination(Direction direction, int curX, int curY, int destX, int destY) {
        int distance = 0;

        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            destY = 100 * (destY / 100) + ((destY % 100 >= 50) ? 100 : 0);
            distance = Math.abs(curY - destY);
            destX = curX;
        } else if (direction == Direction.EAST || direction == Direction.WEST) {
            destX = 100 * (destX / 100) + ((destX % 100 >= 50) ? 100 : 0);
            distance = Math.abs(curX - destX);
            destY = curY;
        }

        updateTruckAndRoute(direction, new Address(destX, destY), distance / 10, 0);
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Assists to create the route
    - How to advance to the end of the block given any direction that you're moving
    */
    private void moveToEndOfBlock(Direction direction, int curX, int curY) {
        int distance = 0;
        int destX = 0;
        int destY = 0;

        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            destY = 100 * (curY / 100) + ((direction == Direction.SOUTH) ? 100 : 0);
            distance = Math.abs(curY - destY);
            // We only want to move vertically
            destX = curX;
        } else if (direction == Direction.EAST || direction == Direction.WEST) {
            destX = 100 * (curX / 100) + ((direction == Direction.EAST) ? 100 : 0);
            distance = Math.abs(curX - destX);
            // We only want to move horizontally
            destY = curY;
        }

        updateTruckAndRoute(direction, new Address(destX, destY), distance / 10, 0);
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Assists to create the route
    - Moving eaxctly one block to the right
    */
    private void moveRightOneBlock(Direction direction, int curX, int curY) {
        direction = getDirectionToRight(direction);
        if (direction == Direction.NORTH)
            curY -= 100;
        else if (direction == Direction.SOUTH)
            curY += 100;
        else if (direction == Direction.EAST)
            curX += 100;
        else
            curX -= 100;

        updateTruckAndRoute(direction, new Address(curX, curY), 10, 2);
    }


    /*
    Authors :
    @ Thomas Abato

    Description: - Assists to create the route
    - Acts as a setter for both direction and adderss, within this case is the next destination
    */
    private static void updateTruckAndRoute(Direction direction, Address destination, int distance, int time) {
        truck.setDirection(direction);
        truck.setAddress(destination);
        route.addCommand(new Command(distance, direction));
        route.setDistance(route.getDistance() + distance);
        route.setTime(route.getTime() + distance + time);
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Assists to create the route
    - basic return function to understand the opposite direction in which you are not travelling
    */
    private static Direction getOppositeDirection(Direction direction) {
        if (direction == Direction.NORTH)
            return Direction.SOUTH;
        else if (direction == Direction.SOUTH)
            return Direction.NORTH;
        else if (direction == Direction.EAST)
            return Direction.WEST;
        return Direction.EAST;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Assists to create the route
    - Basic return function to get the direction that is right of the current direction
    */
    private static Direction getDirectionToRight(Direction direction) {
        if (direction == Direction.NORTH)
            return Direction.EAST;
        else if (direction == Direction.SOUTH)
            return Direction.WEST;
        else if (direction == Direction.EAST)
            return Direction.SOUTH;
        return Direction.NORTH;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Safety net to call given something goes wrong to close the GUI and route
    */
    private static void generalCrash(String failure) {
        System.out.println("NoUturnRoute Failure: " + failure + "\nExiting program...");
        System.exit(1);
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Safety net specifically if the car goes off the road
    */
    private static void cornerCrash() {
        generalCrash("Truck crashed into corner of a street");
    }
}
