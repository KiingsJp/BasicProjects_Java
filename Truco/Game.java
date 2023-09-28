import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.Deck;
import entities.Table;

public class Game {
	public static void main(String[] args) {
		Random random = new Random();
		
		int numberOfElements = 12;
		Integer points1 = 0, points2 = 0;
		do {
			List<String> cards = Deck.creatDeck();
			String[] player1 = new String[3];
			String[] player2 = new String[3];
			String[] player3 = new String[3];
			String[] player4 = new String[3];
			for (int i = 0; i < numberOfElements; i++) {
				int randomIndex = random.nextInt(cards.size());
				String randomCard = cards.get(randomIndex);
				cards.remove(randomIndex);
				if (i < 3) {
					player1[i] = randomCard;
				} else if (i > 2 && i < 6) {
					player2[i - 3] = randomCard;
				} else if (i > 5 && i < 9) {
					player3[i - 6] = randomCard;
				} else if (i > 8) {
					player4[i - 9] = randomCard;
				};
			}
			
			String[][] table = Table.table(player1, player2, player3, player4);
			printTable(table);
			Integer first = 0;
			Integer team1 = 0, team2 = 0;
			//ROUND ONE ----------------------------------------------------------
			Integer win = round1(table, player1, player2, player3, player4);
			if(winnerRound(win) == 1) {
				team1++;
				first = 1;
			}else if (winnerRound(win) == 2) {
				team2++;
				first = 2;
			} else {
				team1++;
				team2++;
			};
			System.out.println("Blue team: " + team1 + "/2");
			System.out.println("Red team: " + team2 + "/2");
			//ROUND TWO ----------------------------------------------------------
			win = round2(table, player1, player2, player3, player4, win);
			if(winnerRound(win) == 1) {
				team1++;
			}else if (winnerRound(win) == 2) {
				team2++;
			} else {
				team1++;
				team2++;
			};
			System.out.println("Blue team: " + team1 + "/2");
			System.out.println("Red team: " + team2 + "/2");
			if(team1 != 2 && team2 != 2) {
				//ROUND THREE --------------------------------------------------------
				win = round3(table, player1, player2, player3, player4, win);
				if(winnerRound(win) == 1) {
					team1++;
				}else if (winnerRound(win) == 2) {
					team2++;
				} else {
					team1++;
					team2++;
				};
			};
			if (team1 == 2 && team2 == 2) {
				if(first == 1) {
					points1++;
				} else if(first == 2) {
					points2++;
				};
			} else if(team1 == 2) {
				points1++;
			} else if(team2 == 2) {
				points2++;
			};
			System.out.println("Team Blue: " + points1 + "/12");
			System.out.println("Team Red: " + points2 + "/12");
		} while (points1 < 12 || points2 < 12 );
	};
	public static Integer round1(String[][] table, String[] player1, String[] player2, String[] player3,
			String[] player4) {
		Integer win;
		String choice1 = "", choice2 = "", choice3 = "", choice4 = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
// PLAYER 1 -------------------------------------------------------
		System.out.println("Player 1: ");
		System.out.print("Choose a card (1,2,3): ");
		char card = sc.next().charAt(0);
		System.out.println("\n\n");
		if (card == '1') {
			choice1 = player1[0];
			table[2][7] = player1[0];
			player1[0] = "--";
			table[0][3] = player1[0];
			printTable(table);
		} else if (card == '2') {
			choice1 = player1[1];
			table[2][7] = player1[1];
			player1[1] = "--";
			table[0][4] = player1[1];
			printTable(table);
		} else if (card == '3') {
			choice1 = player1[2];
			table[2][7] = player1[2];
			player1[2] = "--";
			table[0][5] = player1[2];
			printTable(table);
		}
		System.out.println("\n\n");
// PLAYER 2 -------------------------------------------------------
		System.out.println("Player 2: ");
		System.out.print("Choose a card (1,2,3): ");
		card = sc.next().charAt(0);
		System.out.println("\n\n");
		if (card == '1') {
			choice2 = player2[0];
			table[4][3] = player2[0];
			player2[0] = "--";
			table[3][0] = player2[0];
			printTable(table);
		} else if (card == '2') {
			choice2 = player2[1];
			table[4][3] = player2[1];
			player2[1] = "--";
			table[4][0] = player2[1];
			printTable(table);
		} else if (card == '3') {
			choice2 = player2[2];
			table[4][3] = player2[2];
			player2[2] = "--";
			table[5][0] = player2[2];
			printTable(table);
		}
		System.out.println("\n\n");
// PLAYER 3 -------------------------------------------------------
		System.out.println("Player 3: ");
		System.out.print("Choose a card (1,2,3): ");
		card = sc.next().charAt(0);
		System.out.println("\n\n");
		if (card == '1') {
			choice3 = player3[0];
			table[6][7] = player3[0];
			player3[0] = "--";
			table[8][3] = player3[0];
			printTable(table);
		} else if (card == '2') {
			choice3 = player3[1];
			table[6][7] = player3[1];
			player3[1] = "--";
			table[8][4] = player3[1];
			printTable(table);
		} else if (card == '3') {
			choice3 = player3[2];
			table[6][7] = player3[2];
			player3[2] = "--";
			table[8][5] = player3[2];
			printTable(table);
		}

		System.out.println("\n\n");
// PLAYER 4 -------------------------------------------------------
		System.out.println("Player 4: ");
		System.out.print("Choose a card (1,2,3): ");
		card = sc.next().charAt(0);
		System.out.println("\n\n");
		if (card == '1') {
			choice4 = player4[0];
			table[4][5] = player4[0];
			player4[0] = "--";
			table[3][8] = player4[0];
			printTable(table);
		} else if (card == '2') {
			choice4 = player4[1];
			table[4][5] = player4[1];
			player4[1] = "--";
			table[4][8] = player4[1];
			printTable(table);
		} else if (card == '3') {
			choice4 = player4[2];
			table[4][5] = player4[2];
			player4[2] = "--";
			table[5][8] = player4[2];
			printTable(table);
		}
		System.out.println("\n\n");
		win = calcHigher(choice1, choice2, choice3, choice4);

		table[4][5] = "--";
		table[6][7] = "--";
		table[4][3] = "--";
		table[2][7] = "--";
		return win;
	};
	public static Integer round2(String[][] table, String[] player1, String[] player2, String[] player3,
			String[] player4, Integer winner) {
		printTable(table);
		Integer win = winner;
		String choice1 = null, choice2 = null, choice3 = null, choice4 = null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			char card;
			// PLAYER 1 -------------------------------------------------------
			if (win == 1) {
				System.out.println("Player 1: ");
				System.out.print("Choose a card (1,2): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (!table[0][3].equals("--")) {
						choice1 = player1[0];
						table[2][7] = player1[0];
						player1[0] = "--";
						table[0][3] = player1[0];
						printTable(table);
					} else {
						choice1 = player1[1];
						table[2][7] = player1[1];
						player1[1] = "--";
						table[0][4] = player1[1];
						printTable(table);
					};
				} else if (card == '2') {
					if (table[0][3].equals("--") || table[0][4].equals("--")) {
						choice1 = player1[2];
						table[2][7] = player1[2];
						player1[2] = "--";
						table[0][5] = player1[2];
						printTable(table);
					} else if (table[0][5].equals("--")) {
						choice1 = player1[1];
						table[2][7] = player1[1];
						player1[1] = "--";
						table[0][4] = player1[1];
						printTable(table);
					};
				}
				System.out.println("\n\n");
			};

// PLAYER 2 -------------------------------------------------------
			if (win == 2) {
				System.out.println("Player 2: ");
				System.out.print("Choose a card (1,2): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (table[4][0].equals("--") || table[5][0].equals("--")) {
						choice2 = player2[0];
						table[4][3] = player2[0];
						player2[0] = "--";
						table[3][0] = player2[0];
						printTable(table);
					} else {
						choice2 = player2[1];
						table[4][3] = player2[1];
						player2[1] = "--";
						table[4][0] = player2[1];
						printTable(table);
					};
				} else if (card == '2') {
					if (table[3][0].equals("--") || table[4][0].equals("--")) {
						choice2 = player2[2];
						table[4][3] = player2[2];
						player2[2] = "--";
						table[5][0] = player2[2];
						printTable(table);
					}
					else if (table[5][0].equals("--")) {
						choice2 = player2[1];
						table[4][3] = player2[1];
						player2[1] = "--";
						table[4][0] = player2[1];
						printTable(table);
					};
				}
				System.out.println("\n\n");
			};

