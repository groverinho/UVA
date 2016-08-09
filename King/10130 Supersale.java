import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static int [][] dp;
	
	public static int getValue(int [] objP, int [] objW, int id, int remWeight) {
		if (dp[id][remWeight]==-1) {
			if (id==objP.length || remWeight==0) {
				dp[id][remWeight]=0;
			} else if (remWeight>=objW[id]) {
				dp[id][remWeight]=Math.max(getValue(objP,objW,id+1,remWeight), objP[id]+getValue(objP,objW,id+1,remWeight-objW[id]));
			} else if (remWeight<objW[id]) {
				dp[id][remWeight]=getValue(objP,objW,id+1,remWeight);
			}
		}
		return dp[id][remWeight];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int objN=Integer.parseInt(br.readLine());
			int [] objP=new int [objN];
			int [] objW=new int [objN];
			
			for (int i=0;i<objN;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				objP[i]=Integer.parseInt(st.nextToken());
				objW[i]=Integer.parseInt(st.nextToken());
			}
			
			int maxW=0;
			int [] p=new int [Integer.parseInt(br.readLine())];
			for (int i=0;i<p.length;i++) {
				p[i]=Integer.parseInt(br.readLine());
				maxW=Math.max(maxW, p[i]);
			}
			
			dp=new int [objN+1][maxW+1];
			for (int [] dpc : dp) {
				Arrays.fill(dpc, -1);
			}
			
			int sum=0;
			for (int w : p) {
				sum+=getValue(objP,objW,0,w);
			}
			System.out.println(sum);
		}
	}
}