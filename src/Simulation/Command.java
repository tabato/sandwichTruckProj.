package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

public class Command
    /*
    Author: @ Colin Conway

    Description:
    - Takes direction and length to dictate the movement of a given object
    - Called to move the truck (In a specific direction)
     */
{
    private int       length;
    private Direction direction;

    /*
    Author: @ Colin Conway

    Description:
    - Command constructor for a given order and direction
     */
    Command(int length, Direction direction)
    {
        this.length = length;
        this.direction = direction;
    }

    /*
    Author: @ Colin Conway

    Description:
    - Command constructor if it is necessary for the objcet to be still
     */
    Command()
    {
        this(0, null);
    }

    /*
    Author: @ Colin Conway

    Description:
    - Basic return method for the length of a command
     */
    public int getLength()
    {
        return length;
    }

    /*
    Author: @ Colin Conway

    Description:
    - Basic return method for the direction of a command
     */
    public Direction getDirection()
    {
        return direction;
    }

    /*
    Author: @ Colin Conway

    Description:
    - Basic setter method for the length of a command
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /*
    Author: @ Colin Conway

    Description:
    - Basic setter method for the direction of a command
     */
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    /*
    Author: @ Colin Conway

    Description:
    - Converts the command to a string
     */
    @Override
    public String toString()
    {
        return "(Length: " + length + "; Direction: " + direction +  ')';
    }
}
