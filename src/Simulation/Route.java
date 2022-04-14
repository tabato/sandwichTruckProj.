package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.util.ArrayList;

/*
    class Route
    contains getters and setters for route variables
    @author Luke Suppa
 */
public class Route
{
    private int                distance;
    private int                time;
    private ArrayList<Command> commands;

    /*
        @param int distance
        @param int time
        @param ArrayList<Command> commands
        @author Luke Suppa
     */
    Route(int distance, int time, ArrayList<Command> commands)
    {
        this.distance = distance;
        this.time = time;
        this.commands = commands;
    }

    Route() {}

    /*
     @return distance
     @author Luke Suppa
     */
    public int getDistance()
    {
        return distance;
    }

    /*
        @retun time
        @author Luke Suppa
     */
    public int getTime()
    {
        return time;
    }

    /*
        @return commands (type Array List)
        @author Luke Suppa
     */
    public ArrayList<Command> getCommands()
    {
        return commands;
    }

    /*
        @param int distance
        @author Luke Suppa
     */
    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    /*
        @param int time
        @author Luke Suppa
     */
    public void setTime(int time)
    {
        this.time = time;
    }

    /*
       @param ArrayList commands of type Command
       @author Luke Suppa
    */
    public void setCommands(ArrayList<Command> commands)
    {
        this.commands = commands;
    }

    /*
       @param command
       adds command to ArrayList of type Command
       @author Luke Suppa
    */
    public void addCommand(Command command)
    {
        commands.add(command);
    }
}

