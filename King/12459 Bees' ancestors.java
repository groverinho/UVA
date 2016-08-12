import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

	//fibonacci
	public static BigInteger [] fib=new BigInteger[81];
	
	public static void main(String[] args) throws IOException {
		fib[0]=BigInteger.ONE;
		fib[1]=BigInteger.ONE;
		for (int i=2;i<fib.length;i++) {
			fib[i]=fib[i-1].add(fib[i-2]);
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			System.out.println(fib[Integer.parseInt(s)]);
		}
	}
}