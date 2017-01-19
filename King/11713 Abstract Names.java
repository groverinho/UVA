import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static String truncate (String s) {
		StringBuilder sb=new StringBuilder();
		for (char c : s.toCharArray()) if (c!='a' && c!='e' && c!='i' && c!='o' && c!='u') sb.append(c);
		
		return sb.toString();
	}
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			if (truncate(br.readLine()).equals(truncate(br.readLine()))) System.out.println("Yes");
			else System.out.println("No");
		}
	}
}