import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			boolean good=true;
			while (st.hasMoreTokens() && good) {
				good=(Integer.parseInt(st.nextToken())<=20);
			}
			if (good) {
				System.out.println("Case "+testCase+": good");
			} else {
				System.out.println("Case "+testCase+": bad");
			}
		}
	}
}