package sandwichOrders2.src;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Random;

import static java.lang.Thread.sleep;

public class makeSandwiches {



    // This is used to format the cost into a $00.00 pattern
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final Random rnd = new Random();
    private static final HashMap<Integer, Sandwich> sandwichHashMap = new HashMap<>();
    private static final HashMap<Integer, Sandwich> toppingsHashMap = new HashMap<>();
    private static Sandwich sandwichType;

    makeSandwiches() {
        initializeSandwichHashMap();
        randomSandwiches();
    }

    public static Sandwich setSandwich() {
        int sTypeInt = rnd.nextInt(3)+1;
        sandwichType = sandwichHashMap.get(sTypeInt);
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (sTypeInt == 1 || sTypeInt == 3){
            int breadNum = rnd.nextInt(3)+1;
            if (breadNum == 1){
                sandwichType = new WhiteBread(sandwichType);
            }if (breadNum == 2){
                sandwichType = new WheatBread(sandwichType);
            }if (breadNum == 3){
                sandwichType = new RyeBread(sandwichType);
            }
        }else{
            sandwichType = new Bun(sandwichType);
        }

        return sandwichType;
    }

    private Sandwich getSandwich() {
        sandwichType = setSandwich();
        return sandwichType;
    }

    public void initializeSandwichHashMap(){
        sandwichHashMap.put(1, new Ham());
        sandwichHashMap.put(2, new Hamburger());
        sandwichHashMap.put(3, new Turkey());
    }

    public void initializeToppingsHashMap(){
        sandwichType = getSandwich();
        try {
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toppingsHashMap.put(1, sandwichType =  new Ketchup(sandwichType));
        toppingsHashMap.put(2, sandwichType =  new Cheese(sandwichType));
        toppingsHashMap.put(3, sandwichType =  new Lettuce(sandwichType));
        toppingsHashMap.put(4, sandwichType =  new Mayonnaise(sandwichType));
        toppingsHashMap.put(5, sandwichType =  new Mustard(sandwichType));
        toppingsHashMap.put(6, sandwichType =  new Tomato(sandwichType));
    }

    public void randomSandwiches(){
        initializeToppingsHashMap();
        sandwichType = toppingsHashMap.get(rnd.nextInt(toppingsHashMap.size()));
        System.out.println(sandwichType.getDescription() + ", $" +df.format(sandwichType.cost()));
    }

}

