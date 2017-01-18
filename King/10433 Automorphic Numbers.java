import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			BigInteger bi=new BigInteger(s);
			bi=bi.multiply(bi);
			if (bi.toString().endsWith(s)) System.out.println("Automorphic number of "+s.length()+"-digit.");
			else System.out.println("Not an Automorphic number.");
		}
	}
}