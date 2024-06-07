package javaWar;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String playerName;
	private int playerScore;
	List<Card> hand = new ArrayList<>();

	
	 public Player(String playerName, int playerScore, List<Card> hand) 
	 { //AGAIN, THIS>WHATEVR NOT THE THE OTHER WAY!!!! THIS CAUSED A HUGE BUG
		 this.playerName = playerName; 
		 this.playerScore = playerScore; 
		 this.hand = hand; 
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public void describe()
	{
		System.out.println(playerName + " has " + hand.size() + " cards in thier hand and a score of " + playerScore);
	}

	public Card flip()
	{
		Card card = this.hand.remove(0);
		return card;
	}
	
	public void draw(Deck deck)
	{
		Card card = deck.draw();
		hand.add(card);
	}
	
	public void incrementScore()
	{
		playerScore += 1;
	}
}

/*
 * c. Player
 * 
 * i. Fields
 * 
 * 1. hand (List of Card)
 * 
 * 2. score (set to 0 in the constructor)
 * 
 * 3. name
 *
 * ii. Methods
 * 
 * 1. describe (prints out information about the player and calls the describe
 * method for each card in the Hand List)
 * 
 * 2. flip (removes and returns the top card of the Hand)
 * 
 * 3. draw (takes a Deck as an argument and calls the draw method on the deck,
 * adding the returned Card to the hand field)
 * 
 * 4. incrementScore (adds 1 to the Player’s score field)
 */