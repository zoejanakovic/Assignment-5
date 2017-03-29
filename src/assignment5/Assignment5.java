/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.Scanner;

/**
 *
 * @author janaz9178
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a scanner for user input
        Scanner input = new Scanner(System.in);

        //loop the program so users can play again
        while (true) {
            //ask user 1 to input the word
            System.out.println("Player 1: Please enter a word for Player 2 to guess");

            //scan word into a variable
            String word = input.nextLine();

            //output blank spaces to clear screen
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            //count number of characters in string
            int length = word.length();

            //output the number of characters in the word with dashes
            //start with blank string
            //add a dash to the blank string for each letter in the word
            String coverWord = "";

            for (int i = 0; i < length; i++) {
                coverWord = coverWord + "-";
            }
            //output the dashed word
            System.out.println(coverWord);

            //counter for p2's number of lives
            int lifeCounter = 6;

            //loop for p2 to input a letter and to determine if that letter is in the word
            while (lifeCounter > 0) {
                //tell user how many lives they have and get their guess
                System.out.println("Player 2: You have " + lifeCounter + " lives left. Guess a letter");
                String guess = input.nextLine();

                //another string of the word to help with finding repeated letters
                String tracker = word;

                //get first found position of the letter
                //replace letter in tracker with *
                int guessPosition = tracker.indexOf(guess);
                tracker = tracker.replaceFirst(guess, "*");

                //variable starting point after the already found position
                int startPoint = guessPosition + 1;

                //loop to check for other places the letter is found
                while (true) {
                    //look for the letter after the already found spot
                    int guessPositionTwo = tracker.indexOf(guess, startPoint);

                    //if there is another letter
                    if (guessPositionTwo >= 0) {
                        //replace the first spot the letter is found with a * in the tracker
                        tracker = tracker.replaceFirst(guess, "*");

                        //make guessPosition two into a variable
                        int m = guessPositionTwo;

                        //create substrings of cover word
                        //put cover word back together with the guess in the right spot
                        String firstHalf = coverWord.substring(0, m);
                        String secondHalf = coverWord.substring(m + 1);
                        coverWord = firstHalf + guess + secondHalf;

                        //if there are no more letters
                    } else if (guessPositionTwo == -1) {
                        break;
                    }
                }

                //put cover word together again with the guess in its place
                if (guessPosition >= 0) {
                    //make guessPosition into a variable
                    int n = guessPosition;

                    //create substrings of cover word
                    //put substrings back together with the found letter in it's right spot
                    String firstHalf = coverWord.substring(0, n);
                    String secondHalf = coverWord.substring(n + 1);
                    coverWord = firstHalf + guess + secondHalf;

                    //output the new coverWord
                    System.out.println(coverWord);

                    //check to see if the word is completely solved yet, if so, they win, break
                    int wordProgress = coverWord.indexOf("-");
                    if (wordProgress == -1) {
                        System.out.println("You've guessed the word! Congratulations you have won!");
                        break;
                    }
                    //if the guess is wrong but still have lives, output coverWord, decrease counter
                } else if (guessPosition == -1 && lifeCounter > 1) {
                    System.out.println(coverWord);
                    lifeCounter = lifeCounter - 1;

                    //guess is wrong and no lives left, lose and reveal word
                } else if (guessPosition == -1 && lifeCounter == 1) {
                    System.out.println("You have no lives left. The word was " + word + ".");
                    break;
                }

            }
            //ask if they want to play again
            System.out.println("Would you like to play again? Yes or No?");
            String reply = input.nextLine();
            reply = reply.toLowerCase();

            if (reply.equals("no")) {
                System.out.println("Thank you for playing!");
                break;
            } else if (reply.equals("yes")) {
                System.out.println("Player 1 and 2 switch, then begin!");
            }
        }
    }
}