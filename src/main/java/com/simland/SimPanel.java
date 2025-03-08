package com.simland;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimPanel extends JPanel{

    // List of current entities on panel
    private ArrayList<Entity> entities;

    // Timer variables
    int FPS = 16; // 16 ms timer(60 FPS)

    
    // JPanel constructor
    public SimPanel() {               
    }
    
    // Background color constructor
    public SimPanel (Color bgColor) {
        this.setBackground(bgColor);
        this.entities = new ArrayList<>();
    }

    // Background color and window size constructor with FPS timer and leader entity
    public SimPanel (Color bgColor, int height, int width){
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(width, height));
        this.entities = new ArrayList<>();
                
        // Game loop timer
        new Timer(FPS, taskPerformer).start();
    }
    
    // Draw entities on JPanel
    @Override
    public void paintComponent(Graphics g) {
        // Clean panel before painting new objects.
        super.paintComponent(g);
        
        // Loop through entities list and draw each entity
        for (Entity entity : entities) {
            g.setColor(entity.color);
            g.fillOval(entity.xpos, entity.ypos, entity.width, entity.height);
        }
    }

    // Add entities to entity list
    public void addEntity(Entity e) {
        entities.add(e);
    }
   
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            for (Entity entity1 : entities) {
                //System.out.printf("Checking for redleader in ActionListener.\n entity1 = %s, redLeader = %s\n", entity1, redLeader);
                if (entity1.isLeader) {
                    entity1.move(SimPanel.this.getWidth(), SimPanel.this.getHeight());
                } else {
                    for (Entity entity2 : entities) {
                        // Entity cannot compare to itself
                        if (!entity1.equals(entity2)) {
                            // If entity is redLeader, follow
                            if (entity2.isLeader) {
                                entity1.moveFollow(entity2);
                            } 

                            //System.out.printf("Comparing entity %s to entity %s \n", entity1, entity2);
                            entity1.move(SimPanel.this.getWidth(), SimPanel.this.getHeight(), entity2.xpos, entity2.ypos);
                        }
                    }
                }
            }
            repaint();
        }
    };    
    
}
