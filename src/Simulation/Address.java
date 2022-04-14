package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company.Simulation;

import java.util.Random;


/*
Authors :
@ Thomas Abato

Description: - Constructs our addresses for our address book
- Allows us to convert singular addresses into positions for our GUI
- Allows us build an address book for all of our orders
 */


public class Address
{
    private static int blocks = 1; // Serves as a place holder for our block seperators
    private int x, y; // Serves as place holders for x & y

    /*
    Authors :
    @ Thomas Abato

    Description: - Constructs our addresses for our address book
    - Creates a random address based on the number of blocks in the neighborhood
    - Allows us build an address book for all of our orders
 */
    protected Address()
    {

        if ((new Random()).nextBoolean())
        {
            x = 100*(getRandomCoordinate(blocks)/100);
            y = getRandomCoordinate(blocks - 1);
        }
        else
        {
            x = getRandomCoordinate(blocks - 1);
            y = 100*(getRandomCoordinate(blocks)/100);
        }
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Constructs an address given a set of specific coordinates on our map
 */
    protected Address(int x, int y)
    {
        if((x >= 100 && x <= (blocks*100)) && (y >= 100 && y <= (blocks*100)))
        {
            this.x = x;
            this.y = y;
        }
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - generates a random coordinate on our map using both our blocks and coordinates
 */
    private int getRandomCoordinate(int nBlock)
    {
        Random rand = new Random();
        return (rand.nextInt(nBlock) + 1)*100 + (rand.nextInt(9) + 1)*10;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Basic return function for a x coordinate
 */
    public int getX()
    {
        return x;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Basic return function for a y coordinate
 */
    public int getY()
    {
        return y;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Basic return function for a house number
 */
    public int getHouseNumber()
    {
        return (x % 100 != 0) ? x : y;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Basic return function for a street number
 */
    public int getStreetNumber()
    {
        return ((x % 100 != 0) ? y : x) / 100;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Returns a direction based on our enum created to represent diretion for our truck
 */
    public char getDirection()
    {
        return (x % 100 != 0) ? 'E' : 'S';
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Basic setter function to establish a number of blocks on the address
 */
    public static void setBlocks(int blocks)
    {
        if (blocks > 0)
            Address.blocks = blocks;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Basic setter function to set the x coordinate of an address
    */
    public void setX(int x)
    {
        this.x = x;
    }

    /*
        Authors :
        @ Thomas Abato

        Description: - Basic setter function to establish a y coordinate for the address
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Puts the address coordinates into a simple string
 */
    @Override
    public String toString()
    {
        return x + "," + y;
    }

    /*
    Authors :
    @ Thomas Abato

    Description: - Returns true or false if the objbect's address matches the given coordinte
 */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Address)
        {
            Address o = (Address) obj;
            return x == o.x && y == o.y;
        }
        return false;
    }
}

