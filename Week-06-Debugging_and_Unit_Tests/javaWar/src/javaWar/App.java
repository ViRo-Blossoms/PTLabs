package javaWar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	
	//Stuff for input, match history, and game speed
	static Scanner scanner = new Scanner(System.in);
	static List<String> history = new ArrayList<>();
	static int speed = 550;
	
	public static void main(String[] args) {

		//main menu
int choice = 0;
		
		while (choice != 9)
		{
			printMenu();
			
			choice = getUserChoice();
			
			if (choice == 1)
			{
				newGameWar();
			}
			else if (choice == 3)
			{
				matchHistory();
			}
			else if (choice == 5)
			{
				settings();
			}
			else if (choice == 7)
			{
				credits();
			}
			else if (choice == 9)
			{
				System.out.println("Thanks for playing!");
			}
			else if (choice == 69) // Dumb easter egg
			{
				System.out.println("Nice");
			}
			else
			{
				System.out.println("Invalid option");
			}
		}
	}
	
	//Main menu options
	public static void printMenu()
	{
		System.out.println("\n----- W A R -----");
		System.out.println("1) Start New Game");
		System.out.println("3) Match History");
		System.out.println("5) Settings");
		System.out.println("7) Credits");
		System.out.println("9) Exit");
		System.out.println();
	}
	
	//Menu Options
	public static int getUserChoice()
	{
		return scanner.nextInt();
	}
	
	//Main game functions, could chop this up
	public static void newGameWar()
	{
		//Make player 1
		List<Card> p1H = new ArrayList<>();
		System.out.println("What is P1's name? ");
		String name1 = scanner.next();
		Player P1 = new Player(name1, 0, p1H);
		//P1.setPlayerName(name1); //ViRo: Debilitating bug caused by doing whatevr = this.whatevr, it wouldn't set the bastard properly but this did
		System.out.println("Hello " + P1.getPlayerName() + "!\n");
		
		//Make Player 2
		List<Card> p2H = new ArrayList<>();
		System.out.println("What is P2's name? ");
		String name2 = scanner.next();
		Player P2 = new Player(name2, 0, p2H);
		//P2.setPlayerName(name2); //ViRo: We were gonna schedule a mentor spot over this it was dribing us crazy
		System.out.println("Hello " + name2 + "!\n");
		
		//Build a deck
		System.out.println("Finding a deck...");
		Deck gameDeck = new Deck();
		System.out.println("Shufflin'...");
		gameDeck.shuffle();
		
		//Deal the cards
		System.out.println("Dealing cards...");
		for (int i = 0; i < 26; i++)
		{
			P1.draw(gameDeck);
			P2.draw(gameDeck);
		}
		P1.describe();
		P2.describe();
		System.out.println("Ready?");
		matchDelay();
		
		//The actual game part
		for (int i = 0; i < 13; i++)
		{
			Card p1c = P1.flip();
			p1c.describe();
			Card p2c = P2.flip();
			p2c.describe();
			if (p1c.getValue() > p2c.getValue())
			{
				P1.incrementScore();
				System.out.println(P1.getPlayerName() + " wins this hand!");
			}
			else if (p2c.getValue() > p1c.getValue())
			{
				P2.incrementScore();
				System.out.println(P2.getPlayerName() + " wins this hand!");
			}
			else
			{
				System.out.println("Looks like a tie!");
			}
			matchDelay();
		}
		
		//Score Check and final results
		System.out.println("That's all she wrote!");
		if (P1.getPlayerScore() > P2.getPlayerScore())
		{
			System.out.println("With a score of " + P1.getPlayerScore() + ", " + P1.getPlayerName() + " wins!!!");
			history.add(P1.getPlayerName() + " beat " + P2.getPlayerName() + " with a score of " + P1.getPlayerScore());
		}
		else if (P2.getPlayerScore() > P1.getPlayerScore())
		{
			System.out.println("With a score of " + P2.getPlayerScore() + ", " + P2.getPlayerName() + " wins!!!");
			history.add(P2.getPlayerName() + " beat " + P1.getPlayerName() + " with a score of " + P2.getPlayerScore());
		}
		else if (P1.getPlayerScore() == P2.getPlayerScore())
		{
			System.out.println(P1.getPlayerName() + " and " + P2.getPlayerName() + ", you both have a score of " + P1.getPlayerScore() + " so it's a tie!");
			history.add(P1.getPlayerName() + " tied " + P2.getPlayerName() + " with a score of " + P1.getPlayerScore());
		}
		else
		{
			System.out.println("Uh-oh!");
		}
		System.out.println("Thanks for playing! Wanna go again?\n");

	}
	
	//Match history, not persistent between runs but a cool feature
	public static void matchHistory()
	{
		System.out.println("Match History");
		if (history.isEmpty())
		{
			System.out.println("No matches found - why don't you play a round or two and change that?");
		}
		else
		{
			for (String match : history)
			{
				System.out.println(match);
			}
			System.out.println();
		}
	}
	
	//Delay between matches, we hate war but it sucked to just bang out 13 games in a nanosecond so this should make it more of a """""game"""""
	public static void matchDelay()
	{
		try 
		{
		Thread.sleep(speed);
		System.out.print("\n♠ ");
		Thread.sleep(speed);
		System.out.print("♡ ");
		Thread.sleep(speed);
		System.out.print("♣ ");
		Thread.sleep(speed);
		System.out.println("♢\n");
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	//Speed settings for the matches, we personally hate war so 7 is our go to
	public static void settings()
	{
		System.out.println("\n[]Set game speed[]");
		System.out.println("Don't forget to hit 9 after selecting a speed!");
		System.out.println("1) S l o w");
		System.out.println("3) Default");
		System.out.println("5) Fast");
		System.out.println("7) Lightning Round!!");
		System.out.println("9) <= Go back <=");
		int choice = 0;
		while (choice != 9)
		{
			
			choice = getUserChoice();
			if (choice == 1)
			{
				speed = 950;
				System.out.println("Speed set to slow");
			}
			else if (choice == 3)
			{
				speed = 550;
				System.out.println("Speed set to Default");			
			}
			if (choice == 5)
			{
				speed = 350;
				System.out.println("Speed set to Fast");
			}
			else if (choice == 7)
			{
				speed = 1;
				System.out.println("Speed set to Fastest");
			}
			else if (choice == 9)
			{
				
			}
				
		}
	}
	
	//Credits!! This is just for fun but makes it feel more finished to us
	public static void credits()
	{
		System.out.println(" - _ - _ Credits _ - _ - ");
		System.out.println("Violet Rose 'ViRo' Blossoms made this with help from the Promineo Tech course!");
		System.out.println("	Special thanks to:");
		System.out.println("The Team MAST video on the sleep function");
		System.out.println("Lis(?) from the Week 05 lab video");
		System.out.println("Our partner for listening to us audibly weep about bugs");
		System.out.println("And our downstairs neighbors for persistanly using thier 27 inch subwoofers.");

	}
}
