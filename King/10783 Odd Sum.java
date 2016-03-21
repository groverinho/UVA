import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int min=Integer.parseInt(br.readLine());
			int max=Integer.parseInt(br.readLine());
			int count=0;
			if (min%2==0) {
				min++;
			}
			if (max%2==0) {
				max--;
			}
			int termsCount=((max-min)/2)+1;
			//n/2 (2a+(n-1)d)
			count=(termsCount*(2*min+(termsCount-1)*2))/2;
			System.out.println("Case "+testCase+": "+count);
		}
	}
}