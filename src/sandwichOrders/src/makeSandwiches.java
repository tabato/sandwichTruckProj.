package sandwichOrders2.src;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Thread.sleep;

public class makeSandwiches {

    /*

    This part of the program is what makes the sandwiches. It gathers the requested ingredients from where need and
    creates the sandwiches.

     */


    // This is used to format the cost into a $00.00 pattern
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final Random rnd = new Random();
    private static final HashMap<Integer, Sandwich> sandwichHashMap = new HashMap<>();
    //private static final HashMap<Integer, Sandwich> toppingsHashMap = new HashMap<>();
    private static Sandwich sandwichType;
    public static float costOfsandwich = 0.00F;

    makeSandwiches() {
        initializeSandwichHashMap();
        //initializeToppingsHashMap();
        setSandwichType();
        randomSandwiches();
    }



    public void initializeSandwichHashMap(){
        sandwichHashMap.put(1, new Ham());
        sandwichHashMap.put(2, new Hamburger());
        sandwichHashMap.put(3, new Turkey());
    }

    /*
    public void initializeToppingsHashMap(){
        toppingsHashMap.put(1, sandwichType =  new Ketchup(sandwichType));
        toppingsHashMap.put(2, sandwichType =  new Cheese(sandwichType));
        toppingsHashMap.put(3, sandwichType =  new Lettuce(sandwichType));
        toppingsHashMap.put(4, sandwichType =  new Mayonnaise(sandwichType));
        toppingsHashMap.put(5, sandwichType =  new Mustard(sandwichType));
        toppingsHashMap.put(6, sandwichType =  new Tomato(sandwichType));
    }
     */

    public void randomSandwiches(){
        sandwichType = getSandwichType();
        getBreadTypes();
        getRandomToppings();
        /*
        getBreadTypes();
        getRandomToppings();
         */
        System.out.println(sandwichType.getDescription() + ", $" +df.format(sandwichType.cost()));
    }

    private Sandwich getSandwichType() {
        return sandwichType;
    }

    public void getBreadTypes(){
        if(sandwichType == sandwichHashMap.get(2)){
            sandwichType = new Bun(sandwichType);

        }else{
            int breadType = rnd.nextInt(3);
            if((breadType+1) == 1){
                sandwichType = new WhiteBread(sandwichType);
            }if((breadType+1) == 2){
                sandwichType = new WheatBread(sandwichType);
            }if((breadType+1) == 3){
                sandwichType = new RyeBread(sandwichType);
            }
        }
    }

    public void getRandomToppings(){
        boolean wantsToppings = rnd.nextBoolean();
        while(wantsToppings){
            boolean wantSauce = rnd.nextBoolean();
            if (wantSauce){
                boolean wantsKetchup = rnd.nextBoolean();
                if (wantsKetchup){
                    sandwichType = new Ketchup(sandwichType);
                }boolean wantsMustard = rnd.nextBoolean();
                if (wantsMustard){
                    sandwichType = new Mustard(sandwichType);
                }boolean wantsMayonnaise = rnd.nextBoolean();
                if (wantsMayonnaise){
                    sandwichType = new Mayonnaise(sandwichType);
                }
            }
            boolean wantsCheese = rnd.nextBoolean();
            if (wantsCheese){
                sandwichType = new Cheese(sandwichType);
            }boolean wantsLettuce = rnd.nextBoolean();
            if (wantsLettuce){
                sandwichType = new Lettuce(sandwichType);
            }boolean wantsTomato = rnd.nextBoolean();
            if (wantsTomato){
                sandwichType = new Tomato(sandwichType);
            }
            wantsToppings = rnd.nextBoolean();
        }
    }

    public void setSandwichType(){
        int sTypeInt = rnd.nextInt(3);
        sandwichType = sandwichHashMap.get(sTypeInt+1);
    }

    public float cost(){
        costOfsandwich = Float.parseFloat(df.format(sandwichType.cost()));
        return costOfsandwich;
    }

}



