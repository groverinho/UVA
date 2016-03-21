import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int max=-Integer.MAX_VALUE;
			while (st.hasMoreTokens()) {
				max=Math.max(max, Integer.parseInt(st.nextToken()));
			}
			System.out.println("Case "+testCase+": "+max);
		}
	}
}