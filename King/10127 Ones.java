import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			BigInteger a=new BigInteger(s);
			BigInteger bi=BigInteger.ONE;
			
			int count=1;
			while (!bi.mod(a).equals(BigInteger.ZERO)) {
				bi=bi.multiply(BigInteger.TEN).add(BigInteger.ONE);
				count++;
			}
			
			System.out.println(count);
		}
	}    
}