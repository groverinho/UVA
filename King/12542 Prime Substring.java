import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			BigInteger largestPrime=BigInteger.ZERO;
			for (int start=0;start<s.length();start++) {
				for (int end=start+1;end<=s.length() && end<=start+5;end++) {
					BigInteger test=new BigInteger(s.substring(start,end));
					if (test.isProbablePrime(10) && test.compareTo(largestPrime)>0) {
						largestPrime=test;
					}
				}
			}
			System.out.println(largestPrime);
		}
	}
}