import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static boolean isPalindrome (String s) {
		int length=s.length();
		for (int i=0;i<length;i++) {
			if (s.charAt(i)!=s.charAt(length-i-1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			String s=br.readLine();
			StringBuilder sb=new StringBuilder();
			
			for (int i=0;i<s.length();i++) {
				if (Character.isAlphabetic(s.charAt(i))) {
					sb.append(s.charAt(i));
				}
			}
			
			String clean=sb.toString();
			int length=clean.length();
			int K=(int)Math.sqrt(length);
			if (K*K!=length) {
				sb=new StringBuilder("Case #");
				sb.append(testCase);
				sb.append(":\nNo magic :(");
				System.out.println(sb.toString());
				continue;
			}
			
			char [][] c=new char [K][K];
			for (int x=0;x<K;x++) {
				for (int y=0;y<K;y++) {
					c[x][y]=clean.charAt(x*K+y);
				}
			}
			
			//Case 1
			if (!isPalindrome(clean)) {
				sb=new StringBuilder("Case #");
				sb.append(testCase);
				sb.append(":\nNo magic :(");
				System.out.println(sb.toString());
				continue;
			}
			
			//Case 2
			sb=new StringBuilder();
			for (int y=0;y<K;y++) {
				for (int x=0;x<K;x++) {
					sb.append(c[x][y]);
				}
			}
			if (!isPalindrome(sb.toString())) {
				sb=new StringBuilder("Case #");
				sb.append(testCase);
				sb.append(":\nNo magic :(");
				System.out.println(sb.toString());
				continue;
			}
				
			sb=new StringBuilder("Case #");
			sb.append(testCase);
			sb.append(":\n");
			sb.append(K);
			System.out.println(sb.toString());
		}
	}
}