import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	/*	        +2   +4   +6   +8
	   Sequence : 2 -> 4 -> 8 -> 14 -> 22 -> ....
	          n :  1    2   3    4     5
	   
	   Summation 2(x-1) = x^2 - x
	   x = n-1
	   
	   Hence = (n-1)^2 - (n-1) + 2(first term)
	   
	   */
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			BigInteger n=new BigInteger(s);
			if (!n.equals(BigInteger.ZERO)) {
				BigInteger nMinusOne=n.subtract(BigInteger.ONE);
				System.out.println(nMinusOne.pow(2).add(nMinusOne).add(BigInteger.valueOf(2)));
			} else {
				System.out.println(1);
			}
		}
	}
}