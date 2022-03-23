import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

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

        for (int i = 0; i < 100; i++) { // This can be changed to " while(line !=null)" or change 3 to 100 when done
            //Original Order Stamp
            line = reader.readLine();
            originalList.add(line);
            originalStamp = line.split(",");
            hour.add(Integer.valueOf(originalStamp[2]));
        }
    }
}
