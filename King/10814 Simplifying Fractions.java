import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++){
			StringTokenizer st=new StringTokenizer(br.readLine()," / ");
			BigInteger numerator=new BigInteger(st.nextToken());
			BigInteger denominator=new BigInteger(st.nextToken());
			BigInteger gcd=numerator.gcd(denominator);
			numerator=numerator.divide(gcd);
			denominator=denominator.divide(gcd);
			System.out.println(numerator+" / "+denominator);
		}
	}
}