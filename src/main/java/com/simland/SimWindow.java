package com.simland;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

public class SimWindow {

    // Instance Variable
    private final JFrame frame;
    

    public SimWindow() {
        // Create Frame
        frame = new JFrame("SimWindow");

        // Set closing behavior
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Create components and put them in the frame

        // Create and place emptyLabel
        // JLabel label1 = new JLabel("Some Text and such", JLabel.CENTER);
        // frame.getContentPane().add(label1, BorderLayout.SOUTH);

        // Entity attributes: 
        double follower_velocity = 8.5;
        double leader_velocity = 8.5;

        // Draw entities and repaint
        Entity redLeader = new Entity(Color.RED, leader_velocity, 50, 50,15, 15, 1, 1, true );
        Entity blue = new Entity(Color.BLUE, follower_velocity, 150, 150, 15, 15, 0, 0, false);
        Entity green = new Entity(Color.GREEN, follower_velocity,250, 250,15, 15, 0, 0, false );
        Entity white = new Entity(Color.WHITE, follower_velocity, 350, 350, 15, 15, 0, 0, false);
        Entity yellow = new Entity(Color.YELLOW, follower_velocity, 450, 450,15, 15, 0, 0, false);
        Entity pink = new Entity(Color.PINK, follower_velocity, 550, 550, 15, 15, 0, 0, false);
        
                        // EXTRA ENTITIES
        // Entity blue1 = new Entity(Color.BLUE, follower_velocity, 150, 150, 15, 15, 0, 0, false);
        // Entity green1 = new Entity(Color.GREEN, follower_velocity,250, 250,15, 15, 0, 0, false );
        // Entity white1 = new Entity(Color.WHITE, follower_velocity, 350, 350, 15, 15, 0, 0, false);
        // Entity yellow1 = new Entity(Color.YELLOW, follower_velocity, 450, 450,15, 15, 0, 0, false);
        // Entity pink1 = new Entity(Color.PINK, follower_velocity, 550, 550, 15, 15, 0, 0, false);
        // Entity blue2 = new Entity(Color.BLUE, follower_velocity, 150, 150, 15, 15, 0, 0, false);
        // Entity green2 = new Entity(Color.GREEN, follower_velocity,250, 250,15, 15, 0, 0, false );
        // Entity white2 = new Entity(Color.WHITE, follower_velocity, 350, 350, 15, 15, 0, 0, false);
        // Entity yellow2 = new Entity(Color.YELLOW, follower_velocity, 450, 450,15, 15, 0, 0, false);
        // Entity pink2 = new Entity(Color.PINK, follower_velocity, 550, 550, 15, 15, 0, 0, false);

        // Create and place rendering panel        
        SimPanel panel = new SimPanel(Color.BLACK, 1200, 1600);        
        frame.getContentPane().add(panel, BorderLayout.CENTER);    

        // Add entities to arrayList
        panel.addEntity(redLeader);
        panel.addEntity(blue);
        panel.addEntity(green);
        panel.addEntity(white);
        
                        // EXTRA ENTITIES
        // panel.addEntity(yellow);
        // panel.addEntity(pink);
        // panel.addEntity(blue1);
        // panel.addEntity(green1);
        // panel.addEntity(white1);
        // panel.addEntity(yellow1);
        // panel.addEntity(pink1);
        // panel.addEntity(blue2);
        // panel.addEntity(green2);
        // panel.addEntity(white2);
        // panel.addEntity(yellow2);
        // panel.addEntity(pink2);
        panel.repaint();

        
        
        // Size the frame
        frame.pack();

        // Center frame on window
        frame.setLocationRelativeTo(null);

        // Show the window
        frame.setVisible(true);    
        
    }        
}

