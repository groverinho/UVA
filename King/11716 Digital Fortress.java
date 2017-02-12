import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			String s=br.readLine();
			int sqrt=(int)Math.sqrt(s.length());
			if (sqrt*sqrt==s.length()) {
				StringBuilder sb=new StringBuilder();
				for (int i=0;i<sqrt;i++) for (int i2=0;i2<sqrt;i2++) sb.append(s.charAt(i2*sqrt+i));
				
				System.out.println(sb.toString());
			} else {
				System.out.println("INVALID");
			}
		}
	}
}