import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++){
			StringTokenizer st=new StringTokenizer(br.readLine());
			BigInteger x=new BigInteger(st.nextToken());
			System.out.println(x.modPow(new BigInteger(st.nextToken()),new BigInteger(st.nextToken())));
		}
	}
}