import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BigInteger lowerLimit=BigInteger.valueOf(10000);
		BigInteger upperLimit=BigInteger.valueOf(6227020800L);
		int lowerLimitN=0;
		int upperLimitN=0;
		BigInteger [] fac=new BigInteger[15]; //upper limit is 13!.
		fac[0]=BigInteger.ONE;
		for (int i=1;true;i++) {
			fac[i]=fac[i-1].multiply(BigInteger.valueOf(i));
			if (fac[i].compareTo(lowerLimit)>0 && lowerLimitN==0) {
				lowerLimitN=i;
			}
			if (fac[i].compareTo(upperLimit)>0 && upperLimitN==0) {
				upperLimitN=i-1;
				break;
			}
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			if (n>=0) {
				if (n<lowerLimitN) {
					System.out.println("Underflow!");
				} else if (n>upperLimitN) {
					System.out.println("Overflow!");
				} else {
					System.out.println(fac[n]);
				}
			} else {
				if (n%2==0) {
					System.out.println("Underflow!");
				} else {
					System.out.println("Overflow!");
				}
			}

		}
	}
}