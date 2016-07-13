import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static int [][] dp;
	public static boolean [][] flag;
	
	public static int query (int [][] coin, int remA, int remB) {
		if (!flag[remA][remB]) {
			flag[remA][remB]=true;
			if (remA==0 && remB==0) {
				dp[remA][remB]=0;
			} else {
				for (int i=0;i<coin.length;i++) {
					if (remA>=coin[i][0] && remB>=coin[i][1]) {
						dp[remA][remB]=Math.min(dp[remA][remB],1+query(coin,remA-coin[i][0],remB-coin[i][1]));
					}
				}
			}
		}
		return dp[remA][remB];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			
			int [][] coin=new int [m][2];
			for (int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				coin[i][0]=Integer.parseInt(st.nextToken());
				coin[i][1]=Integer.parseInt(st.nextToken());
			}
			
			dp=new int [301][301];
			flag=new boolean [301][301];
			for (int[] dpS : dp) {
				Arrays.fill(dpS, 12345678);
			}
			
			int ans=Integer.MAX_VALUE;
			for (int i=0;i<=s;i++) {
				for (int i2=0;i2<=s;i2++) {
					double sqrt=Math.sqrt(i*i+i2*i2);
					if ((sqrt==(double)(int)sqrt && sqrt==s)) {
						ans=Math.min(ans, query(coin,i,i2));
					} else if (sqrt>s) {
						break;
					}
				}
			}
			
			if (ans==12345678) {
				System.out.println("not possible");
			} else {
				System.out.println(ans);
			}
			
			br.readLine(); //empty
		}
	}
}