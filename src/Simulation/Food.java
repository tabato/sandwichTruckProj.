package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;
/*
    Author: @ Jake Clause

    Description:
    - Creates food to be added to the orders using the decorator pattern
     */
public class Food
{
    private String name;

    /*
    Author: @ Jake Clause

    Description:
    - Food constructor given a name
     */
    public Food(String name)
    {
        this.name = name;
    }

    /*
    Author: @ Jake Clause

    Description:
    - Food constructor if no name is given
     */
    Food()
    {
        this("");
    }

    /*
    Author: @ Jake Clause

    Description:
    - Return method to return the string of the food's name
     */
    public String getName()
    {
        return name;
    }

    /*
    Author: @ Jake Clause

    Description:
    - Setter method to change or set the name of a food
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
    Author: @ Jake Clause

    Description:
    - Returns the foods name as a string
     */
    @Override
    public String toString()
    {
        return name;
    }
}
