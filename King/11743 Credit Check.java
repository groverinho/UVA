import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static int digitSum (int n) {
		int count=0;
		while (n>0) {
			count+=n%10;
			n/=10;
		}
		return count;
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());

		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int total=0;
			while (st.hasMoreTokens()) {
				char [] c=st.nextToken().toCharArray();
				total=total+(digitSum((c[0]-'0')*2)+digitSum((c[2]-'0')*2))+(digitSum(c[1]-'0')+digitSum(c[3]-'0'));
			}
			
			if ((total)%10==0) System.out.println("Valid");
			else System.out.println("Invalid");
		}
	}
}