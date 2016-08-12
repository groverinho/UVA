import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static boolean [] notPrime=new boolean [20000000];
	public static int [] primeNumbers=new int [1270607];
	public static int primeNumbersCount=0;
	
	public static void sieveOfEratosthenes () {
		for (int i=2;i*i<notPrime.length;i++)
			if (!notPrime[i])
				for (int i2=i*i;i2<notPrime.length;i2+=i)
					notPrime[i2]=true;
		
		for (int i=2;i<notPrime.length;i++)
			if (!notPrime[i])
				primeNumbers[primeNumbersCount++]=i;
	}
	
	public static void main(String[] args) throws IOException {
		sieveOfEratosthenes();
		
		int [][] pairs=new int [100000][2];
		int pairsCount=0;
		for (int i=0;i<primeNumbersCount-1 && pairsCount<pairs.length;i++) {
			if (primeNumbers[i+1]-primeNumbers[i]==2) {
				pairs[pairsCount][0]=primeNumbers[i];
				pairs[pairsCount][1]=primeNumbers[i+1];
				pairsCount++;
			}
		}
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int pos=Integer.parseInt(s);
			System.out.println("("+pairs[pos-1][0]+", "+pairs[pos-1][1]+")");
		}
	}
}