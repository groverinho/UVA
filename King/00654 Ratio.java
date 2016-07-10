import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int t=0;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int N=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			double v=(double)N/D;
			double lastDiff=Double.MAX_VALUE;
			
			if (t++>0) {
				System.out.println();
			}
			
			for (int d=1;d<=D;d++) {
				double n1=(int)(v*d);
				double n2=n1+1;
				
				double diff1=Math.abs(v-(n1/d));
				double diff2=Math.abs(v-(n2/d));
				double diff=0;
				
				double n=0;
				if (diff1<diff2) {
					n=n1;
					diff=diff1;
				} else {
					n=n2;
					diff=diff2;
				}
				
				if (diff<lastDiff) {
					System.out.println((int)n+"/"+d);
					lastDiff=diff;
				}
			}
		}
	}
}