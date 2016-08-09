import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			ArrayList<Integer> list=new ArrayList<>();
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			BigInteger [] ints=new BigInteger [list.size()-1];
			for (int i=0;i<ints.length;i++) {
				ints[i]=BigInteger.valueOf(list.get(i));
			}
			
			BigInteger max;
			if (ints.length>1) {
				max=BigInteger.valueOf(-999999999L);
				BigInteger value;
				for (int i=0;i<ints.length;i++) {
					value=BigInteger.ONE;
					for (int i2=i;i2<ints.length;i2++) {
						value=value.multiply(ints[i2]);
						if (value.compareTo(max)>0) {
							max=value;
						}
					}
				}
			} else {
				max=ints[0];
			}
			System.out.println(max);
		}
	}
}