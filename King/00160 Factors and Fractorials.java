import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static int [] primeNumbers=new int [50];
	public static int primeNumbersCount=0;
	
	public static void sieveOfEratosthenes () {
		boolean [] notPrime=new boolean [101];
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
	
	public static void main(String[]args) throws IOException {
		sieveOfEratosthenes();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num;
		while ((num=Integer.parseInt(br.readLine()))!=0) {
			int temp=1;
			int [] count=new int [primeNumbersCount];
			int maxPrimeIndex=0;
			//We can put DP!
			for (int i=2;i<=num;i++) {
				temp*=i;
				
				for (int i2=0;i2<primeNumbersCount && temp>=primeNumbers[i2];i2++) {
					while (temp%primeNumbers[i2]==0) {
						temp/=primeNumbers[i2];
						count[i2]++;
						maxPrimeIndex=Math.max(maxPrimeIndex, i2);
					}
				}
			}
			
			String numStr=String.valueOf(num);
			String blank="           ";
			StringBuilder sb=new StringBuilder();
			String header=blank.substring(0,3-numStr.length())+num+"! =";
			sb.append(header);
			
			int dispCount=0;
			for (int i=0;i<=maxPrimeIndex;i++) {
				String v=String.valueOf(count[i]);
				dispCount++;
				if (dispCount==16) {
					sb.append("\n"+blank.substring(0,header.length()));
				}
				sb.append(blank.substring(0,3-v.length()));
				sb.append(v);
			}
			
			System.out.println(sb.toString());
		}
	}
}