import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=1;
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int limit=Integer.parseInt(st.nextToken());
			
			if (start<0 || limit<0) {
				break;
			}
			
			int count=1;
			long temp=start; //3*temp+1 will go above the limit of int!
			do {
				if (temp%2==0) {
					temp/=2;
				} else {
					temp=3*temp+1;
				}
				count++;
			} while (temp<=limit && temp>1);
			
			if (temp>limit) {
				count--;
			}
			
			System.out.println("Case "+(t++)+": A = "+start+", limit = "+limit+", number of terms = "+count);
		}
	}    
}