import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			double d=Double.parseDouble(st.nextToken());
			double v=Double.parseDouble(st.nextToken());
			double u=Double.parseDouble(st.nextToken());
			
			if (v==0 || u==0 || u<=v) {
				System.out.println("Case "+testCase+": can't determine");
			} else {
				double uv=Math.sqrt((u*u)-(v*v));
				double p1=d/u;
				double p2=d/uv;
				System.out.printf("Case %d: %.3f\n",testCase,Math.abs(p1-p2));
			}
		}
	}
}