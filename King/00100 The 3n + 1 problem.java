import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static int [] cache=new int [3000000];
	
	public static int length (int n) {
		if (n<cache.length) {
			if (cache[n]==0) {
				if (n%2==0) {
					cache[n]=1+length(n/2);
				} else {
					cache[n]=1+length(3*n+1);
				}
			}
			return cache[n];
		} else {
			if (n%2==0) {
				return 1+length(n/2);
			} else {
				return 1+length(3*n+1);
			}
		}
	}
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		cache[1]=1;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int in1=Integer.parseInt(st.nextToken());
			int in2=Integer.parseInt(st.nextToken());
			int min=Math.min(in1, in2);
			int max=Math.max(in1, in2);
			
			int maxCycle=0;
			for (int i=min;i<=max;i++) {
				maxCycle=Math.max(length(i), maxCycle);
			}
			
			System.out.println(in1+" "+in2+" "+maxCycle);
		}
	}
}