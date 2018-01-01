import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			char [] ca=br.readLine().toLowerCase().toCharArray();
			int [] freq=new int [128];
			for (char c : ca) if (Character.isAlphabetic(c)) freq[c]++;
			
			int max=Arrays.stream(freq).max().getAsInt();
			StringBuilder sb=new StringBuilder();
			for (int i='a';i<='z';i++) if (freq[i]==max) sb.append((char)i);
			
			System.out.println(sb.toString());
		}
	}

}
