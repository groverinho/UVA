import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int N=Integer.parseInt(s);
			int [] n=new int [N];
			for (int i=0;i<N;i++) n[i]=Integer.parseInt(br.readLine());
			
			int total=0;
			int noCommonFactor=0;
			for (int i=0;i<N;i++) for (int i2=i+1;i2<N;i2++) {
				total++;
				if (gcd(n[i],n[i2])==1) noCommonFactor++;
			}
			
			if (noCommonFactor==0) System.out.println("No estimate for this data set.");
			else {
				System.out.printf("%.6f\n",Math.sqrt(6/(noCommonFactor/(double)total)));
			}
		}
	}
	
}