import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			BigInteger S1=new BigInteger(br.readLine(),2);
			BigInteger S2=new BigInteger(br.readLine(),2);
			if (S1.compareTo(S2)>0) {
				BigInteger temp=S2;
				S2=S1;
				S1=temp;
			}
			
			BigInteger factor=S1.gcd(S2);
			/*
			 * Special case : N N is accepted, but expect for 1 1.
			 */
			if ((S1.equals(S2) && !S1.equals(BigInteger.ONE)) || (factor.compareTo(BigInteger.ONE)>0 && S2.divide(factor).compareTo(BigInteger.ONE)>0)) {
				System.out.println("Pair #"+testCase+": All you need is love!");
			} else {
				System.out.println("Pair #"+testCase+": Love is not all you need!");
			}
		}
	}
}