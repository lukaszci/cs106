/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.util.Objects;

public class Hangman extends ConsoleProgram {
	private static final int LIFE_COUNT = 8;
	private static final long serialVersionUID = 1L;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private HangmanLexicon lexicon;
	private HangmanCanvas canvas;
	private String selectedWord;
	private String givenLetter;
	private int remainingLives;
	private int remainingCharacters;
	private char extractedChar;

    public void run() {
    		init();
    		canvas.reset();
    		selectWord();
    		while (remainingLives > 0 && remainingCharacters > 0) {
    			givenLetter = readLine("Give me a letter: ").toUpperCase();
			int letterPosition = selectedWord.indexOf(givenLetter);
			System.out.println(letterPosition);
			if (letterPosition != (-1) && signIsLetter(givenLetter) == true) {
					userGuessedRight(); 
				} 
			else if(givenLetter.length() > 1  || signIsLetter(givenLetter) == false) {
				userGaveIllegalCombinationOfSigns();
				}
			else {
				userGuessedWrong();
			}
    		}
    		if (remainingCharacters == 0) {
				userWon();
    		} else {
				userLost();	
    		}
    		canvas.reset();
	}
    
    public void selectWord() {
    		lexicon = new HangmanLexicon();
    		int randomWord = rgen.nextInt(0, (lexicon.getWordCount() - 1));
    		selectedWord = lexicon.getWord(randomWord);
    		remainingCharacters = selectedWord.length();
    		System.out.println("The word is " + remainingCharacters + " letters long");
    		remainingLives = LIFE_COUNT;
    		System.out.println("You have " + remainingLives + " lives");
    }
    
    public void userGuessedRight() {
    		if (Objects.equals(givenLetter, selectedWord)) {
    			remainingCharacters = 0;
    			System.out.println(remainingCharacters);
    		} else {
    			int sameLetters = 0;//placeholder - need to add a function that calculates occurrences of the same letter
        		remainingCharacters = remainingCharacters - 1;
        		System.out.println("Bravo, you have " + remainingCharacters + " letters to guess");
    		}
    }
    
    public void userGuessedWrong() {
    		extractLetter();
    		canvas.noteIncorrectGuess(extractedChar);
    		remainingLives = remainingLives -1;
    		System.out.println("no bueno, letter is not here. You have " + remainingLives + " lives left");
    }
    
    public void userGaveIllegalCombinationOfSigns() {
		System.out.println("no bueno, You can only guess one sign at a time or the entire word. The only allowed signs are letters of latin alphabet and you can not leave the field empty!");
}
    
    public void userWon() {
    		System.out.println("Bravo, you won the game. The word was obviously " + selectedWord);
    }
    
    public void userLost() {
    		System.out.println("Bravo, you lost. The word was " + selectedWord);
    }
    
    public boolean signIsLetter(String givenLetter) {
        return givenLetter.matches("[a-zA-Z]+");
    }
    
    public void init() {
    	 canvas = new HangmanCanvas();
    	 add(canvas);
    	}
    
    public void extractLetter() {
    		extractedChar = givenLetter.charAt(0);
    }
}