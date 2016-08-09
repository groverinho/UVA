import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
/* 1) Only consider numbers until 2*L.
   2) Try to get the maximum value from the set of numbers, it will be our left hand side.
   3) The unused number will be our right hand side.
*/

	public static int [][] dp;
	public static boolean [][] flag;
	
	public static int search(int [] carL, int id, int remLeft) {
		if (dp[id][remLeft]==-1) {
			if (id==carL.length || remLeft==0) {
				dp[id][remLeft]=0;
			} else if (remLeft>=carL[id]) {
				int v1=search(carL,id+1,remLeft);
				int v2=carL[id]+search(carL,id+1,remLeft-carL[id]);
				if (v2>=v1) {
					dp[id][remLeft]=v2;
					flag[id][remLeft]=true;
				} else {
					dp[id][remLeft]=v1;
				}
			} else if (remLeft<carL[id]) {
				dp[id][remLeft]=search(carL,id+1,remLeft);
			}
		}
		return dp[id][remLeft];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine(); //blank.
			if (testCase>0) {
				System.out.println();
			}
			
			int L=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken())*100;
			ArrayList<Integer> list=new ArrayList<>();
			String s;
			int culSum=0;
			while (!(s=br.readLine()).equals("0")) {
				int zz=Integer.parseInt(new StringTokenizer(s).nextToken());
				culSum+=zz;
				if (culSum<=L*2) {
					list.add(zz);
				}
			}

			int [] carL=new int [list.size()];
			for (int i=0;i<list.size();i++) {
				carL[i]=list.get(i);
			}
			
			dp=new int [carL.length+1][L+1];
			for (int [] dpS : dp) {
				Arrays.fill(dpS, -1);
			}
			flag=new boolean [carL.length][L+1];
			search(carL,0,L);
			int curr=L;
			
			int count=0;
			int rightSum=0;
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<carL.length;i++) {
				if (flag[i][curr]) {
					curr-=carL[i];
					count++;
					sb.append("port\n");
				} else if (rightSum+carL[i]<=L) {
					rightSum+=carL[i];
					count++;
					sb.append("starboard\n");
				}
			}
			
			System.out.println(count);
			System.out.print(sb.toString());
		}
	}
}