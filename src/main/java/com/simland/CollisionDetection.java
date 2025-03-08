package com.simland;



public class CollisionDetection {
    
    // Checks all directions for collision with window border, if collision is detected, correct movement.

    public static void checkForCollision(int panelHeight, int panelWidth, Entity entity) {
        
        int nextX = entity.xpos + (int) (entity.velocity * entity.xmove);
        int nextY = entity.ypos + (int) (entity.velocity * entity.ymove);

        if (nextX < 0) {
            
            entity.xmove = 1; 
            nextX = 5;
            entity.xpos = 0;            
            
            entity.xpos += entity.velocity * entity.xmove;
            
        } else if (nextX > panelWidth + entity.width) {
            
            entity.xmove = -1;
            nextX = panelWidth;            
            entity.xpos = panelWidth - entity.width;
            
            entity.xpos += entity.velocity * entity.xmove;
            
        }
        
        if (nextY < 0) {

            entity.ymove = 1;
            nextY = 5;
            entity.ypos = 0;
            
            entity.ypos += entity.velocity * entity.ymove;

        } else if (nextY > panelHeight + entity.height) {

            entity.ymove = -1;
            nextY = panelHeight;
            entity.ypos = panelHeight - entity.height;

            entity.ypos += entity.velocity * entity.ymove;
        }        
    }
}
