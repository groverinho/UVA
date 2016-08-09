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
			int N=Integer.parseInt(st.nextToken());
			int A=Integer.parseInt(st.nextToken());
			BigInteger [] APow=new BigInteger[N+1];
			APow[0]=BigInteger.ONE;
			APow[1]=BigInteger.valueOf(A);
			for (int i=2;i<=N;i++) {
				APow[i]=APow[i-1].multiply(APow[1]);
			}
			
			BigInteger value=BigInteger.ZERO;
			for (int i=1;i<=N;i++) {
				value=value.add(BigInteger.valueOf(i).multiply(APow[i]));
			}
			System.out.println(value);
		}
	}
}