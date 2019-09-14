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
			char[] guesses = new char[36];
			int numGuesses;
			int guessesLeft;
			char guess;
			boolean found;
			numGuesses = 0;
			guessesLeft = 8;
			String nextWord = wordlist[randomGen.nextInt(numWords)];
			while (guessesLeft > 0){
				String stars = "";
				for (int n = 0; n < nextWord.length(); n++){
					found = false;
					for (int j = 0; n < numGuesses; j++){
						if (guesses[j] == nextWord.charAt(n)){
							found = true;
						}
					}
					if (nextWord.charAt(n) == ' '){
						stars += ' ';
					}
					else if (found){
						stars += nextWord.charAt(n);
					}
					else{
						stars += '*';
					}
				}
				System.out.println(stars);
				guess = input.next().charAt(0);
				/* Check if already guessed */
				found = false;
				for (int n = 0; n < numGuesses; n++){
					if (guesses[n] == guess){
						found = true;
					}
				}
				if (found){
					System.out.println("You already guessed that.");
				}
				else{
					System.out.println("Wrong!");
					guesses[numGuesses] = guess; // THIS DOES NOT WORK
					numGuesses++;
					guessesLeft--;
				}
				System.out.println("You have " + guessesLeft + " guesses left.");
			}
		}
		catch(Exception e){
			System.out.println("Error opening the input file.");
		}
	}
}