import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int testCaseCount=Integer.parseInt(br.readLine());
    	for (int testCase=1;testCase<=testCaseCount;testCase++) {
    		double a=0;
    		String s=br.readLine();
    		int index=0;
    		do {
    			char c=s.charAt(index);
    			if (Character.isDigit(c)) {
    				a=a*10+(c-'0');
    			} else {
    				break;
    			}
    			index++;
    		} while (true);
    		
    		double b=0;
    		for (;index<s.length();index++) {
    			char c=s.charAt(index);
    			if (Character.isDigit(c)) {
    				b=b*10+(c-'0');
    			}
    		}
    		
    		a=a*0.5;
    		b=b*0.05;
    		
    		String result=String.valueOf(a+b);
    		if (result.endsWith(".0")) {
    			result=result.substring(0, result.length()-2);
    		}
    		StringBuilder sb=new StringBuilder("Case ");
    		sb.append(testCase);
    		sb.append(": ");
    		sb.append(result);
    		System.out.println(sb.toString());
    	}
    }
	
}