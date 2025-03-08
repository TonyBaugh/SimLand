package com.simland;

import java.awt.Color;

public class Entity {
    // Instance variables

    // Random movement generator
    int randMove = (int) (Math.random() * 3) - 1; // -1, 0, or 1

    // color
    Color color;
    // speed
    double velocity;
    // position
    int xpos;
    int ypos;
    // movement direction
    int xmove;
    int ymove;
    // size
    int height;
    int width;
    // is leader?
    boolean isLeader;

    // Allowable distance between entities
    int allowableDistanceFar = 50;
    int allowableDistanceClose = 50;


    // default no-args constructor
    public Entity() {

    }

    // add color constructor
    public Entity(Color color) {
        this.color = color;
    }

    // full customization constructor

    public Entity (Color color, Double velocity, int xpos, int ypos, int width, int height, int xmove, int ymove, boolean isLeader) {
        this.color = color;
        this.velocity = velocity;
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
        this.xmove = xmove;
        this.ymove = ymove;
        this.isLeader = isLeader;

    }


    /* 
                                                ******** movement method - basic border collision ********
    */ 
    public void move(int panelWidth, int panelHeight) {                       
        
        CollisionDetection.checkForCollision(panelHeight, panelWidth, this);
        xpos += velocity * randMove;
        ypos += velocity * randMove;
        
   }

    /*
     *                                      // Movement method - Collision detection and Entity Detection 
     */
    
    public void move(int panelWidth, int panelHeight, int otherXpos, int otherYpos) {
        
        // Predict next position before updating actual xpos and ypos
        int nextX = this.xpos + (int) (velocity * xmove);
        int nextY = this.ypos + (int) (velocity * ymove);        

        // ********* COLLISION DETECTION FIRST **********
        // Check if next position is out of bounds
        if (nextX < 0) {
            //System.out.printf("Wall detected at pixel %d, Reversing direction from current %d.\n", nextX, xmove);           
            xmove = 1; 
            nextX = 5;
            xpos = 0;            
            //System.out.printf("Movement reversed, direction now %d, nextX is now %d.\n", xmove, nextX);
            xpos += velocity * xmove;
            //System.out.printf("Attempting to move in direction: %d from pixel %d, nextX is %d.\n", xmove, xpos, nextX);
            nextX = xpos + (int) velocity;
            //System.exit(1);
        } else if (nextX > panelWidth + width) {
            //System.out.printf("Wall detected at pixel %d, Reversing direction from current %d.\n", nextX, xmove);           
            xmove = -1;
            nextX = panelWidth;
            //System.out.printf("Movement reversed, direction now %d, nextX is now %d.\n", xmove, nextX);
            xpos = panelWidth - width;
           //System.out.printf("Attempting to move in direction: %d from pixel %d, nextX is %d.\n", xmove, xpos, nextX); 
            xpos += velocity * xmove;
            //System.exit(1);
        }
        
        if (nextY < 0) {        
            ymove = 1;
            nextY = 5;
            ypos = 0;
            
            ypos += velocity * ymove;
        } else if (nextY > panelHeight + height) {
            ymove = -1;
            nextY = panelHeight;
            ypos = panelHeight - height;

            ypos += velocity * ymove;
        }

                                                                // ********* DISTANCE BETWEEN ENTITIES **********
        int currentXDistance = Math.max(xpos, otherXpos) - Math.min(xpos, otherXpos);
        int currentYDistance = Math.max(ypos, otherYpos) - Math.min(ypos, otherYpos);

                                                                          // *** OTHER ENTITY FAR ***
        // If other entity is to my left and > allowableDistance away, move left
        if (xpos > otherXpos && currentXDistance > allowableDistanceFar) {
            //System.out.printf("CurrentXdistance is %d and allowableDistanceFar is %d\n", currentXDistance, allowableDistanceFar);
            //System.out.println(this.color + "Collision.");
            //System.out.printf("My xpos is %d, other entity xpos is %d.\n", xpos, otherXpos);            
            xpos += velocity * -1;
            
            
        // If other entity is to my right and > allowableDistance away, move right
        } else if (xpos < otherXpos && currentXDistance > allowableDistanceFar) {
            xpos += velocity * 1;
            
        // If other entity is below me and > allowableDistance away, move down        
        } else if (ypos > otherYpos && currentYDistance > allowableDistanceFar) {
            ypos += velocity * -1;
            
        // If other entity is above me and > allowableDistance away, move up
        } else if (ypos < otherYpos && currentYDistance > allowableDistanceFar) {
            ypos += velocity * 1;
                                                  
                                                                            // *** OTHER ENTITY CLOSE ***
        // If other entity is on the left and <= allowableDistance, move right
        } else if (xpos > otherXpos && currentXDistance <= allowableDistanceClose) {
            //System.out.printf("CurrentXdistance is %d and allowableDistanceClose is %d\n", currentXDistance, allowableDistanceClose);
            
            //System.out.printf("My xpos is %d, other entity xpos is %d.\n", xpos, otherXpos); 
            xpos += velocity * 1;

        // If other entity is on the right and <= allowableDistance, move left
        } else if (xpos < otherXpos && currentXDistance <= allowableDistanceClose) {
            xpos += velocity * -1;

        // If other entity is above me and <= allowableDistance, move down
        } else if (ypos > otherYpos && currentYDistance <= allowableDistanceClose) {
            ypos += velocity * 1;

        // If other entity is below me and <= allowableDistance, move up
        } else if (ypos < otherYpos && currentYDistance <= allowableDistanceClose) {
            ypos += velocity * 1;
        }

    }

    /*
     *                                      // Movement method - Follow the leader movement 
     */

    public void moveFollow(Entity leader) {
        // Check leader direction and distance and set movement accordingly
        if (leader.xpos > xpos) {
            xpos += velocity * 1;
        }else if (leader.xpos < xpos) {
            xpos += velocity * -1;
        }
        
        if (leader.ypos > ypos) {
            ypos += velocity * 1;
        }else if (leader.ypos < ypos) {
            ypos += velocity * -1;}
        
    }

    // @Override
    // public String toString() {
    //     return "color" + this.color;
    // }
}
 
