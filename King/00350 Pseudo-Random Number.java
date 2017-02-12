import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=1;
		String s;
		while (!(s=br.readLine()).equals("0 0 0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int Z=Integer.parseInt(st.nextToken());
			int I=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int L=Integer.parseInt(st.nextToken());
			
			int count=0;
			int firstNum=(Z*L+I)%M;
			L=firstNum;
			do {
				L=(Z*L+I)%M;
				count++;
			} while (L!=firstNum);
			
			System.out.println("Case "+testCase+++": "+count);
		}
	}
	
}