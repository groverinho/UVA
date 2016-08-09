import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static boolean [] notPrime=new boolean [52*20+1];
	
	public static void sieveOfEratosthenes() {
		notPrime[0]=true;
		//is 1 a prime number? really? :/
		
		for (int i=2;i*i<notPrime.length;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<notPrime.length;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		int [] value=new int [128];
		for (int i='a';i<='z';i++) {
			value[i]=i-'a'+1;
		}
		
		for (int i='A';i<='Z';i++) {
			value[i]=i-'A'+27;
		}
		
		sieveOfEratosthenes();
		while ((s=br.readLine())!=null) {
			int v=0;
			for (int i=0;i<s.length();i++) {
				v+=value[s.charAt(i)];
			}
			
			if (!notPrime[v]) {
				System.out.println("It is a prime word.");
			} else {
				System.out.println("It is not a prime word.");
			}
		}
	}    
}