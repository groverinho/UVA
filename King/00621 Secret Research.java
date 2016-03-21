import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int i=0;i<testCaseCount;i++) {
			String input=br.readLine();
			int inputLength=input.length();
			if (input.equals("1") || input.equals("4") || input.equals("78")) {
				System.out.println("+");
			} else if (input.substring(inputLength-2,inputLength).equals("35") && inputLength>2) {
				System.out.println("-");
			} else if (input.charAt(0)=='9' && input.charAt(inputLength-1)=='4' && inputLength>2) {
				System.out.println("*");
			} else if (input.substring(0, Math.min(3, inputLength)).equals("190") && inputLength>3) {
				System.out.println("?");
			}
		}
	}
}