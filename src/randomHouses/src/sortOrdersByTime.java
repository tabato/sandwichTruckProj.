import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


/*
    Creator:
    Jake Clause

    Description:
    This sorts the file Houses.txt in order by time

    Variables:
    ArrayList<String> originalList = original list of orders
    String[] originalStamp = contains oringal list but allows easier manipulation than originalList
    LinkedList<Integer> hour = A linkedlist with all the hours. Will be used to manipulate sort
    LinkedList<String> newList = new list of orders
    int backCheck = It is used in the time configuration for an easier read. Checks behind the hour (in the list) in the for loop
    int forwardCheck = It is used in the time configuration for an easier read. Checks ahead the hour (in the list) in the for loop
    PrintStream file = file that contains the newly sorted orders
    BufferedReader reader = reads from Houses.txt
    String line = currently selected order
     */


public class sortOrdersByTime {

    static ArrayList<String> originalList = new ArrayList<>();
    static String[] originalStamp;
    static LinkedList<Integer> hour = new LinkedList<>();
    static LinkedList<String> newList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        getOriginalStamp();
        timeConfigure();
        updateFile();

    }


    private static void timeConfigure() {
        int backCheck = 0;
        int forwardCheck = 1;

        for (int i = 0; i < 99; i++) {
            if((hour.get(i) >= hour.getFirst()) && (hour.get(i) >= hour.get(forwardCheck) && (hour.get(i) >= hour.get(backCheck)))){
                newList.addFirst(String.valueOf(originalList.get(i)));
            }else{
                newList.addLast(String.valueOf(originalList.get(i)));
            }
            backCheck += 1;
            forwardCheck += 1;
        }

        System.out.println(newList.size());
    }


    private static void updateFile() throws IOException {
        PrintStream file = new PrintStream(new File("updatedFile.txt"));
        System.setOut(file);
        for (String s : newList) {
            System.out.println(s);
        }
    }


    public static void getOriginalStamp() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("Houses.txt"));
        String line;

        for (int i = 0; i < 100; i++) {
            line = reader.readLine();
            originalList.add(line);
            originalStamp = line.split(",");
            hour.add(Integer.valueOf(originalStamp[2]));
        }
    }
}
