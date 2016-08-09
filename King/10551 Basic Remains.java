import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			StringTokenizer st=new StringTokenizer(s);
			int base=Integer.parseInt(st.nextToken());
			
			System.out.println(new BigInteger(st.nextToken(),base).mod(new BigInteger(st.nextToken(),base)).toString(base));
		}
	}
}