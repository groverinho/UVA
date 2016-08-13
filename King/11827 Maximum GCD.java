import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	public static BigInteger max (BigInteger bi, BigInteger bi2) {
		if (bi.compareTo(bi2)>=0) return bi;
		return bi2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			BigInteger [] ints=new BigInteger [st.countTokens()];
			for (int i=0;i<ints.length;i++) ints[i]=new BigInteger(st.nextToken());
			BigInteger gcd=BigInteger.ZERO;
			for (int i=0;i<ints.length-1;i++)
				for (int i2=i+1;i2<ints.length;i2++)
					gcd=max(gcd,ints[i].gcd(ints[i2]));
			System.out.println(gcd);
		}
	}
}