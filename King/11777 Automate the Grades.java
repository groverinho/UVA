import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int marks=0;
			for (int i=0;i<4;i++) marks+=Integer.parseInt(st.nextToken());
			
			int [] test=new int [3];
			for (int i=0;i<3;i++) test[i]=Integer.parseInt(st.nextToken());
			Arrays.sort(test);
			
			marks=(marks+(test[1]+test[2])/2);
			
			char grade=' ';
			if (marks>=90) grade='A';
			else if (marks>=80) grade='B';
			else if (marks>=70) grade='C';
			else if (marks>=60) grade='D';
			else grade='F';
			
			System.out.println("Case "+testCase+": "+grade);
		}
	}
}