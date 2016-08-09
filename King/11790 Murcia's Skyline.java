import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int n=Integer.parseInt(br.readLine());
			int [][] tower=new int [n][2];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				tower[i][0]=Integer.parseInt(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				tower[i][1]=Integer.parseInt(st.nextToken());
			}
			
			int [] lis=new int [n];
			for (int i=0;i<lis.length;i++) {
				lis[i]=tower[i][1];
				for (int i2=0;i2<i;i2++) {
					if (tower[i][0]>tower[i2][0]) {
						lis[i]=Math.max(lis[i], tower[i][1]+lis[i2]);
					}
				}
			}
			
			int lisMax=0;
			for (int i : lis) {
				lisMax=Math.max(i, lisMax);
			}
			
			
			int [] lds=new int [n];
			for (int i=0;i<lis.length;i++) {
				lds[i]=tower[i][1];
				for (int i2=0;i2<i;i2++) {
					if (tower[i][0]<tower[i2][0]) {
						lds[i]=Math.max(lds[i], tower[i][1]+lds[i2]);
					}
				}
			}
			
			int ldsMax=0;
			for (int i : lds) {
				ldsMax=Math.max(i, ldsMax);
			}
			
			if (lisMax>=ldsMax) {
				System.out.println("Case "+testCase+". Increasing ("+lisMax+"). Decreasing ("+ldsMax+").");
			} else {
				System.out.println("Case "+testCase+". Decreasing ("+ldsMax+"). Increasing ("+lisMax+").");
			}
		}
	}
}