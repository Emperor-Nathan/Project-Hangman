import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ProjectHangman
{

	public static void main(String[] args)
	{
		StringBuilder phrase1 = new StringBuilder("Human");
		StringBuilder phrase2 = new StringBuilder("Turian");
		StringBuilder phrase3 = new StringBuilder("Asari");
		StringBuilder phrase4 = new StringBuilder("Krogan");
		StringBuilder phrase5 = new StringBuilder("Salarian");
		StringBuilder phrase6 = new StringBuilder("Cerberus");
		StringBuilder phrase7 = new StringBuilder("Alliance");
		StringBuilder phrase8 = new StringBuilder("Reapers");
		StringBuilder phrase9 = new StringBuilder("Crucible");
		StringBuilder phrase10 = new StringBuilder("Synthesis");
		 
		// int whichphrase;
		
		String phrasechosen = "";
		int whichphrase = ThreadLocalRandom.current().nextInt(1,11);
		
		switch(whichphrase)
		{
			case 1:
				phrasechosen = phrase1.toString();
				break;
			case 2:
				phrasechosen = phrase2.toString();
				break;
			case 3:
				phrasechosen = phrase3.toString();
				break;
			case 4:
				phrasechosen = phrase4.toString();
				break;
			case 5:
				phrasechosen = phrase5.toString();
				break;
			case 6:
				phrasechosen = phrase6.toString();
				break;
			case 7:
				phrasechosen = phrase7.toString();
				break;
			case 8:
				phrasechosen = phrase8.toString();
				break;
			case 9:
				phrasechosen = phrase9.toString();
				break;
			case 10:
				phrasechosen = phrase10.toString();
				break;
		}

		System.out.println("Phrase: " + phrasechosen);

		StringBuilder guessthisphrase = new StringBuilder(phrasechosen.toString());

		int length = guessthisphrase.length();


		// Making phrase hidden with asterisks

		for(int i=0; i<length; i++)
		{
			guessthisphrase.replace(i, i+1, "*");

			// if(guessthisphrase.charAt(i) != " ")
			// {
			// 	guessthisphrase.replace(i, i+1, "*");
			// }

		}

		System.out.println(guessthisphrase);

	}

}

