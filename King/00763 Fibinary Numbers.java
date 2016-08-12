import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

	public static BigInteger [] fib=new BigInteger[105];
	
	public static void initTable () {
		fib[0]=BigInteger.ONE;
		fib[1]=BigInteger.ONE;
		for (int i=2;i<fib.length;i++) {
			fib[i]=fib[i-1].add(fib[i-2]);
		}
	}
	
	public static BigInteger fibToBigInt (String s) {
		int startIndex=0;
		while (startIndex<s.length() && s.charAt(startIndex)=='0') {
			startIndex++;
		}
		if (startIndex==s.length()) {
			return BigInteger.ZERO;
		} else {
			s=s.substring(startIndex,s.length());
		}
		BigInteger bi=BigInteger.ZERO;
		for (int i=0;i<s.length();i++)
			if (s.charAt(i)=='1') bi=bi.add(fib[s.length()-i]);
		//System.out.println(bi);
		return bi;
	}
	
	public static String bigIntToFib (BigInteger bi) {
		StringBuilder sb=new StringBuilder();
		for (int i=fib.length-1;i>0;i--) {
			if (bi.compareTo(fib[i])>=0) {
				sb.append('1');
				bi=bi.subtract(fib[i]);
			} else {
				sb.append('0');
			}
		}
		//Removing leading zeroes.
		String s=sb.toString();
		int startIndex=0;
		while (startIndex<s.length() && s.charAt(startIndex++)=='0') {
		}
		return s.substring(startIndex-1,s.length());
	}
	
	public static void main(String[] args) throws IOException {
		initTable();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int t=0;
		while ((s=br.readLine())!=null) {
			BigInteger bi1=fibToBigInt(s);
			BigInteger bi2=fibToBigInt(br.readLine());
			BigInteger sum=bi1.add(bi2);
			if (t++>0) {
				System.out.println();
			}
			System.out.println(bigIntToFib(sum));
			br.readLine(); //empty.
		}
	}
}