package com.company;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame {

    MyPanel panel;

    mainFrame() {

        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
