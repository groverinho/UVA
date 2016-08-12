import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int sum=0;
			for (int i=0;i<s.length();i++) {
				sum+=(s.charAt(i)-'0');
			}
			int loopCount=1;
			while (sum>9) {
				loopCount++;
				int temp=0;
				while (sum>0) {
					temp+=sum%10;
					sum/=10;
				}
				sum=temp;
			}
			if (sum%9==0) {
				System.out.println(s+" is a multiple of 9 and has 9-degree "+loopCount+".");
			} else {
				System.out.println(s+" is not a multiple of 9.");
			}
		}
	}
}