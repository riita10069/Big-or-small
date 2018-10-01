import java.util.Random;

public class Deck {
	Card[] deck;
	private int rest;

	public Deck() {
		initialization();
	}

	public void initialization() {
		this.deck = new Card[52];
		int num = 0;
		for (int i = 0; i <= 3; i++) {
			for (int j = 1; j <= 13; j++, num++) {
				deck[num] = new Card(i, j);
			}
		}
		setRest(52);
	}
	public Card take() {
		int random;
		do {
		random = new Random().nextInt(52);
		}while(deck[random]==null);
		Card taked = new Card(deck[random].getMark(),deck[random].getNumber());
		deck[random]=null;
		this.setRest(this.getRest() - 1);
		return taked;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}
}
