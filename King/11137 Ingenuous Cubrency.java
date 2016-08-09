import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BigInteger [] dp=new BigInteger [10000];
		Arrays.fill(dp, BigInteger.ZERO);
		dp[0]=BigInteger.ONE;
		
		int [] money=new int [21];
		for (int i=1;i<=money.length;i++) {
			money[i-1]=i*i*i;
		}
		
		for (int i=0;i<money.length;i++) {
			for (int i2=money[i];i2<dp.length;i2++) {
				dp[i2]=dp[i2].add(dp[i2-money[i]]);
			}
		}
		
		String s;
		while ((s=br.readLine())!=null) {
			System.out.println(dp[Integer.parseInt(new StringTokenizer(s).nextToken())]);
		}
		
	}
}