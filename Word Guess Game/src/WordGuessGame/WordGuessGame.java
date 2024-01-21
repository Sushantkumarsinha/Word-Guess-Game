package WordGuessGame;

import java.util.Scanner;

public class WordGuessGame {
    private static String[] words = {"java", "python","marvel","banana","laptop","winter","castle", "programming", "hangman", "computer"};
    private static String wordToGuess;
    private static char[] guessedLetters;
    private static int maxAttempts = 5;
    private static int attemptsLeft;

    public static void main(String[] args) {
        chooseRandomWord();
        initializeGuessedLetters();
        playGame();
    }

    private static void chooseRandomWord() {
        int randomIndex = (int) (Math.random() * words.length);
        wordToGuess = words[randomIndex];
    }

    private static void initializeGuessedLetters() {
        guessedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);

        attemptsLeft = maxAttempts;

        while (attemptsLeft > 0) {
            displayGuessedWord();

            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            if (isGuessCorrect(guess)) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Incorrect guess. Try again.");
                attemptsLeft--;
            }

            if (isWordGuessed()) {
                System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                break;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("Sorry, you ran out of attempts. The correct word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static void displayGuessedWord() {
        System.out.print("Word: ");
        for (char letter : guessedLetters) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    private static boolean isGuessCorrect(char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedLetters[i] = guess;
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    private static boolean isWordGuessed() {
        for (char letter : guessedLetters) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }
}
