import java.util.Scanner;

class Main {
	
	public static void main (String [] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int testCaseCount=sc.nextInt();
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			long [][][] v=new long [a][b][c];
			for (int i=0;i<a;i++) for (int i2=0;i2<b;i2++) for (int i3=0;i3<c;i3++) v[i][i2][i3]=sc.nextLong();
			
			long [][][] dp=new long [a][b][c];
			for (int i=0;i<a;i++) for (int i2=0;i2<b;i2++) for (int i3=0;i3<c;i3++) {
				dp[i][i2][i3]=v[i][i2][i3];
				if (i>0) dp[i][i2][i3]+=dp[i-1][i2][i3];
				if (i2>0) dp[i][i2][i3]+=dp[i][i2-1][i3];
				if (i3>0) dp[i][i2][i3]+=dp[i][i2][i3-1];
				
				if (i>0 && i2>0) dp[i][i2][i3]-=dp[i-1][i2-1][i3];
				if (i2>0 && i3>0) dp[i][i2][i3]-=dp[i][i2-1][i3-1];
				if (i>0 && i3>0) dp[i][i2][i3]-=dp[i-1][i2][i3-1];
				
				if (i>0 && i2>0 && i3>0) dp[i][i2][i3]+=dp[i-1][i2-1][i3-1];
			}
			
			long max=Long.MIN_VALUE;
			for (int i=0;i<a;i++) for (int i2=0;i2<b;i2++) for (int i3=0;i3<c;i3++) {
				for (int j=i;j<a;j++) for (int j2=i2;j2<b;j2++) for (int j3=i3;j3<c;j3++) {
					long curr=dp[j][j2][j3];
					
					if (i>0) curr-=dp[i-1][j2][j3];
					if (i2>0) curr-=dp[j][i2-1][j3];
					if (i3>0) curr-=dp[j][j2][i3-1];
					
					if (i>0 && i2>0) curr+=dp[i-1][i2-1][j3];
					if (i2>0 && i3>0) curr+=dp[j][i2-1][i3-1];
					if (i>0 && i3>0) curr+=dp[i-1][j2][i3-1];
					
					if (i>0 && i2>0 && i3>0) curr-=dp[i-1][i2-1][i3-1];

					max=Math.max(curr, max);
				}
			}
			
			if (testCase>0) System.out.println();
			System.out.println(max);
		}
	}

}