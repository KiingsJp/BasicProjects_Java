
import java.util.Scanner;

public class HexToDec {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a hexadecimal number: ");
		String str = sc.next();
		sc.close();
		char[] ch = new char[];
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
		};
		Integer x = 0;
		int pow = 0, result = 0;
		for(int i = ch.length -1; i > -1; i--) {
			if(ch[i] == 'A') {
				x = 10;
			}
			else if(ch[i] == 'B') {
				x = 11;
			}
			else if(ch[i] == 'C') {
				x = 12;
			}
			else if(ch[i] == 'D') {
				x = 13;
			}
			else if(ch[i] == 'E') {
				x = 14;
			}
			else if(ch[i] == 'F') {
				x = 15;
			}
			else {
				x = Character.getNumericValue(ch[i]);
			};
			result += (int) x * Math.pow(16, pow);
			pow++;
		};
		System.out.println(result);
	}
}
