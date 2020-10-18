package com.swingy.app;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Console
{
	public static void main(String[] args) {

	    //system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game variables
        String[] enemies = {"Cultist", "Goblin", "Golem", "Troll"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Player variables
        Integer health = 100;
        Integer attackDamage = 50;
        Integer numHealthPotions = 3;
        Integer healthPotionHealAmount = 30;
        Integer healthPotionDropChance = 50; //Percentage

        boolean running = true;

        System.out.println("\nWelcome to Whimsyshire");
        System.out.println("What would you like to do?\n\n" + "1)LOAD GAME\n" + "2)NEW GAME\n");

        String input1 = in.nextLine();
        
        if (input1.equals("1")) {

            try {
                ArrayList<String> playerData = new ArrayList<String>();
                File file = new File("database.txt");
                Scanner scan = new Scanner(file); 
                // String str = null;
                int[] arrayData;
                arrayData = new int[3];
                int i = 0;
    
                while (scan.hasNextLine()){
                    arrayData[i] = Integer.parseInt(scan.nextLine());
                    System.out.println(arrayData[i]);
                    i++;
                }
            }
            catch(FileNotFoundException exception) {
                System.out.println("Error: save file not found.");
                return;
            }
        }
        else if (input1.equals("2")) {
            
            GAME:
            while (running) {
                
                System.out.println("----------------------------------------");
                
                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies[rand.nextInt(enemies.length)];
                
                System.out.println("\n\t>> " + enemy + " appeared! <<\n");
                
                while (enemyHealth > 0) {
                    System.out.println("\tHero HP: " + health);
                    System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1)Attack");
                    System.out.println("\t2)Drink health potion");
                    System.out.println("\t3)Run!");
                    
                    String input = in.nextLine();
                    
                    if (input.equals("1")) {
                        int damageDealt = rand.nextInt(attackDamage);
                        int damageTaken = rand.nextInt(enemyAttackDamage);
                        
                        enemyHealth -= damageDealt;
                        health -= damageTaken;
                        
                        System.out.println("\t\n>>You attack the " + enemy + " for " + damageDealt + " points.<<");
                        System.out.println("\t\n>>You received " + damageTaken + " damage in battle!<<");
                        
                        if (health < 1) {
                            System.out.println("\t>>Y O U  D I E D  B R U H<<");
                            break;
                        }
                    }
                    else if (input.equals("2")) {
                        if (numHealthPotions > 0) {
                            health += healthPotionHealAmount;
                            numHealthPotions--;
                            System.out.println("\t>>You drank a health potion [+" + healthPotionHealAmount +" HP]<<" +"\n"
                            + "\t>>Hero health: " + health + " HP\n" + "\t>>You have " + numHealthPotions + " remaining.<<\n");
                        }
                        else {
                            System.out.println("\t>>You are out of health potions.<<");
                        }
                    }
                    else if (input.equals("3")) {
                        System.out.println("\t>>You fleed the " + enemy + "<<");
                        continue GAME;
                    }
                    else {
                        System.out.println("Error: Invalid command.");
                    }
                }
                
                if (health < 1) {
                    System.out.println("\t>>G A M E  O V E R !<<");
                    break;
                }
                System.out.println("----------------------------------------");
                System.out.println("\n\t>> " + enemy + " defeated! <<\n");
                System.out.println("\n\t>> Hero HP: " + health + " <<\n");
                
                if (rand.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println("\n\t>> The enemy dropped a health potion. <<\n");
                    System.out.println("\n\t>> Total health potions remaining: " + numHealthPotions + " <<\n");
                }
                
                // if (rand.nextInt(100) < weaponDropChance) {
                    //     System.out.println("\n\t>> The enemy dropped " + artifact + " <<\n");
                    //     System.out.println("\n\t>> Total health potions remaining: " + numHealthPotions + " <<\n");
                    // }
                    
                    System.out.println("----------------------------------------");
                    System.out.println("\n\t>> What would you like to do next? <<\n");
                    System.out.println("\t1)Keep exploring...");
                    System.out.println("\t2)Leave Whimsyshire");
                    
                    String input = in.nextLine();
                    
                    while (!input.equals("1") && !input.equals("2")) {
                        System.out.println("Error: Invalid command.");
                        input = in.nextLine();
                    }
                    
                    if (input.equals("1")) {
                        System.out.println("You venture deeper into the realm of Whimsyshire...");
                    }
                    else if (input.equals("2")) {
                        System.out.println("Would you like to save your game? Y/N");
                        input = in.nextLine();
                        if (input.equals("Y")) {
                            Writer.storeMessage(health.toString() + "\n");
                            Writer.storeMessage(attackDamage.toString() + "\n");
                            Writer.storeMessage(numHealthPotions.toString() + "\n");
                            Writer.writeToFile();
                            System.out.println("\nCharlie will miss you...");
                            break;
                        }
                        else if (input.equals("N")) {
                            System.out.println("Charlie will miss you...");
                            break;
                        }
                        System.out.println("---------------------");
                        System.out.println("|Thanks for playing!|");
                        System.out.println("---------------------");
                    }
                }
            }
        }
}