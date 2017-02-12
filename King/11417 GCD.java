import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {                                                                                                                             

	public static int gcd (int a, int b) {
		return b==0 ? a : gcd(b,a%b);
	}
	
	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int N=Integer.parseInt(s);
			int G=0;
			for (int i=1;i<N;i++) {
				for (int i2=i+1;i2<=N;i2++) {
					G+=gcd(i2,i);
				}
			}
			System.out.println(G);
		}
	}
}