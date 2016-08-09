import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static boolean [] notPrime=new boolean [1000000];
	
	public static void sieveOfEratosthenes() {
		notPrime[0]=true; notPrime[1]=true;
		for (int i=2;i*i<notPrime.length;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<notPrime.length;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
	}
	
	public static int reverse (int i) {
		int n=0;
		while (i>0) {
			n=n*10+i%10;
			i/=10;
		}
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		sieveOfEratosthenes();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			int nr=reverse(n);
			if (notPrime[n]) {
				System.out.println(n+" is not prime.");
			} else if (!notPrime[n] && notPrime[nr] || (n==nr && !notPrime[n])) {
														//For palindrome number.
				System.out.println(n+" is prime.");
			} else {
				System.out.println(n+" is emirp.");
			}
		}
	}
}