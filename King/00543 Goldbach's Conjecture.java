import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static boolean [] notPrime=new boolean [1000001];
	public static int [] primeNumbers=new int [500000];
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
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sieveOfEratosthenes();
		while (true) {
			int N=Integer.parseInt(br.readLine());
			if (N==0) {
				break;
			}
			
			boolean flag=false;
			for (int i=0;primeNumbers[i]<=N/2;i++) {
				if (!notPrime[N-primeNumbers[i]]) {
					System.out.println(N+" = "+primeNumbers[i]+" + "+(N-primeNumbers[i]));
					flag=true;
					break;
				}
			}
			
			if (!flag) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}  
}