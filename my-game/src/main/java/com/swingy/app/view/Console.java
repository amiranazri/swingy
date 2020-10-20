package com.swingy.app;

import java.util.*;
import java.lang.*;
import java.io.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Console
{
	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Integer health = 100;
        Integer attackDamage = 50;
        Integer numHealthPotions = 3;
        boolean running = true;

        System.out.println("\nWelcome to Whimsyshire");
        System.out.println("What would you like to do?\n\n" + "1)LOAD GAME\n" + "2)NEW GAME\n");

        String input1 = in.nextLine();
        
        if (input1.equals("1")) {

            try {
                ArrayList<String> playerData = new ArrayList<String>();
                File file = new File("database.txt");
                Scanner scan = new Scanner(file); 
                int[] arrayData;
                arrayData = new int[3];
                int i = 0;
    
                while (scan.hasNextLine()){
                    arrayData[i++] = Integer.parseInt(scan.nextLine());
                }
                Game.game(arrayData[0], true, arrayData[2], arrayData[3]);
            }
            catch(FileNotFoundException exception) {
                System.out.println("Error: save file not found.");
                return;
            }
        }
        else if (input1.equals("2")) {
            System.out.println("Please enter a name for your Hero: \n");
            @NotNull(message = "Name cannot be empty")
            @Size(min = 4, max = 20, message = "Name should be between 4 and 20 characters long.")
            final String name;
            name = in.nextLine();
            Game.game(health, running, attackDamage, numHealthPotions);
        }
    }
}