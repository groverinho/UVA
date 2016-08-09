import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int budget=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			
			int [] price=new int [N];
			int [] rating=new int [N];
			
			for (int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				price[i]=Integer.parseInt(st.nextToken());
				rating[i]=Integer.parseInt(st.nextToken());
			}
			
			int [] dp=new int [budget+201];
			Arrays.fill(dp,Integer.MIN_VALUE);
			dp[0]=0;
			
			for (int i=0;i<N;i++) {
				for (int i2=dp.length-1;i2>=price[i];i2--) {
					dp[i2]=Math.max(dp[i2], rating[i]+dp[i2-price[i]]);
				}
			}
		
			
			int ans=0;
			for (int i=0;i<=budget;i++) {
				ans=Math.max(ans, dp[i]);
			}
			for (int i=2001;i<=budget+200;i++) {
				ans=Math.max(ans, dp[i]);
			}
			
			System.out.println(ans);
		}
	}
}