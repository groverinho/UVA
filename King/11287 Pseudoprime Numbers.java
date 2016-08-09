import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			BigInteger p=new BigInteger(st.nextToken());
			BigInteger a=new BigInteger(st.nextToken());
			if (!p.isProbablePrime(10) && a.modPow(p, p).equals(a)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}