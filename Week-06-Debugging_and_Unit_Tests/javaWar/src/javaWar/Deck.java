package javaWar;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	public class Deck {
		
		List<Card> cards = new ArrayList<Card>();
		
		Deck () 
		{
			String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
			String[] numNames = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
			
			for (String suit : suits)
			{
				int value = 2;
				for (String name : numNames)
				{
					cards.add(new Card(name, suit, value));
					value++;
				}
			}
		}
		
		public void describe()
		{
			for (Card card : this.cards)
			{
				card.describe();
			}
			
		}
		
		public List<Card> shuffle()
		{
			Collections.shuffle(cards);
			return cards;
		}
		

		public Card draw() 
		{
			Card card = this.cards.remove(0);
			return card;
		}
		
		public List<Card> getCards() 
		{
			return cards;
		}

		public void setCards(List<Card> cards) 
		{
			this.cards = cards;
		}
	}
