import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int t=1;
		while (!(s=br.readLine()).equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int N=Integer.parseInt(st.nextToken());
			int F=Integer.parseInt(st.nextToken());
			BigInteger total=BigInteger.ZERO;
			for (int i=0;i<N;i++) {
				total=total.add(new BigInteger(br.readLine()));
			}
			StringBuilder sb=new StringBuilder();
			sb.append("Bill #");
			sb.append(t++);
			sb.append(" costs ");
			sb.append(total);
			sb.append(": each friend should pay ");
			sb.append(total.divide(BigInteger.valueOf(F)));
			sb.append("\n");
			System.out.println(sb.toString());
		}
	}
}