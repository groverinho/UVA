import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BigInteger [] fac=new BigInteger[21]; //max 20 letters.
		fac[0]=BigInteger.ONE;
		for (int i=1;i<fac.length;i++) {
			fac[i]=fac[i-1].multiply(BigInteger.valueOf(i));
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int [] charCount=new int [128];
			char [] c=br.readLine().toCharArray();
			for (int i=0;i<c.length;i++) {
				charCount[c[i]]++;
			}
			
			BigInteger divisor=BigInteger.ONE;
			for (int i=0;i<charCount.length;i++) {
				if (charCount[i]>1) {
					divisor=divisor.multiply(fac[charCount[i]]);
				}
			}
			
			System.out.println("Data set "+testCase+": "+fac[c.length].divide(divisor));
		}
	}
}