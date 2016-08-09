import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

class Main {
	
	public static HashSet<Integer> notPrime=new HashSet<>();
	public static ArrayList<Integer> prime=new ArrayList<>();
	
	public static void sieveOfEratosthenes() {
		for (long i=2;i*i<=Integer.MAX_VALUE;i++) {
			if (!notPrime.contains(i)) {
				prime.add((int)i);
				for (long i2=i*i;i2*i2<=Integer.MAX_VALUE;i2+=i) {
					notPrime.add((int)i2);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		sieveOfEratosthenes();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int n=(int)Long.parseLong(s);
			boolean noX=true;
			StringBuilder sb=new StringBuilder();
			sb.append(n);
			sb.append(" =");
			if (n<0) {
				sb.append(" -1");
				noX=false;
				n*=-1;
			}
			
			for (int i=0;i<prime.size() && prime.get(i)<=n;i++) {
				while (n%prime.get(i)==0) {
					if (!noX) {
						sb.append(" x");
					} else {
						noX=false;
					}
					sb.append(" ");
					sb.append(prime.get(i));
					n/=prime.get(i);
				}
			}

			if (n>1) {
				if (!noX) {
					sb.append(" x");
				}
				sb.append(" ");
				sb.append(n);
			} else if (n<0) {
				if (!noX) {
					sb.append(" x ");
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}