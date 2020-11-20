package com.company;

import java.util.Scanner;
import java.io.File;

public class FileScanner {
   public static void main(String [] args) throws Exception {
       File file = new File("nested.txt");
       Scanner fileScanner= new Scanner(file);

       int wordcount = 0;
       while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            wordcount += line.split(" ").length;
       }
       System.out.println("The file contains: "+wordcount+" words.");
   }
}
