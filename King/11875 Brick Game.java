import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int [] N=new int [Integer.parseInt(st.nextToken())];
			for (int i=0;i<N.length;i++) {
				N[i]=Integer.parseInt(st.nextToken());
			}
			System.out.println("Case "+testCase+": "+N[N.length/2]);
		}
	}
}