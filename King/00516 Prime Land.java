import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static boolean [] notPrime=new boolean [32768];
	public static int [] primeNumbers=new int [16000];
	public static int primeNumbersCount=0;
	
	public static void sieveOfEratosthenes() {
		for (int i=2;i*i<notPrime.length;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<notPrime.length;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		
		for (int i=2;i<notPrime.length;i++) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		sieveOfEratosthenes();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			// Input a1 b1 a2 b2 ... an bn...
			// = a1^b1 * a2^b2 * ... * an^bn.
			StringTokenizer st=new StringTokenizer(s);
			int x=1;
			while (st.hasMoreTokens()) {
				int base=Integer.parseInt(st.nextToken());
				int pow=Integer.parseInt(st.nextToken());
				int r=1;
				for (int i=0;i<pow;i++) {
					r*=base;
				}
				x*=r;
			}
			x--;
			int [] pf=new int [100];
			int [] pfPow=new int [100];
			int pfCount=0;
			for (int i=0;i<primeNumbersCount && primeNumbers[i]*primeNumbers[i]<=x;i++) {
				if (x%primeNumbers[i]==0) {
					pf[pfCount]=primeNumbers[i];
					while (x%primeNumbers[i]==0) {
						pfPow[pfCount]++;
						x/=primeNumbers[i];
					}
					pfCount++;
				}
			}
			if (x>1) {
				pf[pfCount]=x;
				pfPow[pfCount]=1;
				pfCount++;
			}
			StringBuilder sb=new StringBuilder();
			for (int i=pfCount-1;i>=0;i--) {
				sb.append(pf[i]);
				sb.append(" ");
				sb.append(pfPow[i]);
				if (i>0) {
					sb.append(" ");
				}
			}
			System.out.println(sb.toString());
		}
	}
}