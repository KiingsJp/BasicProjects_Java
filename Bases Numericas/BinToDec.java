import java.util.Locale;
import java.util.Scanner;
public class BinToDec{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		System.out.print("Enter the Binary number: ");	
		String str = sc.next();
		char[] ch = str.toCharArray();
		Long[] in = new Long[ch.length];
		for(int i = 0; i < ch.length; i++) {
			in[i] = (long) Character.getNumericValue(ch[i]);
		};	
		int result = 0;
		int pow = 0;
		for(int i = in.length -1; i > -1; i--) {
			result = result + (int)(in[i]*Math.pow(2,pow));
			pow += 1;
		};
		System.out.println("Decimal: " + result);
		sc.close();
	};
};

