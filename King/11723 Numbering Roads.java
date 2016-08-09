import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int t=1;
		while (!(s=br.readLine()).equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int R=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			if (R/N>26) {
				System.out.println("Case "+t+++": impossible");
			} else if (R%N==0){
				System.out.println("Case "+t+++": "+((R/N)-1));
			} else {
				System.out.println("Case "+t+++": "+(R/N));
			}
		}
	}
}