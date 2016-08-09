import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static boolean [] notPrime=new boolean [10001];
	public static int [] primeNumbers=new int [5000];
	public static int primeNumbersCount=0;
	
	public static void sieveOfEratosthenes() {
		notPrime[0]=true; notPrime[1]=true;
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
		//1D Range Sum.
		int [] dp=new int [primeNumbersCount+1];
		for (int i=0;i<primeNumbersCount;i++) {
			dp[i+1]=primeNumbers[i]+dp[i];
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int N=Integer.parseInt(s);
			int ways=0;
			for (int i=0;i<=primeNumbersCount && primeNumbers[i]<=N;i++) {
				for (int i2=i+1;i2<=primeNumbersCount && dp[i2]-dp[i]<=N;i2++) {
					if (dp[i2]-dp[i]==N) {
						ways++;
					}
				}
			}
			System.out.println(ways);
		}
	}
}