package swingy.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class reader {
    
    public static String loadHero() {

        ArrayList<String> Database = new ArrayList<String>();
        File file = new File("database.txt");
        Scanner scanner = new Scanner(file);
        String str;
        int nbr;

        if (args.length <= 0) {
            System.out.println("Error: invalid input. Please try again.");
        }
        
        try {
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            if (str.isEmpty()) {
                System.out.println("Error: Database file is empty.");
            }
            else {
                Database.add(str);
            }
            writer.writeToFile(Database);
            }
        }
        catch(IOException exception) {
            System.out.println("Error: file reader error.");
            System.exit(0);
        }
        
    }
}