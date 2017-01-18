import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		//Input set contains extended ASCII characters (256), so we need to use ISO-8859-1 to read it.
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int valueCount=Integer.parseInt(br.readLine());
			double [] value=new double [256];
			for (int i=0;i<valueCount;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				value[st.nextToken().charAt(0)]=Integer.parseInt(st.nextToken())/100.0;
			}
			
			int lineCount=Integer.parseInt(br.readLine());
			double money=0.0;
			for (int i=0;i<lineCount;i++) for (char c : br.readLine().toCharArray()) money+=value[c];
			
			System.out.printf("%.2f$\n",money);
		}
	}
}