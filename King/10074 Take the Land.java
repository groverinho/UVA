import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			if (M==0 && N==0) {
				break;
			}
			int [][] matrix=new int [M][N];
			
			for (int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				for (int i2=0;i2<N;i2++) {
					int v=Integer.parseInt(st.nextToken());
					if (v==0) {
						matrix[i][i2]=1;
					} else {
						matrix[i][i2]=-123456; //any impossible number.
					}
				}
			}

			//culmulative sum.
			for (int i=0;i<M;i++) {
				for (int i2=0;i2<N;i2++) {
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
			
			int max=0;
			for (int i=0;i<M;i++) {
				for (int i2=0;i2<N;i2++) {
					for (int x=i;x<M;x++) {
						for (int y=i2;y<N;y++) {
							int sum=matrix[x][y];
							if (i>0) {
								sum-=matrix[i-1][y];
							}
							if (i2>0) {
								sum-=matrix[x][i2-1];
							}
							if (i>0 && i2>0) {
								sum+=matrix[i-1][i2-1];
							}
							max=Math.max(max, sum);
						}
					}

				}
			}
			
			System.out.println(max);
		}
	}
}