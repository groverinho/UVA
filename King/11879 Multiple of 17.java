import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		BigInteger bi17=new BigInteger("17");
		while (!(s=br.readLine()).equals("0")) {
			BigInteger bi=new BigInteger(s);
			if (bi.mod(bi17).equals(BigInteger.ZERO))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}