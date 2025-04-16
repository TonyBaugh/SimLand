package com.simland;

public class App {
    public static void main(String[] args) {
        // Start simulation
        new SimWindow(); 
    }

    
}


/*
 * Next Steps: 
 * 
 * Extend entity into 3 new classes: 
 * Food - Maximum number of food available to be spawned at any one time
 *      - Spawns in random locations
 * 
 * Prey - Is attracted to food
 *      - Is repelled by predators
 *      - Requires food to reproduce
 * 
 * Predator - Is attracted to Prey
 *          - Requires prey to survive
 *          - Possible reproduction? 
 */
