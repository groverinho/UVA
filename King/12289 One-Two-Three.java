import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		String [] words = {"one","two","three"};
		int [] num={1,2,3};
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			String input=br.readLine();
			if (input.length()==5) {
				System.out.println(num[2]);
			} else if (input.length()==3) {
				for (int i=0;i<2;i++) {
					int matchCount=0;
					for (int i2=0;i2<words[i].length();i2++) {
						if (words[i].charAt(i2)==input.charAt(i2)) {
							matchCount++;
						}
					}
					if (matchCount>=words[i].length()-1) {
						System.out.println(num[i]);
						break;
					}
				}
			}
		}
	}
}