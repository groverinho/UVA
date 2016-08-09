import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args) throws IOException {
		BigInteger [] fac=new BigInteger [367];
		fac[0]=BigInteger.ONE;
		for (int i=1;i<fac.length;i++) {
			fac[i]=fac[i-1].multiply(BigInteger.valueOf(i));
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int n=Integer.parseInt(s);
			StringBuilder sb=new StringBuilder();
			sb.append(n);
			sb.append("! --\n");
			int [] cnt=new int [10];
			BigInteger bi=new BigInteger(fac[n].toString());
			while (bi.compareTo(BigInteger.ZERO)>0) {
				cnt[bi.mod(BigInteger.TEN).intValue()]++;
				bi=bi.divide(BigInteger.TEN);
			}
			String blank="     ";
			for (int i=0;i<5;i++) {
				if (i==0) {
					sb.append("   (");
				} else {
					sb.append("    (");
				}
				sb.append(i);
				sb.append(")");
				if (cnt[i]==0) {
					sb.append("    0");
				} else {
					sb.append(blank.substring(0,4-(int)Math.log10(cnt[i])));
					sb.append(cnt[i]);
				}
			}
			sb.append('\n');
			for (int i=5;i<10;i++) {
				if (i==5) {
					sb.append("   (");
				} else {
					sb.append("    (");
				}
				sb.append(i);
				sb.append(")");
				if (cnt[i]==0) {
					sb.append("    0");
				} else {
					sb.append(blank.substring(0,4-(int)Math.log10(cnt[i])));
					sb.append(cnt[i]);
				}
			}
			System.out.println(sb.toString());
		}
	}
}