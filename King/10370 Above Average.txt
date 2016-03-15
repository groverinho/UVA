import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int [] marks=new int [Integer.parseInt(st.nextToken())];
			double avg=0.0;
			
			for (int i=0;i<marks.length;i++) {
				marks[i]=Integer.parseInt(st.nextToken());
				avg+=marks[i];
			}
			
			avg/=marks.length;
			
			double aboveAvgCount=0.0;
			for (int i=0;i<marks.length;i++) {
				if (marks[i]>avg) {
					aboveAvgCount++;
				}
			}
			
			double percentage=(aboveAvgCount*100)/(double)marks.length;
			System.out.printf("%.3f%%\n",percentage);
		}
	}
}