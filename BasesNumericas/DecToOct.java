import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class DecToOct {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Long> rests = new ArrayList<>();
		System.out.print("Enter a decimal number: ");
		Long x = sc.nextLong();
		sc.close();
		do {
			Long rest1 = x % 8;
			x = x / 8;
			rests.add(rest1);
				if (x < 8) {
					rests.add(x);
				};
		} while (x >= 8);
		System.out.print("Octal: ");
		for (int i = rests.size() - 1; i > -1; i--) {
			System.out.print(rests.get(i));
		};
	}
}