import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine();
			int gapCount=Integer.parseInt(br.readLine());
			int [][] gaps=new int [gapCount][2];
			for (int i=0;i<gaps.length;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				gaps[i][0]=Integer.parseInt(st.nextToken());
				gaps[i][1]=Integer.parseInt(st.nextToken());
			}
				
			int referGap=Math.abs(gaps[0][0]-gaps[0][1]);
			boolean hasDiffGap=false;
			for (int i=1;i<gaps.length && !hasDiffGap;i++) {
				hasDiffGap = Math.abs(gaps[i][0]-gaps[i][1])!=referGap;
			}
			
			if (testCase>0) {
				System.out.println();
			}
			if (!hasDiffGap) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}