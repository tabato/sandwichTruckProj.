package sandwichOrders2.src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static java.lang.Thread.sleep;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream file = new PrintStream(new File("SandwichOrders.txt"));
		// Print to file
		System.setOut(file); // Selects file as output directory for everything below
		for (int i = 0; i < 100; i++) {
			new makeSandwiches();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
