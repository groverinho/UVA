import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static int [][] dp;
	public static boolean [][] dpFlag;
	public static int [] weight;
	public static int [] load;
	
	public static int knapsack (int id, int remWeight) {
		if (id==weight.length || remWeight<=0) {
			return 0;
		} else {
			if (!dpFlag[id][remWeight]) {
				int value=knapsack(id+1,remWeight);
				if (remWeight>=weight[id]) {
					value=Math.max(value, 1+knapsack(id+1,Math.min(remWeight-weight[id], load[id])));
				}
				dp[id][remWeight]=value;
				dpFlag[id][remWeight]=true;
			}
		}
		return dp[id][remWeight];
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N=Integer.parseInt(br.readLine());
			if (N==0) {
				break;
			}
			weight=new int [N];
			load=new int [N];
			
			for (int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				weight[i]=Integer.parseInt(st.nextToken());
				load[i]=Integer.parseInt(st.nextToken());
			}
			
			dp=new int [N+1][6001];
			dpFlag=new boolean [N+1][6001]; //3000 + 3000. After reducing the maximum possible weight (3000), we should have maximum weight of (3000, max load).
			System.out.println(knapsack(0,6000));
		}
	}
}