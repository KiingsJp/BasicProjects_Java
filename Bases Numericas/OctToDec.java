import java.util.Scanner;
public class OctToDec {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Octal number: ");
		String x = sc.next();
		sc.close();
		char[] ch = x.toCharArray();
		Long[] in = new Long[ch.length];
		for(int i = 0; i < ch.length; i++) {
			in[i] = (long) Character.getNumericValue(ch[i]);
		};
		int pow = 0;
		int result = 0;
		for(int i = in.length-1; i > -1; i--) {
			result = result + (int)(in[i]*Math.pow(8,pow));
			pow++;
		};
		System.out.print("Decimal: ");
		System.out.print(result);
	};
}

