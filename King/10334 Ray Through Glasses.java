import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BigInteger [] fib=new BigInteger[1002];
		fib[0]=BigInteger.ONE;
		fib[1]=BigInteger.ONE;
		for (int i=2;i<fib.length;i++) {
			fib[i]=fib[i-1].add(fib[i-2]);
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			System.out.println(fib[Integer.parseInt(new StringTokenizer(s).nextToken())+1]);
		}
	}
}