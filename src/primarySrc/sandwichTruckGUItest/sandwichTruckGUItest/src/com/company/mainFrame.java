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

        // Calls constructor
        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        this.setTitle("Sandwich Truck"); // TITLE

        // IGNORE BELOW ((TESTING FOR FUTURE SPRINTS))

        /* this.setTitle("SandwichTruck"); // TITLE
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400); // size of this
        this.setVisible(true); // visual this
        this.setResizable(false); // prevents movement
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon("milesmoralesItSV.jpeg");
        this.setIconImage(image.getImage()); //change icon of this
        this.getContentPane().setBackground(new Color(242, 210, 189)); // background color
         */
    }


}
