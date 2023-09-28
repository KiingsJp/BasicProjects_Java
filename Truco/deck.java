package entities;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	public Deck() {
	};
	public static List<String> creatDeck() {
		List<String> cards = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			String suit = null;
			if(i == 0) {
				suit = "♣";
				cards.add("4♣");
			}
			else if(i == 1) {
				suit = "♥";
				cards.add("7♥");
			}
			else if(i == 2) {
				suit = "♠";
			}
			else if(i == 3) {
				suit = "♦";
				cards.add("7♦");
			}
			cards.add(String.format("J%s", suit));
			cards.add(String.format("Q%s", suit));
			cards.add(String.format("K%s", suit));
			cards.add(String.format("A%s", suit));
			cards.add(String.format("2%s", suit));
			cards.add(String.format("3%s", suit));
		};
		return cards;
	};

}