// PLAYER 3 -------------------------------------------------------
			if (win == 3) {
				System.out.println("Player 3: ");
				System.out.print("Choose a card (1,2): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (table[8][4].equals("--") || table[8][5].equals("--")) {
						choice3 = player3[0];
						table[6][7] = player3[0];
						player3[0] = "--";
						table[8][3] = player3[0];
						printTable(table);
					} else if (table[8][3].equals("--")) {
						choice3 = player3[1];
						table[6][7] = player3[1];
						player3[1] = "--";
						table[8][4] = player3[1];
						printTable(table);
					};
				} else if (card == '2') {
					if (table[8][3].equals("--") || table[8][4].equals("--")) {
						choice3 = player3[2];
						table[6][7] = player3[2];
						player3[2] = "--";
						table[8][5] = player3[2];
						printTable(table);
					} else if (table[8][5].equals("--")) {
						choice3 = player3[1];
						table[6][7] = player3[1];
						player3[1] = "--";
						table[8][4] = player3[1];
						printTable(table);
					};
				}
				System.out.println("\n\n");
			};
// PLAYER 4 -------------------------------------------------------
			if (win == 4) {
				System.out.println("Player 4: ");
				System.out.print("Choose a card (1,2): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (table[4][8].equals("--") || table[5][8].equals("--")) {
						choice4 = player4[0];
						table[4][5] = player4[0];
						player4[0] = "--";
						table[3][8] = player4[0];
						printTable(table);
					} else if (table[3][8].equals("--")) {
						choice4 = player4[1];
						table[4][5] = player4[1];
						player4[1] = "--";
						table[4][8] = player4[1];
						printTable(table);
					};
				} else if (card == '2') {
					if (table[3][8].equals("--") || table[4][8].equals("--")) {
						choice4 = player4[2];
						table[4][5] = player4[2];
						player4[2] = "--";
						table[5][8] = player4[2];
						printTable(table);
					} else if (table[5][8].equals("--")) {
						choice4 = player4[1];
						table[4][5] = player4[1];
						player4[1] = "--";
						table[4][8] = player4[1];
						printTable(table);
					};
				}
			};
			System.out.println("\n\n");
			if (win == 1 || win == 2 || win == 3) {
				win++;
			} else {
				win -= 3;
			};
		} while (choice1 == null || choice2 == null || choice3 == null || choice4 == null);
		table[4][5] = "--";
		table[6][7] = "--";
		table[4][3] = "--";
		table[2][7] = "--";
		win = calcHigher(choice1, choice2, choice3, choice4);
		return win;
	};
	public static Integer round3(String[][] table, String[] player1, String[] player2, String[] player3,
			String[] player4, Integer winner) {
		printTable(table);
		Integer win = winner;
		String choice1 = null, choice2 = null, choice3 = null, choice4 = null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			char card;
			// PLAYER 1 -------------------------------------------------------
			if (win == 1) {
				System.out.println("Player 1: ");
				System.out.print("Choose a card (1): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (table[0][3].equals("--") && table[0][4].equals("--") ) {
						choice1 = player1[2];
						table[2][7] = player1[2];
						player1[2] = "--";
						table[0][5] = player1[2];
						printTable(table);
					} else if (table[0][3].equals("--") && table[0][5].equals("--") ){
						choice1 = player1[1];
						table[2][7] = player1[1];
						player1[1] = "--";
						table[0][4] = player1[1];
						printTable(table);
					} else if (table[0][4].equals("--") && table[0][5].equals("--")) {
						choice1 = player1[0];
						table[2][7] = player1[0];
						player1[0] = "--";
						table[0][3] = player1[0];
						printTable(table);
					};
				};
				System.out.println("\n\n");
			};
