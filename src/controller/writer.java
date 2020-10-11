package swingy.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class writer {
    public static BufferedWriter writer;
    public static File file;
    public static ArrayList<String> saveFileContent = new ArrayList<String>();
    
    public static void storeMessage(String message) {
        saveFileContent.add(message);
    }

    public static void writeToFile() {
        try{
            writer = new BufferedWriter(new FileWriter("database.txt"));
            for (int i = 0; i < saveFileContent.size(); i++)
            writer.write(saveFileContent.get(i));
            writer.close();
        }
        catch (Exception exception)
        {
            System.out.println("Error: please check database file.");
        }
    }
}
