package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GuessTheMovie {
    private static int movieIndex;
    private static boolean guessing = true;
    private static String wrongLetters = "";

    public static void main(String[] args) {
        String movieToGuess = generateMovie();
        char[] inputGuess = encryptWord(movieToGuess).toCharArray();
        int count = 0;
        while(guessing) {
            System.out.println("You are guessing: "+display(inputGuess));
            System.out.println("You have guessed ("+count+") wrong letters: "+wrongLetters);
            char inputChar = askForGuess();
            if(movieToGuess.indexOf(inputChar) >= 0) {
                inputGuess[movieToGuess.indexOf(inputChar)] = inputChar;
            } else {
                count++;
                wrongLetters += inputChar+" ";
            }
        }
    }

    private static String generateMovie() {
        movieIndex = (int) (Math.random()*25+1);
        List<String> moviedb = new ArrayList<String>();
        File file = new File("moviedb.txt");

        try {
            Scanner scanFile = new Scanner(file);
            while (scanFile.hasNextLine()) {
                moviedb.add(scanFile.nextLine());
            }
        } catch(FileNotFoundException exception) {
            System.out.println("Error: "+exception);
        }
        return moviedb.get(movieIndex);
    }

    private static String encryptWord(String word) {
        return word.replaceAll("\\S", "_");
    }

    private static char askForGuess(){
        System.out.print("Guess a letter: ");
        Scanner scan = new Scanner(System.in);
        String guess = scan.nextLine();
        char g = guess.charAt(0);
        return g;
    }

    private static String display(char[] arr) {
        String result = "";
        for(int i=0;i<arr.length;i++){
            result += String.valueOf(arr[i]);
        }
        return result;
    }
}