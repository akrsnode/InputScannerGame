package com.company;

import java.util.Scanner;

public class Game {
    private int mainNumber;
    private boolean guessed = false;


    public Game(){
        mainNumber = (int) (Math.random()*100+1);
    }

    private int askForGuess(){
        Scanner scan = new Scanner(System.in);
        int guess = Integer.parseInt(scan.nextLine());
        return guess;
    }

    private void compareGuess(int guess){
        if(this.mainNumber > guess){
            System.out.println("It's bigger than "+guess);
        }else if(this.mainNumber < guess){
            System.out.println("It's smaller than "+guess);
        }else{
            System.out.println("Damn, you're right!");
        }
    }

    public void start(){
        System.out.println("I have randomly chosen a number between 1-100. Try to guess it :)");
        for (int i=0; i<10; i++){
            if(guessed) break;
            System.out.println("You have "+(10-i)+" guess(es) left:");
            compareGuess(askForGuess());
        }
        if(!guessed) System.out.println("You've lost.");
    }
}
