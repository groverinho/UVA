import java.io.IOException;
import java.util.Scanner;

class Main {
	
	public static void main(String[]args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int testCaseCount=sc.nextInt();
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int N=sc.nextInt();
			
			if (N>0) {
				int [] c=new int [N];
	
				for (int i=0;i<N;i++) {
					c[i]=sc.nextInt();
				}
				
				int sum=0;
				for (int cv : c) {
					sum+=cv;
				}
				
				boolean [] dp=new boolean [(sum+1)/2+1];
				dp[0]=true;
				for (int i=0;i<c.length;i++) {
					boolean [] currDP=new boolean [dp.length];
					for (int i2=0;i2<currDP.length;i2++) {
						if (dp[i2]) {
							currDP[i2]=dp[i2];
							if (c[i]+i2<dp.length) {
								currDP[c[i]+i2]=true;
							}
						}
					}
					dp=currDP;
				}
				
				int max=0;
				for (int i=dp.length-1;i>=0;i--) {
					if (dp[i]) {
						max=i;
						break;
					}
				}

				System.out.println(Math.abs(sum-max-max));
			} else {
				System.out.println(0);
			}
		}
		sc.close();
	}
}