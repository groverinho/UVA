import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int a=Integer.parseInt(br.readLine());
			int b=Integer.parseInt(br.readLine());
			
			if (a%2==0) {
				a++;
			}
			if (b%2==0) {
				b--;
			}
			
			System.out.print("Case "+testCase+": ");
			if (a<b) {
				//Arithmetic Progression.
				int n=(b-a)/2 + 1;
				System.out.println((n*(a+b))/2);
			} else {
				System.out.println(a);
			}
		}
	}    
}