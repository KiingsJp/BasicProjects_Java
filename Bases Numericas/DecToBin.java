import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecToBin {
	public static void main(String[] args) {
		List<Long> bin = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a decimal number: ");
		Long x = sc.nextLong();
		sc.close();
		while(x != 0) {
			bin.add(x%2);
			x = x / 2;
		};
		System.out.println("Binary: ");
		for(int i = bin.toArray().length - 1; i > -1; i--) {
			System.out.print(bin.get(i));
		};
	}
}
