package primarySrc.sandwichTruckGUItest.sandwichTruckGUItest.src.com.company;

import javax.swing.*;
import java.awt.*;

/*
Author :
@ Thomas Abato

Description: - Establishes our panel for our GUI, sends us to MyPanel class where the actual drawing can be completed
 */
public class mainFrame extends JFrame {

    MyPanel panel;

   mainFrame() {
        /*
        Author :
    @ Thomas Abato

    Description: - The constructor is to create the GUI, and some general window specs
         */

        panel = new MyPanel();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        this.setTitle("Sandwich Truck"); // TITLE

    }



}
