import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static int [] coins={5,10,20,50,100,200};
	public static int [] myCoinCount;
	public static int [] dp;
	
	public static int querySellerCoin (int money) {
		int count=0;
		for (int i=coins.length-1;i>=0;i--) {
			count+=(money/coins[i]);
			money%=coins[i];
		}
		return count;
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		final int invalidCount=123456;
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			myCoinCount=new int [coins.length];
			
			boolean quit=true;
			int sum=0;
			for (int i=0;i<myCoinCount.length;i++) {
				myCoinCount[i]=Integer.parseInt(st.nextToken());
				quit=quit && (myCoinCount[i]==0);
				sum+=(myCoinCount[i]*coins[i]);
			}
			if (quit) {
				break;
			}
			
			int target=(int)(Double.parseDouble(st.nextToken())*100);
			dp=new int [Math.max(sum+1,501)];
			Arrays.fill(dp, invalidCount);
			dp[0]=0;
			for (int i=0;i<coins.length;i++) {
				for (int i2=0;i2<myCoinCount[i];i2++) {
					int [] currDP=Arrays.copyOf(dp,dp.length);
					for (int i3=coins[i];i3<dp.length;i3+=5) {
						currDP[i3]=Math.min(currDP[i3], 1+dp[i3-coins[i]]);
					}
					dp=currDP;
				}
			}
			
			int min=Integer.MAX_VALUE;
			for (int i=dp.length-1;i>=target;i--) {
				if (dp[i]!=invalidCount) {
					min=Math.min(min, dp[i]+querySellerCoin(i-target));
				}
			}
			
			String blank="   ";
			System.out.println(blank.substring(0,3-String.valueOf(min).length())+min);
		}
	}
}