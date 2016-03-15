import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		System.out.println("Lumberjacks:");
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int lastValue=Integer.parseInt(st.nextToken());
			boolean isAsc=true;
			boolean isDesc=true;
			while (st.hasMoreTokens() && (isAsc || isDesc)) {
				int thisValue=Integer.parseInt(st.nextToken());
				if (thisValue>lastValue) {
					isDesc=false;
				} else if (thisValue<lastValue) {
					isAsc=false;
				}
				lastValue=thisValue;
			}
			if (isDesc || isAsc) {
				System.out.println("Ordered");
			} else {
				System.out.println("Unordered");
			}
		}
	}
}