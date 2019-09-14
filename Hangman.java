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
			String[] guesses = new String[36];
			char guess;
			while (true){
				String nextWord = wordlist[randomGen.nextInt(numWords)];
				String stars = "";
				for (int n = 0; n < nextWord.length(); n++){
					if (nextWord.substring(n, n + 1).equals(" ")){
						stars += ' ';
					}
					else{
						stars += '*';
					}
				}
				System.out.println(stars);
				guess = input.next().charAt(0);
			}
		}
		catch(Exception e){
			System.out.println("Error opening the input file.");
		}
	}
}