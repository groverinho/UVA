import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			BigInteger bi=new BigInteger(br.readLine());
			if (bi.compareTo(BigInteger.ZERO)<0) {
				break;
			}
			StringBuilder sb=new StringBuilder();
			if (bi.isProbablePrime(10)) {
				sb.append("    ");
				sb.append(bi);
				sb.append("\n");
			} else if (!bi.equals(BigInteger.ZERO)){
				BigInteger biTwo=BigInteger.valueOf(2);
				while (bi.mod(biTwo).equals(BigInteger.ZERO)) {
					bi=bi.divide(biTwo);
					sb.append("    ");
					sb.append(2);
					sb.append("\n");
				}
				for (BigInteger i=BigInteger.valueOf(3);i.multiply(i).compareTo(bi)<0;i=i.add(biTwo)) {
					while (bi.mod(i).equals(BigInteger.ZERO)) {
						bi=bi.divide(i);
						sb.append("    ");
						sb.append(i);
						sb.append("\n");
					}
				}
				if (bi.compareTo(BigInteger.ONE)>0) {
					sb.append("    ");
					sb.append(bi);
					sb.append("\n");
				}
			} else {
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}
}