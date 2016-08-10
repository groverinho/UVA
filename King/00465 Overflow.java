import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		BigInteger maxInt=BigInteger.valueOf(Integer.MAX_VALUE);
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			BigInteger bi1=new BigInteger(st.nextToken());
			char operator=st.nextToken().charAt(0);
			BigInteger bi2=new BigInteger(st.nextToken());
			System.out.println(s);
			if (bi1.compareTo(maxInt)>0) {
				System.out.println("first number too big");
			}
			if (bi2.compareTo(maxInt)>0) {
				System.out.println("second number too big");
			}
			BigInteger result=BigInteger.ZERO;
			if (operator=='+') {
				result=bi1.add(bi2);
			} else if (operator=='*') {
				result=bi1.multiply(bi2);
			}
			if (result.compareTo(maxInt)>0) {
				System.out.println("result too big");
			}
		}
	}
}