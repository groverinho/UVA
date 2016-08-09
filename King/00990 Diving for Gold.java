import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static int [][] dp;
	public static boolean [][] flag;
	
	public static int getValue(int [] time, int [] gold, int id, int remTime) {
		if (dp[id][remTime]==-1) {
			if (id==time.length || remTime==0) {
				dp[id][remTime]=0;
			} else if (time[id]>remTime) {
				dp[id][remTime]=getValue(time,gold,id+1,remTime);
			} else if (time[id]<=remTime) {
				int v1=getValue(time,gold,id+1,remTime);
				int v2=gold[id]+getValue(time,gold,id+1,remTime-time[id]);
				if (v1>v2) {
					dp[id][remTime]=v1;
				} else {
					dp[id][remTime]=v2;
					flag[id][remTime]=true;
				}
			}
			
		}
		return dp[id][remTime];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=0;
		while (true) {
			if (testCase++>0) {
				System.out.println();
			}
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(br.readLine());
			int [] depth=new int [N];
			int [] time=new int [N];
			int [] gold=new int [N];
			for (int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				depth[i]=Integer.parseInt(st.nextToken());
				time[i]=3*w*depth[i];
				gold[i]=Integer.parseInt(st.nextToken());
			}
			
			dp=new int [N+1][t+1];
			flag=new boolean [N][t+1];
			for (int i=0;i<dp.length;i++) {
				Arrays.fill(dp[i], -1);
			}
			int maxValue=getValue(time,gold,0,t);
			System.out.println(maxValue);

			int currTime=t;
			int [] solution=new int [N];
			int solCount=0;
			for (int i=0;i<N;i++) {
				if (flag[i][currTime]) {
					currTime-=time[i];
					solution[solCount++]=i;
				}
			}
			
			System.out.println(solCount);
			for (int i=0;i<solCount;i++) {
				System.out.println(depth[solution[i]]+" "+gold[solution[i]]);
			}
			
			if (br.readLine()==null) {
				break;
			}
		}
	}
}