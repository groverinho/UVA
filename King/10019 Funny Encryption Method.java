import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static int calcOnes (String s) {
		int count=0;
		for (char c : s.toCharArray()) if (c=='1') count++;
		return count;
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			String value=br.readLine();
			String x1=Integer.toBinaryString(Integer.parseInt(value));
			String x2=Integer.toBinaryString(Integer.parseUnsignedInt(value,16));
			
			System.out.println(calcOnes(x1)+" "+calcOnes(x2));
		}
	}
}