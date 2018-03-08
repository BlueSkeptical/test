package gofish_assn;

import java.util.ArrayList;

/**
 * Create a Player object, which includes hand and book
 * 
 * @author Xin Geng, Zitian Xie
 *
 */

public class Player {

	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> book = new ArrayList<Card>();
	private String name;
	int handIndex;

	/**
	 * Constructor
	 * 
	 * @param name,
	 *            player's name
	 */
	public Player(String name) {
		this.name = name;
		handIndex = 0;
	}

	/**
	 * Add a card to current player
	 * 
	 * @param a
	 *            card
	 */
	public void addCardToHand(Card c) {
		hand.add(c);
	}

	/**
	 * remove a card from current player
	 * 
	 * @param c,
	 *            a card in player's hand
	 * @return removed card
	 */
	public Card removeCardFromHand(Card c) {
		Card retCard = new Card();
		retCard = c;
		hand.remove(c);
		return retCard;
	}

	/**
	 * 
	 * @return name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * create a string for hand
	 * 
	 * @return a string representation
	 */
	public String handToString() {
		String result = "";
		for (Card itr : hand) {
			result = result + itr.toString() + " ";
		}
		return result;
	}

	/**
	 * create a string for book
	 * 
	 * @return a string representation
	 */
	public String bookToString() {
		String result = "";
		for (Card itr : book) {
			result = result + itr.toString() + "\r\n";
		}
		return result;
	}

	/**
	 * 
	 * @return size in player's hand
	 */
	public int getHandSize() {
		return hand.size();
	}

	/**
	 * 
	 * @return size in player's book
	 */
	public int getBookSize() {
		return book.size();
	}

	// Here are some ideas for additional functionality that you may want/need
	// OPTIONAL
	// comment out if you decide to not use it

	/**
	 * this function will check a players hand for a pair. If a pair is found, it
	 * moves the cards to the book and returns true
	 * 
	 * @return T if there is a pair, otherwise F
	 */
	public boolean checkHandForBook() {
		int oldSize = book.size();// use to check if there is a pair
		boolean temp;

		// check all pairs in hand
		for (int i = 0; i < hand.size(); i++) {
			temp = sameRankInHand(hand.get(i));
			if (temp == true) {
				i--;
			}
		}
		if (oldSize != book.size()) {
			return true;
		} else {
			return false;
		}
	}

	// Does the player have a card with the same rank as c in her hand?

	/**
	 * if the card has the same rank then remove the same two cards and add it to
	 * book
	 * 
	 * @param c,
	 *            a card
	 * @return true if there is a pair, otherwise false
	 */
	public boolean sameRankInHand(Card c) {
		for (int i = 0; i < hand.size(); i++) {
			if ((c.getRank() == hand.get(i).getRank()) && (c.getSuit() != hand.get(i).getSuit())) {
				book.add(c);
				book.add(hand.get(i));
				hand.remove(i);
				hand.remove(c);
				return true;
			}
		}
		return false;
	}

	// uses some strategy to choose one card from the player's
	// hand so they can say "Do you have a 4?"
	/**
	 * choose a card from hand to deal in some randomness
	 * 
	 * @return a card will be asked
	 */
	public Card chooseCardFromHand() {
		Card c = new Card();

		handIndex = handIndex % hand.size();
		c = hand.get(handIndex);
		handIndex++;
		return c;
	}

	// Does the player have the card c in her hand?
	/**
	 * check if a card in player's hand
	 * 
	 * @param c,
	 *            a card
	 * @return true if card in hand
	 */
	public boolean cardInHand(Card c) {
		return hand.contains(c);
	}

	/**
	 * check if player's hand has the same rank with c
	 * 
	 * @param c,
	 *            a card
	 * @return true if player's hand has card of same rank
	 */
	public boolean rankInHand(Card c) {
		for (Card itr : hand) {
			if (itr.getRank() == c.getRank()) {
				return true;
			}
		}
		return false;
	}

	// OPTIONAL
	// comment out if you decide to not use it
	// Does the player have a card with the same rank as c in her hand?
	// e.g. will return true if the player has a 7d and the parameter is 7c
	/**
	 * check if player's hand has the same rank with c
	 * 
	 * @param c,
	 *            a card
	 * @return the card of same rank
	 */
	public Card sameRankPlayer(Card c) {
		Card sameRank = new Card();
		for (Card itr : hand) {
			if (itr.getRank() == c.getRank()) {
				sameRank = itr;
				break;
			}
		}
		return sameRank;
	}
}
