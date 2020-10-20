package com.swingy.app;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Game{

    public static void game(Integer health, boolean running, Integer attackDamage, Integer numHealthPotions){

        Scanner in = new Scanner(System.in);
        Random rand = new Random();
    
        String[] enemies = {"Cultist", "Goblin", "Golem", "Troll"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;   
        Integer healthPotionHealAmount = 30;
        Integer healthPotionDropChance = 50;
        running = true;
    
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
                    continue;
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
                    continue;
                }
                else if (input.equals("2")) {
                    System.out.println("Would you like to save your game? Y/N");
                    input = in.nextLine();
                    
                    if (input.equals("Y")) {
                        Writer.storeMessage(health.toString() + "\n");
                        Writer.storeMessage(attackDamage.toString() + "\n");
                        Writer.storeMessage(numHealthPotions.toString() + "\n");
                        Writer.writeToFile();
                        System.out.println("\nCharlie will miss you...\n");
                        break;
                    }
                    else if (input.equals("N")) {
                        System.out.println("Charlie will miss you...\n");
                        break;
                    }
                    System.out.println("---------------------");
                    System.out.println("|Thanks for playing!|");
                    System.out.println("---------------------");
                }
            }
    }
        
    }