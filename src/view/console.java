package swingy.view;

import java.util.Scanner;
import swingy.controller.*;
import swingy.model.*;

public class console {
    
    public console() {}

    public void startGame() {
        
        scanner = new Scanner(System.in);
        String line = null;

        System.out.println("Welcome to Whimsyshire.\nPlease type 1 to create a NEW GAME or 2 to LOAD GAME.");

        if((line = scanner.nextLine()).isEmpty()) {
            System.out.println("Please enter a valid option.");
        }
        else if((!(line = scanner.nextLine()).equals("1") || !((line = scanner.nextLine()).equals("2")))) {
            System.out.println("Allowed Options: (1) AND (2)");
        }
        else if(line = scanner.nextLine().equals("1")) {
            this.newGame();
        }
        else {
            this.loadGame();
        } 
    }

    public void newGame() {
        
        model.hero();
    }

    public void loadGame() {
        
        System.out.println("Please select save slot: \n\n");
        System.out.println(model.hero.loadHero());
    }

}