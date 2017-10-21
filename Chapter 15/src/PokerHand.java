import java.util.ArrayList;

public class PokerHand extends Deck {
	private Card[] hand;
	private static int numCards = 5;
	private static int numHands = 10000;

	public PokerHand() {
		hand = dealCards();
	}

	public PokerHand(Card[] hand) {
		this.hand = hand;
	}

	public Card[] dealCards() {
		Deck deck = new Deck();
		Card[] hand = new Card[numCards];
		deck.shuffle();
		for (int i = 0; i < numCards; i++) {
			hand[i] = deck.cards[i];
		}
		return hand;
	}

	public PokerHand deal() {
		return new PokerHand(dealCards());
	}

	public void print() {
		for (int i = 0; i < hand.length; i++) {
			hand[i].print();
		}
	}

	public boolean hasFlush() {
		int count = 0;
		boolean has = false;
		for (int i = 0; i < hand.length; i++) {
			for (int j = 0; j < hand.length; j++) {
				if (hand[j].suit == hand[i].suit) count++;
			}
			if (count >= 5) has = true;
			count = 0;
		}
		return has;
	}
	
	public boolean hasPair() {
		int count = 0;
		boolean has = false;
		
		for (int i = 0; i < hand.length; i++) {
			for (int j = 0; j < hand.length; j++) {
				if (hand[i].rank == hand[j].rank) count++;
			}
			if (count >= 2) has = true;
			count = 0;
		}

		return has;
	}
	
	public boolean hasThreeKind() {
		int count = 0;
		boolean has = false;
		
		for (int i = 0; i < hand.length; i++) {
			for (int j = 0; j < hand.length; j++) {
				if (hand[i].rank == hand[j].rank) count++;
			}
			if (count >= 3) has = true;
			count = 0;
		}

		return has;
	}

	public boolean hasTwoPair() {
		int countP = 0, countD = 0;
		boolean has = false;
		for (int i = 0; i < hand.length; i++) {
			for (int j = 0; j < hand.length; j++) {
				if (hand[i].rank == hand[j].rank) countP++;
			}
			if (countP >= 2) countD++;
			countP = 0;
		}
		if (countD >= 2) has = true;
		return has;
	}

	public boolean hasFourKind() {
		int count = 0;
		boolean has = false;
		
		for (int i = 0; i < hand.length; i++) {
			for (int j = 0; j < hand.length; j++) {
				if (hand[i].rank == hand[j].rank) count++;
			}
			if (count >= 4) has = true;
			count = 0;
		}

		return has;
	}

	public static void main(String[] args) {
		ArrayList<PokerHand> hands = new ArrayList<PokerHand>();
		for (int i = 0; i < numHands; i++) {
			hands.add(new PokerHand());
			// hands.get(i).print();
		}
		int numFlush = 0, numThree = 0;
		for (int i = 0; i < 4; i++) {
			hands.get(i).print();
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < numHands; i++) {
			if (hands.get(i).hasFlush())
				numFlush++;
			if (hands.get(i).hasThreeKind())
				numThree++;
		}
		System.out.println( "There are " + numFlush + " flushes and " 
				+ numThree + " three of a kinds in " + numHands + " hands");
	}
}