// PLAYER 2 -------------------------------------------------------
			if (win == 2) {
				System.out.println("Player 2: ");
				System.out.print("Choose a card (1): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (table[3][0].equals("--") && table[4][0].equals("--")) {
						choice2 = player2[2];
						table[4][3] = player2[2];
						player2[2] = "--";
						table[5][0] = player2[2];
						printTable(table);
					} else if (table[3][0].equals("--") && table[5][0].equals("--")){
						choice2 = player2[1];
						table[4][3] = player2[1];
						player2[1] = "--";
						table[4][0] = player2[1];
						printTable(table);
					} else if(table[4][0].equals("--") && table[5][0].equals("--")) {
						choice2 = player2[0];
						table[4][3] = player2[0];
						player2[0] = "--";
						table[3][0] = player2[0];
						printTable(table);
					};
				} 
				System.out.println("\n\n");
			};
// PLAYER 3 -------------------------------------------------------
			if (win == 3) {
				System.out.println("Player 3: ");
				System.out.print("Choose a card (1): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (table[8][4].equals("--") && table[8][5].equals("--")) {
						choice3 = player3[0];
						table[6][7] = player3[0];
						player3[0] = "--";
						table[8][3] = player3[0];
						printTable(table);
					} else if (table[8][3].equals("--") && table[8][5].equals("--")) {
						choice3 = player3[1];
						table[6][7] = player3[1];
						player3[1] = "--";
						table[8][4] = player3[1];
						printTable(table);
					} else if (table[8][4].equals("--") && table[8][3].equals("--")) {
						choice3 = player3[2];
						table[6][7] = player3[2];
						player3[2] = "--";
						table[8][5] = player3[2];
						printTable(table);
					};
				}
				System.out.println("\n\n");
			};
