/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.littlejavafun;

/**
 *
 * @author duane
 */
import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class LittleJavaFun {

    static List<ObjectMaker> objectling = new ArrayList<>();
    static int option = 0;
    static int bronchitis = 32;
    static char[] chars = new char[bronchitis];

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            
            System.out.println("""
                               
                           Hello! This project generates a number of objects with random UUIDs and puts them in a .txt file.
                           You can also generate a randomized string formed from that arraylist (Might be useful for making passwords!)
                           
                           ----------------------------------------------------Menu----------------------------------------------------
                                                                1. Generate UUIDs only
                                                                2. Generate Passwords only
                                                                3. Generate both
                                                                4. Close Program
                           ------------------------------------------------------------------------------------------------------------
                           """);
            try {
                option = scn.nextInt();
                optionSelect();
            } catch (InputMismatchException e) {//If user enters anything but an int it throws this error
                System.out.println("Please only pick from options 1-4. (Ints only)");
                scn.nextLine();
            }
            
        }
        
    }
    
    static void optionSelect() {
            switch (option) {
                case 1:
                    uuidToTxtFile();
                    break;
                case 2:
                    passFromList();
                    break;
                case 3:
                    uuidToTxtFile();
                    passFromList();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default://If user chooses an int not within 1-4
                    System.out.println("Please only pick from options 1-4.");
            }
    }

    static void uuidToTxtFile() {
        //Deletes UUID.txt file if it already exist.
        File uuidsFile = new File("UUIDs.txt");
        if (uuidsFile.delete()) {
            System.out.println("Deleted file: " + uuidsFile.getName() + "\n");
        } else {
            System.out.println("Failed to delete the file. \n");
        }//IfEnd

        //Adds 9 objects into this arrayList
        for (int i = 0; i < 9; i++) {
            objectling.add(new ObjectMaker());
        }//ForLoopEnd

        //For every object in the list, write the string content to a file named UUID.txt
        for (ObjectMaker l : objectling) {

            try (FileWriter myWriter = new FileWriter("UUIDs.txt", true)) {
                myWriter.write(l.toString());
                myWriter.write("\n");
                System.out.println(l);
                System.out.println("Successfully written to UUID.txt...");
            } catch (IOException e) {
                System.out.println("Something went wrong!");
            }//EndOfTry
        }//ForLoopEnd
        objectling.clear(); //clears array when function executes everything else
    }

    static void passFromList() {
//        for (ObjectMaker p : objectling) {
//            System.out.println(p.toString());
//        }
        if (objectling.isEmpty()) {
            for (int i = 0; i < 9; i++) {
                objectling.add(new ObjectMaker());
            }//ForLoopEnd
            
                for (int x = 0; x < bronchitis; x++) {
                    chars[x] = objectling.toString().charAt(ThreadLocalRandom.current().nextInt(0, objectling.toString().length()));
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        chars[x] = Character.toUpperCase(chars[x]);
                    }//IfEnd
                }//ForLoopEnd
        } else {
            for (int x = 0; x < bronchitis; x++) {
                ///Within the range of 0 to var randomise the position of each character in the array that stores UUID.
                ///From Anonymous on stackoverflow.com Dec 17, 2015 at 3:11
                ///
                chars[x] = objectling.toString().charAt(ThreadLocalRandom.current().nextInt(0, objectling.toString().length()));
                if (ThreadLocalRandom.current().nextBoolean()) {//50% chance to which character to uppercase.
                    chars[x] = Character.toUpperCase(chars[x]);
                }//IfEnd
            }//ForLoopEnd
        }//IfEnd
        
        System.out.println("Generated Password:");
        System.out.println(chars);
        objectling.clear();
    }
}
