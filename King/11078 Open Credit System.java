import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int n=Integer.parseInt(br.readLine());
			int [] ints=new int [n];
			for (int i=0;i<n;i++) {
				ints[i]=Integer.parseInt(br.readLine());
			}
			
			int maxInts=ints[0];
			int ans=Integer.MIN_VALUE;
			for (int i=1;i<ints.length;i++) {
				ans=Math.max(ans, maxInts-ints[i]);
				maxInts=Math.max(maxInts,ints[i]);
			}
			
			System.out.println(ans);
		}

	}
}