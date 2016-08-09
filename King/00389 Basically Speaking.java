import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String blank="       ";
		while (sc.hasNext()) {
			BigInteger bi=new BigInteger(sc.next(),sc.nextInt());
			String s=bi.toString(sc.nextInt());
			if (s.length()>7) {
				System.out.println("  ERROR");
			} else {
				System.out.print(blank.substring(0,7-s.length()));
				System.out.println(s.toUpperCase());
			}
		}
		sc.close();
	}
}