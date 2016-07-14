import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	public static BigInteger [][] dp;
	public static boolean [][] flag;
	
	public static BigInteger query (int coin, int remMoney) {
		if (!flag[coin][remMoney]) {
			if (remMoney==0) {
				dp[coin][remMoney]=BigInteger.ONE;
			} else if (coin==dp.length) {
				dp[coin][remMoney]=BigInteger.ZERO;
			} else {
				BigInteger ways=BigInteger.ZERO;
				for (int i=coin;i>0;i--) {
					if (remMoney>=i) {
						ways=ways.add(query(i,remMoney-i));
					}
				}
				dp[coin][remMoney]=ways;
			}
			flag[coin][remMoney]=true;
		}
		return dp[coin][remMoney];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		dp=new BigInteger [301][1001];
		flag=new boolean [301][1001];
		
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int count=0;
			int [] v=new int [3];
			while (st.hasMoreTokens()) {
				v[count++]=Integer.parseInt(st.nextToken());
			}
			
			if (count==0) {
				break;
			} else if (count==1) {
				System.out.println(query(300,v[0]));
			} else if (count==2) {
				v[1]=Math.min(300,v[1]);
				System.out.println(query(v[1],v[0]));
			} else if (count==3) {
				if (v[0]==0 && v[1]==0 && v[2]<=1) {
					System.out.println(1);
				} else if (v[1]>v[0] && v[2]>v[0]) {
					System.out.println(0);
				} else if (v[1]>v[2]) {
					System.out.println(0);
				} else {
					v[1]=Math.min(300,Math.max(v[1], 1));
					v[2]=Math.min(v[2],300);
					System.out.println(query(v[2],v[0]).subtract(query(v[1]-1,v[0])));
				}
			}
		}
		
	}
}