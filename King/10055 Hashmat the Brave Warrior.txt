/* Kingkingyyk, UVA 10055
import java.util.Scanner;

class Main {
	
	public static void main (String [] args) {
		Scanner sc=new Scanner(System.in);
		while (sc.hasNextLong()) {
			long i1=sc.nextLong();
			long i2=sc.nextLong();
			System.out.println(Math.max(i1-i2,i2-i1));
		}
	}
}