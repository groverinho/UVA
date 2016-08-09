import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BigInteger [] fac=new BigInteger [10001];
		fac[0]=BigInteger.ONE;
		for (int i=1;i<fac.length;i++) {
			fac[i]=fac[i-1].multiply(BigInteger.valueOf(i));
			while (fac[i].mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
				fac[i]=fac[i].divide(BigInteger.TEN);
			}
		}
		String blank="     ";
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			String ns=n+"";
			ns=blank.substring(0,5-ns.length())+ns;
			
			StringBuilder sb=new StringBuilder(ns);
			sb.append(" -> ");
			String facS=fac[n].toString();
			sb.append(facS.substring(facS.length()-1, facS.length()));
			System.out.println(sb.toString());
		}
	}
}