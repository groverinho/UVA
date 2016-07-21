import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			
			if (n==0) {
				System.out.println(0);
			} else if (k==0) {
				System.out.println(n);
			} else {
				int extra=n;
				while (extra >= k) {
					n=n+extra/k;
					extra=extra/k+extra%k;
				}
				System.out.println(n);
			}
		}
	}    
}