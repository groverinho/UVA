import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			char [] c1=st.nextToken().toCharArray();
			char [] c2=st.nextToken().toCharArray();
			
			//Longest common subsequence DP
			int [][] dp=new int [c1.length][c2.length];
			for (int i=0;i<c1.length;i++) {
				for (int i2=0;i2<c2.length;i2++) {
					if (c1[i]==c2[i2]) {
						if (i>0 && i2>0) {
							dp[i][i2]=1+dp[i-1][i2-1];
						} else {
							dp[i][i2]=1;
						}
					} else {
						if (i>0 && i2>0) {
							dp[i][i2]=Math.max(dp[i][i2-1],dp[i-1][i2]);
						} else if (i2>0) {
							dp[i][i2]=dp[i][i2-1];
						} else if (i>0) {
							dp[i][i2]=dp[i-1][i2];
						} else {
							dp[i][i2]=0;
						}
					}
				}
			}

			if (dp[c1.length-1][c2.length-1]==c1.length) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}
	}    
}