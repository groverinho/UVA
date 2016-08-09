import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BigInteger [] fac=new BigInteger [1001];
		fac[0]=BigInteger.ONE;
		for (int i=1;i<fac.length;i++) {
			fac[i]=fac[i-1].multiply(BigInteger.valueOf(i));
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			System.out.println(n+"!");
			System.out.println(fac[n]);
		}
	}
}