import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int testCaseCount=Integer.parseInt(br.readLine());
    	for (int testCase=1;testCase<=testCaseCount;testCase++) {
    		double amount=0.0;
    		for (int i=0;i<12;i++) {
    			amount+=Double.parseDouble(br.readLine());
    		}
    		amount/=12;
    		StringBuilder sb=new StringBuilder();
    		sb.append(testCase);
    		sb.append(' ');
    		sb.append("$");
    		sb.append(String.format("%,.2f",amount));
    		System.out.println(sb.toString());
    	}
    }
	
}