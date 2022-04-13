package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

public class Command
{
    private int       length;
    private Direction direction;

    // Create an command with an order and a command type
    Command(int length, Direction direction)
    {
        this.length = length;
        this.direction = direction;
    }

    // Create a command that moves nowhere
    Command()
    {
        this(0, null);
    }

    public int getLength()
    {
        return length;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    @Override
    public String toString()
    {
        return "{length: " + length + "; direction: " + direction +  '}';
    }
}
