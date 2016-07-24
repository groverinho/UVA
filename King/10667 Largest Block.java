import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int n=Integer.parseInt(br.readLine());
			int [][] matrix=new int [n][n];
			for (int [] mat : matrix) {
				Arrays.fill(mat, 1);
			}
			
			int blockN=Integer.parseInt(br.readLine());
			for (int i=0;i<blockN;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int xMin=Integer.parseInt(st.nextToken());
				int yMin=Integer.parseInt(st.nextToken());
				int xMax=Integer.parseInt(st.nextToken());
				int yMax=Integer.parseInt(st.nextToken());
				
				for (int j=xMin;j<=xMax;j++) {
					for (int k=yMin;k<=yMax;k++) {
						matrix[j-1][k-1]=-123456; // any number smaller than -n*n, and larger than (Min Integer)/(n^n)
					}
				}
			}
			
			//culmulative sum.
			for (int i=0;i<n;i++) {
				for (int i2=0;i2<n;i2++) {
					if (i>0) {
						matrix[i][i2]+=matrix[i-1][i2];
					}
					if (i2>0) {
						matrix[i][i2]+=matrix[i][i2-1];
					}
					if (i>0 && i2>0) {
						matrix[i][i2]-=matrix[i-1][i2-1];
					}
				}
			}
			
			// permute submatrix and get max.
			int max=0;
			for (int i=0;i<n;i++) {
				for (int i2=0;i2<n;i2++) {
					for (int k=i;k<n;k++) {
						for (int l=i2;l<n;l++) {
							int sum=matrix[k][l];
							if (i>0) {
								sum-=matrix[i-1][l];
							}
							if (i2>0) {
								sum-=matrix[k][i2-1];
							}
							if (i>0 && i2>0) {
								sum+=matrix[i-1][i2-1];
							}
							max=Math.max(sum, max);
						}
					}
				}
			}
			
			System.out.println(max);
		}
	}
}