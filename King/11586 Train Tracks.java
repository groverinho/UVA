import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			String s=br.readLine();
			int mcount=0;
			int fcount=0;
			for (int i=0;i<s.length();i++) {
				if (s.charAt(i)=='M') {
					mcount++;
				} else if (s.charAt(i) == 'F') {
					fcount++;
				}
			}
			if (mcount==fcount && mcount>1) {
				System.out.println("LOOP");
			} else {
				System.out.println("NO LOOP");
			}
		}
	}
}