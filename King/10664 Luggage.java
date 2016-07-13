import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static int [][] dp;
	
	public static int query (int [] ints, int id, int remSum) {
		if (dp[id][remSum]==-1) {
			if (remSum==0 || id==ints.length) {
				dp[id][remSum]=0;
			} else if (remSum>=ints[id]) {
				dp[id][remSum]=Math.max(query(ints,id+1,remSum),ints[id]+query(ints,id+1,remSum-ints[id]));
			} else if (remSum<ints[id]) {
				dp[id][remSum]=query(ints,id+1,remSum);
			}
		}
		return dp[id][remSum];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			ArrayList<Integer> list=new ArrayList<>();
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int [] ints=new int [list.size()];
			int sum=0;
			for (int i=0;i<list.size();i++) {
				ints[i]=list.get(i);
				sum+=ints[i];
			}
			
			if (sum%2==0) {
				dp=new int [ints.length+1][sum/2+1];
				for (int [] dpS : dp) {
					Arrays.fill(dpS, -1);
				}
				if (query(ints,0,sum/2)==sum/2) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			} else {
				System.out.println("NO");
			}
		}
	}
}