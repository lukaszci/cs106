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

public class Hangman extends ConsoleProgram {
	private static final int LIFE_COUNT = 8;
	private static final long serialVersionUID = 1L;
	private HangmanLexicon allWords;
	private char givenLetter;
	private String selectedWord;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private int remainingLives;
	private int remainingCharacters;
	String givenWord;

    public void run() {
    		selectWord();
    		while (remainingLives > 0 && remainingCharacters > 0)
		selectedWord = readLine("Give me a letter: ");
			for(int i=0; i< selectedWord.length(); i++) {
				int givenLetter = selectedWord.indexOf(i);
				System.out.println(givenLetter);
					if (givenLetter != (-1) ) {
						userGuessedRight(); 
					} else {
						userGuessedWrong();
					}
			}
			if (remainingCharacters == 0) {
				userWon();
			}
			else {
				userLost();
			}
	}
    
    public void selectWord() {
    		allWords = new HangmanLexicon();
    		int randomWord = rgen.nextInt(0, (allWords.getWordCount() - 1));
    		selectedWord = allWords.getWord(randomWord);
    		remainingCharacters = selectedWord.length();
    		remainingLives = LIFE_COUNT;
    }
    
    public void userGuessedRight() {
    		int sameLetters = 0;//placeholder - need to add a function that calculates occurrences of the same letter
    		remainingCharacters = remainingCharacters - sameLetters;
    		System.out.println("Bravo, this word contains this letter");
    }
    
    public void userGuessedWrong() {
    		remainingLives = remainingLives -1;
    		System.out.println("no bueno, letter is not here");
    }
    
    public void userWon() {
    		System.out.println("Bravo, you won the game");
    }
    
    public void userLost() {
    		System.out.println("Bravo, you lost");
    }

}
