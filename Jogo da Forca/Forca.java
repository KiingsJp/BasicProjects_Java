import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Choose a word: ");
		String finalWord = sc.next().toUpperCase();
		System.out.println("\n-----------------------------\n");
		char[] word = new char[finalWord.length()];
		for (int i = 0; i < word.length; i++) {
			word[i] = '_';
		};
		char[] letters = finalWord.toCharArray();
		boolean condition = false;
		int mistake = 0;
		do {
			System.out.printf("\nMistakes %d/%d\n\n", mistake, 5);
			condition = false;
			for (char y : word) {
				System.out.print(y + " ");
			};
			System.out.print("\n\nEnter a letter: ");
			char x = sc.next().toUpperCase().charAt(0);
			int testMis = 0;
			for (int i = 0; i < letters.length; i++) {
				if (letters[i] == x) {
					word[i] = x;
				} else if (letters[i] != x) {
					testMis += 1;
				};
			};
			if (testMis == letters.length) {
				mistake++;
			};
			for (char y : word) {
				if (y == '_') {
					condition = true;
				};
			};
			if (mistake == 5) {
				condition = false;
			};
		} while (condition == true);
		boolean fail = false;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == '_') {
				fail = true;
			};
		};
		String lastChance = finalWord;
		System.out.println();
		if (fail) {
			for (char y : word) {
				System.out.print(y + " ");
			};
			System.out.println("\n\nLast chance, what's the word? ");
			lastChance = sc.next().toUpperCase();
		};
		if (lastChance.equals(finalWord)) {
			System.out.println("\nCongratulations!!");
		} else {
			System.out.println("\nWrong Answer!!");
		};
		System.out.print("The word is: " + finalWord);
		System.out.println("\n-----------------------------\n");

		sc.close();
	}
}