import java.io.IOException;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args)  throws IOException {
		Scanner sc=new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n=sc.nextInt();
			int [] ints=new int [n];
			for (int i=0;i<n;i++) {
				ints[i]=sc.nextInt();
			}
			
			int [][] dp=new int [n][2];
			int dpCount=0;
			
			int [] lis=new int [n];
			lis[0]=1;
			
			dp[0][0]=ints[0];
			dp[0][1]=0;
			dpCount=1;
			
			for (int i=1;i<lis.length;i++) {
				if (ints[i]>dp[dpCount-1][0]) {
					lis[i]=dpCount+1;
					dp[dpCount][0]=ints[i];
					dp[dpCount][1]=i;
					dpCount++;
				} else if (ints[i]<dp[dpCount-1][0]) {
					int min=0;
					int max=dpCount-1;
					int mid=0;
					while (min<=max) {
						mid=(min+max)/2;
						if (dp[mid][0]==ints[i]) {
							break;
						} else if (dp[mid][0]>ints[i]) {
							max=mid-1;
						} else {
							min=mid+1;
						}
					}
					if (dp[mid][0]<ints[i]) {
						mid++;
					}
					
					lis[i]=lis[dp[mid][1]];
					dp[mid][0]=ints[i];
					dp[mid][1]=i;

				} else {
					lis[i]=lis[dp[dpCount-1][1]];
				}
			}
			
			int [] lis2=new int [n];
			lis2[n-1]=1;
			
			dp=new int [n][2];
			dp[0][0]=ints[n-1];
			dp[0][1]=n-1;
			dpCount=1;
			
			for (int i=n-2;i>=0;i--) {
				if (ints[i]>dp[dpCount-1][0]) {
					lis2[i]=dpCount+1;
					dp[dpCount][0]=ints[i];
					dp[dpCount][1]=i;
					dpCount++;
				} else if (ints[i]<dp[dpCount-1][0]) {
					int min=0;
					int max=dpCount-1;
					int mid=0;
					while (min<=max) {
						mid=(min+max)/2;
						if (dp[mid][0]==ints[i]) {
							break;
						} else if (dp[mid][0]>ints[i]) {
							max=mid-1;
						} else {
							min=mid+1;
						}
					}
					
					if (dp[mid][0]<ints[i]) {
						mid++;
					}
					
					lis2[i]=lis2[dp[mid][1]];
					dp[mid][0]=ints[i];
					dp[mid][1]=i;
				} else {
					lis2[i]=lis2[dp[dpCount-1][1]];
				}
			}
			
			int max=0;
			for (int i=0;i<lis.length;i++) {
				max=Math.max(max, Math.min(lis[i],lis2[i])*2-1);
			}
			
			System.out.println(max);
		}
		sc.close();
	}
}