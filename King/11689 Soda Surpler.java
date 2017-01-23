import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int soda=Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
			int sodaNeeded=Integer.parseInt(st.nextToken());
			int count=0;
			while (soda>=sodaNeeded) {
				count+=soda/sodaNeeded;
				soda=soda/sodaNeeded+soda%sodaNeeded;
			}
			System.out.println(count);
		}
	}
}