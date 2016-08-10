import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			BigInteger bi=new BigInteger(st.nextToken());
			char op=st.nextToken().charAt(0);
			BigInteger bi2=new BigInteger(st.nextToken());
			
			if (op=='/') {
				System.out.println(bi.divide(bi2));
			} else if (op=='%') {
				System.out.println(bi.mod(bi2));
			}
		}
	}
}