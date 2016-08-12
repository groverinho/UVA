import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	public static int [] v={1,2,3,1};
	public static BigInteger [] dp=new BigInteger [1001];
	
	public static BigInteger query (int remM) {
		if (dp[remM]==null) {
			BigInteger count=BigInteger.ZERO;
			for (int i=0;i<v.length;i++) {
				if (remM>=v[i]) {
					count=count.add(query(remM-v[i]));
				}
			}
			dp[remM]=count;
		}
		return dp[remM];
	}
	
	public static void main(String[] args) throws IOException {
		dp[0]=BigInteger.ONE;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			System.out.println(query(Integer.parseInt(new StringTokenizer(s).nextToken())));
		}
	}
}