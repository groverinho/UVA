import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

	public static BigInteger bi400=new BigInteger("400");
	public static BigInteger bi4=new BigInteger("4");
	public static BigInteger bi100=new BigInteger("100");
	public static BigInteger bi15=new BigInteger("15");
	public static BigInteger bi55=new BigInteger("55");
	
	public static boolean isLeap (BigInteger y) {
		return y.mod(bi400).equals(BigInteger.ZERO) || (y.mod(bi4).equals(BigInteger.ZERO) && !y.mod(bi100).equals(BigInteger.ZERO));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int t=0;
		while ((s=br.readLine())!=null) {
			BigInteger year=new BigInteger(s);
			boolean leap=isLeap(year);
			boolean huluculu=year.mod(bi15).equals(BigInteger.ZERO);
			boolean bulukulu=leap && year.mod(bi55).equals(BigInteger.ZERO);
			boolean notLeap=!(leap || huluculu || bulukulu);
			if (t++>0) {
				System.out.println();
			}
			if (leap)
				System.out.println("This is leap year.");
			if (huluculu)
				System.out.println("This is huluculu festival year.");
			if (bulukulu)
				System.out.println("This is bulukulu festival year.");
			if (notLeap)
				System.out.println("This is an ordinary year.");
		}
	}
}