import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		int sum=0;
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String op=st.nextToken();
			if (op.equals("donate")) {
				sum+=Integer.parseInt(st.nextToken());
			} else if (op.equals("report")) {
				System.out.println(sum);
			}
		}
	}
}