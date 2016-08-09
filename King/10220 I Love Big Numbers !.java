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
			while (fac[i].mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
				//ending zero are useless. Removing them can yield some time back on later iteration.
				fac[i]=fac[i].divide(BigInteger.TEN);
			}
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			char [] nums=fac[n].toString().toCharArray();
			int count=0;
			for (int i=0;i<nums.length;i++) {
				count=count+(nums[i]-'0');
			}
			
			System.out.println(count);
		}
	}
}