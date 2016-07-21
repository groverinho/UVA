import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			char [] c1=s.toCharArray();
			char [] c2=br.readLine().toCharArray();
			
			int [][] dp=new int [c1.length][c2.length];
			
			int count=0;
			for (int i=0;i<c1.length;i++) {
				for (int i2=0;i2<c2.length;i2++) {
					if (c1[i]==c2[i2]) {
						if (i>0 && i2>0) {
							dp[i][i2]=1+dp[i-1][i2-1];
						} else {
							dp[i][i2]=1;
						}
						count=Math.max(count, dp[i][i2]);
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
			
			System.out.println(dp[c1.length-1][c2.length-1]);
		}
	}    
}