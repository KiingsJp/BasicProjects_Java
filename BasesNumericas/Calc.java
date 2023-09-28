import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Calc {
	public static void main(String[]args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a number type for convert: ");
		System.out.println("1 - Decimal");
		System.out.println("2 - Binary");
		System.out.println("3 - Octal");
		System.out.println("4 - Hexadecimal");
		System.out.print("Type: ");
		char type1 = sc.next().charAt(0);
		System.out.println("-------------------------------------------");
		String str;
		if(type1 == '1') {
			System.out.print("Enter a Decimal number: ");
			Long dc = sc.nextLong();
			decToBin(dc);
			decToOct(dc);
			decToHex(dc);
		}
		else if(type1 == '2') {
			System.out.print("Enter a Binary number: ");
			str = sc.next();
			binToDec(str);
			binToOct(str);
			binToHex(str);
		}
		else if(type1 == '3') {
			System.out.print("Enter a Octal number: ");
			str= sc.next();
			octToDec(str);
			octToBin(str);
			octToHex(str);
		}
		else if(type1 == '4') {
			System.out.print("Enter a Hexadecimal number: ");
			str = sc.next();
			hexToDec(str);
			hexToBin(str);
			hexToOct(str);
		};
		sc.close();
	};
	
	private static void decToBin(Long dc) {
		List<Long> bin = new ArrayList<>();
		Long x = dc;
		while(x != 0) {
			bin.add(x%2);
			x = x / 2;
		};
		System.out.print("\nBinary: ");
		for(int i = bin.toArray().length - 1; i > -1; i--) {
			System.out.print(bin.get(i));
		};
	};
	private static void decToOct(Long dc) {
		List<Long> rests = new ArrayList<>();
		Long x = dc;
		do {
			Long rest1 = x % 8;
			x = x / 8;
			rests.add(rest1);
				if (x < 8) {
					rests.add(x);
				};
		} while (x >= 8);
		System.out.print("\nOctal: ");
		for (int i = rests.size() - 1; i > -1; i--) {
			System.out.print(rests.get(i));
		};
	};
	private static void decToHex(Long dc) {
		List<String> list = new ArrayList<>();
		Long x = dc;
		while(x >= 16) {
			Long y = (long)(x % 16);
			if(y == 10) {
				list.add("A");
			}
			else if(y == 11) {
				list.add("B");
			}
			else if(y == 12) {
				list.add("C");
			}
			else if(y == 13) {
				list.add("D");
			}
			else if(y == 14) {
				list.add("E");
			}
			else if(y == 15) {
				list.add("F");
			}
			else {
				list.add(y.toString());
			};
			x /= 16;
			if(x < 16) {		
				if(x == 10) {
					list.add("A");
				}
				else if(x == 11) {
					list.add("B");
				}
				else if(x == 12) {
					list.add("C");
				}
				else if(x == 13) {
					list.add("D");
				}
				else if(x == 14) {
					list.add("E");
				}
				else if(x == 15) {
					list.add("F");
				}
				else {
					list.add(x.toString());
				};	
			};
		};
		char[] hex = new char[list.size()];
		for(int i = hex.length -1; i > -1; i--) {
			hex[i] = list.get(i).charAt(0);
		};
		System.out.print("\nHexadecimal: ");
		for(int i = hex.length -1; i > -1; i--) {
			System.out.print(hex[i]);
		};
	};
	
	private static void binToDec(String stg) {
		String str = stg;
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
		System.out.println("\nDecimal: " + result);
	};
	private static void binToOct(String stg) {
		String str = stg;
		char[] ch = str.toCharArray();
		Long[] in = new Long[ch.length];
		for(int i = 0; i < ch.length; i++) {
			in[i] = (long) Character.getNumericValue(ch[i]);
		};	
		Long decimal = (long)0;
		int pow = 0;
		for(int i = in.length -1; i > -1; i--) {
			decimal = decimal + (int)(in[i]*Math.pow(2,pow));
			pow += 1;
		};
		List<Long> rests = new ArrayList<>();
		Long x = decimal;
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
	};
	private static void binToHex(String stg) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		String str = stg;
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

		List<String> list = new ArrayList<>();
		Long x = (long) result;
		sc.close();
			while(x >= 16) {
				Long y = (long)(x % 16);
				if(y == 10) {
					list.add("A");
				}
				else if(y == 11) {
					list.add("B");
				}
				else if(y == 12) {
					list.add("C");
				}
				else if(y == 13) {
					list.add("D");
				}
				else if(y == 14) {
					list.add("E");
				}
				else if(y == 15) {
					list.add("F");
				}
				else {
					list.add(y.toString());
				};
				x /= 16;
				if(x < 16) {		
					if(x == 10) {
						list.add("A");
					}
					else if(x == 11) {
						list.add("B");
					}
					else if(x == 12) {
						list.add("C");
					}
					else if(x == 13) {
						list.add("D");
					}
					else if(x == 14) {
						list.add("E");
					}
					else if(x == 15) {
						list.add("F");
					}
					else {
						list.add(x.toString());
					};	
				};
			};
		char[] ch1 = new char[list.size()];
		for(int i = 0; i < ch1.length; i++) {
			ch1[i] = list.get(i).charAt(0);
		};
		System.out.print("\nHexadecimal: ");
		for(int i = ch1.length -1; i > -1; i--) {
			System.out.print(ch1[i]);
		};
		sc.close();
	};
	
	private static void octToDec(String strOct) {
		String x = strOct;
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
		System.out.print("\nDecimal: " + result);
	};
	private static void octToBin(String strOct) {
		String x = strOct;
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
		List<Long> bin = new ArrayList<>();
		Long resp = (long)result;
		while(resp != 0) {
			bin.add(resp%2);
			resp = resp / 2;
		};
		System.out.print("\nBinary: ");
		for(int i = bin.toArray().length - 1; i > -1; i--) {
			System.out.print(bin.get(i));
		};
	};
	private static void octToHex(String strOct) {
		String x1 = strOct;
		char[] ch = x1.toCharArray();
		Long[] in = new Long[ch.length];
		for(int i = 0; i < ch.length; i++) {
			in[i] = (long) Character.getNumericValue(ch[i]);
		};
		int pow = 0;
		Long result = (long) 0;
		for(int i = in.length-1; i > -1; i--) {
			result = result + (long)(in[i]*Math.pow(8,pow));
			pow++;
		};
		List<String> list = new ArrayList<>();
		Long x = result;
		while(x >= 16) {
			Long y = (long)(x % 16);
			if(y == 10) {
				list.add("A");
			}
			else if(y == 11) {
				list.add("B");
			}
			else if(y == 12) {
				list.add("C");
			}
			else if(y == 13) {
				list.add("D");
			}
			else if(y == 14) {
				list.add("E");
			}
			else if(y == 15) {
				list.add("F");
			}
			else {
				list.add(y.toString());
			};
			x /= 16;
			if(x < 16) {		
				if(x == 10) {
					list.add("A");
				}
				else if(x == 11) {
					list.add("B");
				}
				else if(x == 12) {
					list.add("C");
				}
				else if(x == 13) {
					list.add("D");
				}
				else if(x == 14) {
					list.add("E");
				}
				else if(x == 15) {
					list.add("F");
				}
				else {
					list.add(x.toString());
				};	
			};
		};
		char[] chk = new char[list.size()];
		for(int i = 0; i < chk.length; i++) {
			chk[i] = list.get(i).charAt(0);
		};
		System.out.print("\nHexadecimal: ");
		for(int i = chk.length -1; i > -1; i--) {
			System.out.print(chk[i]);
		};
	};

	private static void hexToDec(String strHex) {
		String str = strHex;
		char[] ch = new char[str.length()];
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
		System.out.print("\nDecimal: " + result);
	};
	private static void hexToBin(String strHex) {
		String str = strHex;
		char[] ch = new char[str.length()];
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
		};
		Integer x = 0;
		Long pow =(long) 0, result = (long)0;
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
			result += x * (long) Math.pow(16, pow);
			pow++;
		};
		List<Long> bin = new ArrayList<>();
		Long x1 = result;
		while(x1 != 0) {
			bin.add(x1%2);
			x1 = x1 / 2;
		};
		System.out.print("\nBinary: ");
		for(int i = bin.toArray().length - 1; i > -1; i--) {
			System.out.print(bin.get(i));
		};
	};
	private static void hexToOct(String strHex) {
		String str = strHex;
		char[] ch = new char[str.length()];
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
		};
		Integer x = 0;
		int pow = 0;
		Long result = (long)0;
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
			result += x * (long)Math.pow(16, pow);
			pow++;
		};
		List<Long> rests = new ArrayList<>();
		Long x1 = result;
		do {
			Long rest1 = x1 % 8;
			x1 = x1 / 8;
			rests.add(rest1);
				if (x1 < 8) {
					rests.add(x1);
				};
		} while (x1 >= 8);
		System.out.print("\nOctal: ");
		for (int i = rests.size() - 1; i > -1; i--) {
			System.out.print(rests.get(i));
		};
	};
}