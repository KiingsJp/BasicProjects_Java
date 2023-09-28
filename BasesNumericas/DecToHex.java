import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecToHex {
	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a decimal number: ");
		Long x = sc.nextLong();
		sc.close();
		Long w = (long) 0;
		Long k = x%16;
			str.add(k.toString());
		do {
			x /= 16;
			w = x % 16;
			if(w == 10) {
				str.add("A");
			}
			else if(w == 11) {
				str.add("B");
			}
			else if(w == 12) {
				str.add("C");
			}
			else if(w == 13) {
				str.add("D");
			}
			else if(w == 14) {
				str.add("E");
			}
			else if(w == 15) {
				str.add("F");
			}
			else {
				str.add(w.toString());
			};
		} while(x >= 16);
		char[] ch = new char[str.size()];
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.get(i).charAt(0);
		};
		System.out.print("Hexadecimal: ");
		for(int i = ch.length -1; i > -1; i--) {
			System.out.print(ch[i]);
		};
	}
}
