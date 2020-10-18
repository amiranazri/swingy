// package com.swingy.app;

// import java.io.*;
// import java.util.*;

// public class Reader {
    
//     public static void saveFileReader(String health, String attackDamage, String numHealthPotions) {
        
//         try {
//             ArrayList<String> playerData = new ArrayList<String>();
//             File file = new File("database.txt");
//             Scanner scan = new Scanner(file); 
//             String str;
//             int i = 0;
//             String[] playerDataArray;

//             while (scan.hasNextLine()){
                
//                 str = scan.nextLine();
//                 playerData.add(str);
//                 System.out.println(str);
//                 i++;

//             }
//         }
//         catch(FileNotFoundException exception) {

//             System.out.println("Error: empty file.");
//             return;
//         }
//     }
// }