import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args)  throws IOException {  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		BigInteger sum=BigInteger.ZERO;
		while (!(s=br.readLine()).equals("0")) {
			sum=sum.add(new BigInteger(s));
		}
		
		System.out.println(sum.toString());
	}  
}