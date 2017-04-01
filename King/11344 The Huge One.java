import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			BigInteger n=new BigInteger(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			BigInteger [] d=new BigInteger [Integer.parseInt(st.nextToken())];
			for (int i=0;i<d.length;i++) d[i]=new BigInteger(st.nextToken());
			
			boolean divisible=true;
			for (int i=0;i<d.length && divisible;i++) divisible &= (n.mod(d[i]).equals(BigInteger.ZERO));
			
			if (divisible) System.out.println(n.toString()+" - Wonderful.");
			else System.out.println(n.toString()+" - Simple.");
		}
	}
	
}