// PLAYER 4 -------------------------------------------------------
			if (win == 4) {
				System.out.println("Player 4: ");
				System.out.print("Choose a card (1): ");
				card = sc.next().charAt(0);
				System.out.println("\n\n");
				if (card == '1') {
					if (table[4][8].equals("--") && table[5][8].equals("--")) {
						choice4 = player4[0];
						table[4][5] = player4[0];
						player4[0] = "--";
						table[3][8] = player4[0];
						printTable(table);
					} else if (table[3][8].equals("--") && table[4][8].equals("--")) {
						choice4 = player4[2];
						table[4][5] = player4[2];
						player4[2] = "--";
						table[5][8] = player4[2];
						printTable(table);
					} else if(table[3][8].equals("--") && table[5][8].equals("--")) {
						choice4 = player4[1];
						table[4][5] = player4[1];
						player4[1] = "--";
						table[4][8] = player4[1];
						printTable(table);
					};
				} 
			};
			System.out.println("\n\n");
			if (win == 1 || win == 2 || win == 3) {
				win++;
			} else {
				win -= 3;
			};
		} while (choice1 == null || choice2 == null || choice3 == null || choice4 == null);
		table[4][5] = "--";
		table[6][7] = "--";
		table[4][3] = "--";
		table[2][7] = "--";
		win = calcHigher(choice1, choice2, choice3, choice4);
		return win;
	};
	public static Integer calcHigher(String player1, String player2, String player3, String player4) {
		Integer[] ponts = new Integer[4];
// PLAYER 1 -------------------------------------------------------
		if (player1.equals("Q♦") || player1.equals("Q♠") || player1.equals("Q♥") || player1.equals("Q♣")) {
			ponts[0] = 1;
		} else if (player1.equals("J♦") || player1.equals("J♠") || player1.equals("J♥") || player1.equals("J♣")) {
			ponts[0] = 2;
		} else if (player1.equals("K♦") || player1.equals("K♠") || player1.equals("K♥") || player1.equals("K♣")) {
			ponts[0] = 3;
		} else if (player1.equals("A♦") || player1.equals("A♥") || player1.equals("A♣")) {
			ponts[0] = 4;
		} else if (player1.equals("2♦") || player1.equals("2♠") || player1.equals("2♥") || player1.equals("2♣")) {
			ponts[0] = 5;
		} else if (player1.equals("3♦") || player1.equals("3♠") || player1.equals("3♥") || player1.equals("3♣")) {
			ponts[0] = 6;
		} else if (player1.equals("7♦")) {
			ponts[0] = 10;
		} else if (player1.equals("A♠")) {
			ponts[0] = 15;
		} else if (player1.equals("7♥")) {
			ponts[0] = 20;
		} else {
			ponts[0] = 30;
		};
// PLAYER 2 -------------------------------------------------------		
		if (player2.equals("Q♦") || player2.equals("Q♠") || player2.equals("Q♥") || player2.equals("Q♣")) {
			ponts[1] = 1;
		} else if (player2.equals("J♦") || player2.equals("J♠") || player2.equals("J♥") || player2.equals("J♣")) {
			ponts[1] = 2;
		} else if (player2.equals("K♦") || player2.equals("K♠") || player2.equals("K♥") || player2.equals("K♣")) {
			ponts[1] = 3;
		} else if (player2.equals("A♦") || player2.equals("A♥") || player2.equals("A♣")) {
			ponts[1] = 4;
		} else if (player2.equals("2♦") || player2.equals("2♠") || player2.equals("2♥") || player2.equals("2♣")) {
			ponts[1] = 5;
		} else if (player2.equals("3♦") || player2.equals("3♠") || player2.equals("3♥") || player2.equals("3♣")) {
			ponts[1] = 6;
		} else if (player2.equals("7♦")) {
			ponts[1] = 10;
		} else if (player2.equals("A♠")) {
			ponts[1] = 15;
		} else if (player2.equals("7♥")) {
			ponts[1] = 20;
		} else {
			ponts[1] = 30;
		};
// PLAYER 3 -------------------------------------------------------
		if (player3.equals("Q♦") || player3.equals("Q♠") || player3.equals("Q♥") || player3.equals("Q♣")) {
			ponts[2] = 1;
		} else if (player3.equals("J♦") || player3.equals("J♠") || player3.equals("J♥") || player3.equals("J♣")) {
			ponts[2] = 2;
		} else if (player3.equals("K♦") || player3.equals("K♠") || player3.equals("K♥") || player3.equals("K♣")) {
			ponts[2] = 3;
		} else if (player3.equals("A♦") || player3.equals("A♥") || player3.equals("A♣")) {
			ponts[2] = 4;
		} else if (player3.equals("2♦") || player3.equals("2♠") || player3.equals("2♥") || player3.equals("2♣")) {
			ponts[2] = 5;
		} else if (player3.equals("3♦") || player3.equals("3♠") || player3.equals("3♥") || player3.equals("3♣")) {
			ponts[2] = 6;
		} else if (player3.equals("7♦")) {
			ponts[2] = 10;
		} else if (player3.equals("A♠")) {
			ponts[2] = 15;
		} else if (player3.equals("7♥")) {
			ponts[2] = 20;
		} else {
			ponts[2] = 30;
		};
// PLAYER 4 -------------------------------------------------------
		if (player4.equals("Q♦") || player4.equals("Q♠") || player4.equals("Q♥") || player4.equals("Q♣")) {
			ponts[3] = 1;
		} else if (player4.equals("J♦") || player4.equals("J♠") || player4.equals("J♥") || player4.equals("J♣")) {
			ponts[3] = 2;
		} else if (player4.equals("K♦") || player4.equals("K♠") || player4.equals("K♥") || player4.equals("K♣")) {
			ponts[3] = 3;
		} else if (player4.equals("A♦") || player4.equals("A♥") || player4.equals("A♣")) {
			ponts[3] = 4;
		} else if (player4.equals("2♦") || player4.equals("2♠") || player4.equals("2♥") || player4.equals("2♣")) {
			ponts[3] = 5;
		} else if (player4.equals("3♦") || player4.equals("3♠") || player4.equals("3♥") || player4.equals("3♣")) {
			ponts[3] = 6;
		} else if (player4.equals("7♦")) {
			ponts[3] = 10;
		} else if (player4.equals("A♠")) {
			ponts[3] = 15;
		} else if (player4.equals("7♥")) {
			ponts[3] = 20;
		} else {
			ponts[3] = 30;
		};
		if (ponts[0] > ponts[1] && ponts[0] > ponts[2] && ponts[0] > ponts[3]) {
			return 1;
		} else if (ponts[1] > ponts[0] && ponts[1] > ponts[2] && ponts[1] > ponts[3]) {
			return 2;
		} else if (ponts[2] > ponts[0] && ponts[2] > ponts[1] && ponts[2] > ponts[3]) {
			return 3;
		} else if (ponts[3] > ponts[0] && ponts[3] > ponts[1] && ponts[3] > ponts[2]) {
			return 4;
		} else {
			return 0;
		}
	};
	public static void printTable(String[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
/*				if(i == 3 && j == 0 || i == 4 && j == 0 || i == 5 && j == 0
					||	i == 3 && j == 8 || i == 4 && j == 8 || i == 5 && j == 8	) {
					System.out.print("XX");
				}else {  						*/
					System.out.print(table[i][j]);

	//			};
			};
			System.out.println();
		}
		System.out.println();
	};
	public static Integer winnerRound(Integer win) {
		if (win.equals(1) || win.equals(3)) {
			return 1;
		} else if (win.equals(2) || win.equals(4)) {
			return 2;
		} else {
			return 3;
		}
	};
}