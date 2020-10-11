package swingy.model;

import java.util.Scanner;
import swingy.model.*;


public class hero {

   public hero() {
           
        String heroName;
        String heroClass;
        String currentWeapon;
        int defense;
        int hit;
        int hp;
        int level = 2;
        double xp;
        double exponent = 2;
        double attack;
        double base = (level - 1);
        
        hp = 100;
        xp = (level * 1000 + Math.pow(base, exponent) * 450);
        attack = 0.5;
        currentWeapon = swingy.model.artifacts.getCurrentWeapon();
        scanner = new Scanner(System.in);

        
        System.out.println("Please name your Hero:");
        heroName = scanner.nextLine();
        //write to file.

        System.out.println("Please select your Hero class:\n\n" + "1)Crusader\n2)Demon Hunter\n3)Monk\n4)Witch Doctor");
        heroClass = scanner.nextLine();
        
        if(heroClass.equals("1")) {
            heroClass = "Crusader";
        }
        else if(heroClass.equals("2")) {
            heroClass = "Demon Hunter";
        }
        else if(heroClass.equals("3")) {
            heroClass = "Monk";
        }
        else if(heroClass.equals("4")) {
            heroClass = "Witch Doctor";
        }
        else {
            System.out.println("Error: Invalid Input. Please enter a number between 1 and 4.");
        }
                
        heroData = System.out.print("Hero created successfully:" + "\n\n" + "Hero Name: " + heroName + "\n" + 
        "Hero Class: " + "\n" + heroClass + "\n" + "Weapon: " + currentWeapon + "\n" + "HP: " + 
        hp + "\n" + "LVL: " + (level) + "\n" + "ATK: " + attack);

        controller.writer.storeMessage(heroData);
   }

}
