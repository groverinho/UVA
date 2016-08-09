import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static BigInteger reverse (BigInteger b) {
		BigInteger n=BigInteger.ZERO;
		while (b.compareTo(BigInteger.ZERO)>0) {
			n=n.multiply(BigInteger.TEN).add(b.mod(BigInteger.TEN));
			b=b.divide(BigInteger.TEN);
		}
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			BigInteger a=new BigInteger(st.nextToken());
			BigInteger b=new BigInteger(st.nextToken());
			
			System.out.println(reverse(reverse(a).add(reverse(b))));
		}
	}
}