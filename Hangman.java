// Nathan Holmes-King
// 2019-09-14

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Hangman
{
	public static void main(String [] args)
	{
		try{
			Scanner input = new Scanner(System.in);
			/* Finds number of words */
			int r = 0;
			char t = '\0';
			File file2 = new File("wordlist.txt");
			FileInputStream infile2 = new FileInputStream(file2);
			int numWords = 0;
			while((r = infile2.read()) != -1){
				t = (char) r;
				if (t == '\n'){
					numWords += 1;
				}
			}
			infile2.close();
			/* Creates word list */
			r = 0;
			t = '\0';
			String s = "";
			String[] wordlist = new String[numWords];
			File file = new File("wordlist.txt");
			FileInputStream infile = new FileInputStream(file);
			int position = 0;
			while((r = infile.read()) != -1){
				t = (char) r;
				if (t == '\n'){
					wordlist[position] = s;
					position += 1;
					s = "";
				}
				else{
					s += t;
				}
			}
			infile.close();
			/* Main part of program */
			Random randomGen = new Random();
			String guesses = "";
			int numGuesses;
			int guessesLeft;
			char guess;
			boolean found;
			boolean correct;
			boolean complete;
			numGuesses = 0;
			guessesLeft = 8;
			String nextWord = wordlist[randomGen.nextInt(numWords)];
			StringBuilder stars = new StringBuilder();
			for (int n = 0; n < nextWord.length(); n++){
				if (nextWord.charAt(n) == ' '){
					stars.append(' ');
				}
				else{
					stars.append('*');
					complete = false;
				}
			}
			while (guessesLeft > 0){
				complete = true;
				for (int n = 0; n < nextWord.length(); n++){
					found = false;
					for (int j = 0; j < numGuesses; j++){
						if (guesses.charAt(j) == nextWord.charAt(n)){
							found = true;
						}
					}
					if (nextWord.charAt(n) == ' '){
						stars.replace(n, n + 1, " ");
					}
					else if (found){
						stars.replace(n, n + 1, nextWord.substring(n, n + 1));
					}
					else{
						stars.replace(n, n + 1, "*");
						complete = false;
					}
				}
				System.out.println();
				System.out.println(stars);
				System.out.println();
				if (complete){
					System.out.println("You win!");
					break;
				}
				guess = input.next().charAt(0);
				/* Check if already guessed */
				found = false;
				correct = false;
				for (int n = 0; n < numGuesses; n++){
					if (guesses.charAt(n) == guess){
						found = true;
					}
				}
				for (int n = 0; n < nextWord.length(); n++){
					if (nextWord.charAt(n) == guess){
						correct = true;
					}
				}
				if (found){
					System.out.println("You already guessed that.");
				}
				else if (correct){
					System.out.println("Correct!");
					guesses += guess;
					numGuesses++;
				}
				else{
					System.out.println("Wrong!");
					guesses += guess;
					numGuesses++;
					guessesLeft--;
				}
				System.out.println("You have " + guessesLeft + " guesses left.\n");
			}
			if (guessesLeft == 0){
				System.out.println("The word was \"" + nextWord + "\".");
			}
		}
		catch(Exception e){
			System.out.println("Error opening the input file.");
		}
	}
}