import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int N=Integer.parseInt(br.readLine());
			String s=br.readLine();
			int start=0;
			int count=0;
			
			for (int i=0;i<N;i++) {
				if (i-start==1) {
					start=i+2;
					i++;
					count++;
				} else {
					if (s.charAt(i)=='#') {
						start=i+1;
					}
				}
			}
			
			if (start==N-1) {
				count++;
			}
			System.out.println("Case "+testCase+": "+count);
		}
	}
}