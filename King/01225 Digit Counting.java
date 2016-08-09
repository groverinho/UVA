import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int [] count=new int [10];
			
			for (BigInteger bi=new BigInteger(br.readLine());bi.compareTo(BigInteger.ZERO)>0;bi=bi.subtract(BigInteger.ONE)) {
				BigInteger temp=bi.add(BigInteger.ZERO);
				while (temp.compareTo(BigInteger.ZERO)>0) {
					count[temp.mod(BigInteger.TEN).intValue()]++;
					temp=temp.divide(BigInteger.TEN);
				}
			}
			
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<count.length;i++) {
				sb.append(count[i]);
				if (i<count.length-1) {
					sb.append(" ");
				}
			}
			System.out.println(sb.toString());
		}
	}
}