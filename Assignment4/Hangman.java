
/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.program.*;
import acm.util.*;
import java.util.Objects;

public class Hangman extends ConsoleProgram {
	private static final int LIFE_COUNT = 8;
	private static final long serialVersionUID = 1L;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private HangmanLexicon lexicon;
	private HangmanCanvas canvas;
	private String selectedWord;
	private String givenLetter;
	public String currentWord;
	private int remainingLives;
	private int remainingCharacters;

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}

	public void run() {
		canvas.reset();
		selectWord();
		currentWord = showNumberOfLetters();
		System.out.println("Selected Word is: " + selectedWord);
		System.out.println("Scaffold is created but the canvas doesn't exist. " + canvas);
		add(canvas);
		canvas.reset();
		while (remainingLives > 0 && remainingCharacters > 0) {
			System.out.println("The word looks now like this: " + currentWord);
			System.out.println("The number of characters left for you to guess equals " + remainingCharacters);
			givenLetter = readLine("Give me a letter: ").toUpperCase();
			int letterPosition = selectedWord.indexOf(givenLetter);
			if (letterPosition != (-1) && signIsLetter(givenLetter) == true) {
				userGuessedRight();
			} else if (givenLetter.length() > 1 || signIsLetter(givenLetter) == false) {// handling case where user
																						// provides a sign that is not a
																						// letter or more than one
																						// letter
				userGaveIllegalCombinationOfSigns();
			} else {
				userGuessedWrong();
			}
		}
		if (remainingCharacters == 0) {
			userWon();
		} else {
			userLost();
		}
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

	private String showNumberOfLetters() {
		String result = "";
		for (int i = 0; i < selectedWord.length(); i++) {
			result = result + "-";
		}
		return result;
	}

	public void userGuessedRight() {
		if (Objects.equals(givenLetter, selectedWord)) {// user guessed the entire word correctly
			remainingCharacters = 0;
		}
		if (!String.valueOf(currentWord.charAt(selectedWord.indexOf(givenLetter))).equals("-")) {// user keeps guessing
																									// the same correct
																									// letter over and
																									// over again
			System.out.println("Dude, get a life! Guess a different letter!");
		} else { // user guessed correctly a single letter
			remainingCharacters--;
			currentWord = currentWord.substring(0, selectedWord.indexOf(givenLetter)) + givenLetter
					+ currentWord.substring(selectedWord.indexOf(givenLetter) + 1);
			int currentLetterPosition = selectedWord.indexOf(givenLetter);// save locally the position of first
																			// occurrence of char in word
			for (int i = currentLetterPosition + 1; i < selectedWord.length(); i++) {
				String currentLetter = String.valueOf(selectedWord.charAt(i));
				if (Objects.equals(givenLetter, currentLetter)) {
					remainingCharacters--;
					currentWord = currentWord.substring(0, i) + currentLetter + currentWord.substring(i + 1);
				}
			}
		}
		canvas.noteCorrectGuess(currentWord);
	}

	public void userGuessedWrong() {
		char extractedWrongChar = givenLetter.charAt(0);
		canvas.noteIncorrectGuess(extractedWrongChar);
		remainingLives--;
		System.out.println("no bueno, letter is not here. The number of remaining lives equals " + remainingLives);
	}

	public void userGaveIllegalCombinationOfSigns() {
		System.out.println(
				"no bueno, You can only guess one sign at a time or the entire word. The only allowed signs are letters of latin alphabet and you can not leave the field empty!");
	}

	public void userWon() {
		System.out.println("Bravo, you won the game. The word was obviously: " + selectedWord);
	}

	public void userLost() {
		System.out.println("Bravo, you lost. The word was: " + selectedWord);
	}

	public boolean signIsLetter(String givenLetter) {
		return givenLetter.matches("[a-zA-Z]+");
	}
}