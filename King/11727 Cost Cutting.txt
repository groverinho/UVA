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
			int [] salaries=new int [3];
			int minSalary=Integer.MAX_VALUE;
			int maxSalary=-Integer.MAX_VALUE;
			
			for (int i=0;i<salaries.length;i++) {
				salaries[i]=Integer.parseInt(st.nextToken());
				minSalary=Math.min(minSalary, salaries[i]);
				maxSalary=Math.max(maxSalary, salaries[i]);
			}
			
			for (int i=0;i<salaries.length;i++) {
				if (salaries[i]>minSalary && salaries[i]<maxSalary) {
					System.out.println("Case "+testCase+": "+salaries[i]);
					break;
				}
			}
		}
	}
}