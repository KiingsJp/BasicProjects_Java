package entities;

public class Table {
	public Table() {
		
	};
	public static String[][] table(String[] player1, String[] player2, String[] player3, String[] player4){
		String[][] table = new String [9][9];
		table[0][3] = player1[0];
		table[0][4] = player1[1];
		table[0][5] = player1[2];
		
		table[3][0] = player2[0];
		table[4][0] = player2[1];
		table[5][0] = player2[2];
		
		table[8][3] = player3[0];
		table[8][4] = player3[1];
		table[8][5] = player3[2];
		
		table[3][8] = player4[0];
		table[4][8] = player4[1];
		table[5][8] = player4[2];
		
		table[0][0] = "----";
		table[0][1] = "-";
		table[0][2] = "-";
//		table[0][3] = "-";
//		table[0][4] = "-";
//		table[0][5] = "-";
		table[0][6] = "-";
		table[0][7] = "-";
		table[0][8] = "---";
		
		table[1][0] = "---------";
		table[1][1] = "-";
		table[1][2] = "-";
		table[1][3] = "-";
		table[1][4] = "-";
		table[1][5] = "-";
		table[1][6] = "-";
		table[1][7] = "-";
		table[1][8] = "-";
		
		table[2][0] = "-";
		table[2][1] = "-";
		table[2][2] = "--";
		table[2][3] = "-";
		table[2][4] = "-";
		table[2][5] = "-";
		table[2][6] = "-";
		table[2][7] = "-";
		table[2][8] = "-------";
		
//		table[3][0] = "-";
		table[3][1] = "-";
		table[3][2] = "-";
		table[3][3] = "-";
		table[3][4] = "--------";
		table[3][5] = "-";
		table[3][6] = "-";
		table[3][7] = "-";
//		table[3][8] = "-";
		
//		table[4][0] = "-";
		table[4][1] = "-";
		table[4][2] = "-";
		table[4][3] = "--";
		table[4][4] = "------";
		table[4][5] = "--";
		table[4][6] = "-";
		table[4][7] = "-";
//		table[4][8] = "-";
		
//		table[5][0] = "-";
		table[5][1] = "-";
		table[5][2] = "-";
		table[5][3] = "--------";
		table[5][4] = "-";
		table[5][5] = "-";
		table[5][6] = "-";
		table[5][7] = "-";
//		table[5][8] = "-";
		
		table[6][0] = "-";
		table[6][1] = "-";
		table[6][2] = "-";
		table[6][3] = "-";
		table[6][4] = "-";
		table[6][5] = "-";
		table[6][6] = "--";
		table[6][7] = "--";
		table[6][8] = "-------";
		
		table[7][0] = "-";
		table[7][1] = "-";
		table[7][2] = "-";
		table[7][3] = "-";
		table[7][4] = "-";
		table[7][5] = "-";
		table[7][6] = "--";
		table[7][7] = "--";
		table[7][8] = "-------";
		
		table[8][0] = "----";
		table[8][1] = "-";
		table[8][2] = "-";
//		table[8][3] = "-";
//		table[8][4] = "-";
//		table[8][5] = "-";
		table[8][6] = "-";
		table[8][7] = "-";
		table[8][8] = "---";
		return table;
		
	}
}
