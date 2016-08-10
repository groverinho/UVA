import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine();//empty
			int M=Integer.parseInt(br.readLine());
			
			int [][] N=new int [M+1][3];
			for (int i=1;i<=M;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				N[i][0]=Integer.parseInt(st.nextToken());
				N[i][1]=Integer.parseInt(st.nextToken());
			}
			
			for (int i=M;i>=1;i--) {
				N[i][2]+=N[i][0]+N[i][1];
				N[i-1][2]=N[i][2]/10;
				N[i][2]%=10;
			}
			
			if (testCase>0) {
				System.out.println();
			}
			
			StringBuilder sb=new StringBuilder();
			if (N[0][2]!=0) { //Don't add leading zero.
				sb.append(N[0][2]); 
			}
			for (int i=1;i<=M;i++) {
				sb.append(N[i][2]);
			}
			System.out.println(sb.toString());
		}
	}
}