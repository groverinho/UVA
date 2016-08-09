import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	// Oh well, the question is trying to fool you to do coin, but it is in fact a 0/1 knapsack problem. :P
	
	public static int [][] dp;
	public static boolean [][] flag;
	
	public static int query (int [] coin, int id, int remMoney) {
		if (!flag[id][remMoney]) {
			if (remMoney==0) {
				dp[id][remMoney]=0;
			} else if (id==coin.length) {
				dp[id][remMoney]=12345678;
			} else if (remMoney>=coin[id]) {
				dp[id][remMoney]=Math.min(query(coin,id+1,remMoney), 1+query(coin,id+1,remMoney-coin[id]));
			} else if (remMoney<coin[id]) {
				dp[id][remMoney]=query(coin,id+1,remMoney);
			}
			flag[id][remMoney]=true;
		}
		return dp[id][remMoney];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int s=Integer.parseInt(br.readLine());
			int N=Integer.parseInt(br.readLine());
			int [] money=new int [N];
			for (int i=0;i<N;i++) {
				money[i]=Integer.parseInt(br.readLine());
			}
			
			dp=new int [N+1][10001];
			for (int [] dpS : dp) {
				Arrays.fill(dpS, 12345678);
			}
			flag=new boolean [N+1][10001];
			
			for (int value=s;value<dp[N].length;value++) {
				if (query(money,0,value)!=12345678) {
					System.out.println(value+" "+query(money,0,value));
					break;
				}
			}
		}
	}
}