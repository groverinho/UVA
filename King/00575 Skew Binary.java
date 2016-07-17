import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int [] powTwo=new int [32];
		powTwo[0]=1;
		for (int i=1;i<powTwo.length;i++) {
			powTwo[i]=2*powTwo[i-1];
		}
		
		int [] pow=new int [32];
		for (int i=0;i<pow.length;i++) {
			pow[i]=powTwo[i]-1; //Math.pow will give precision error!
		}
		while (true) {
			BigInteger bi=new BigInteger(br.readLine());
			if (bi.equals(BigInteger.ZERO)) {
				break;
			}
			
			int index=1;
			int value=0;
			while (bi.compareTo(BigInteger.ZERO)>0) {
				value+=bi.mod(BigInteger.TEN).intValue()%10*pow[index++];
				bi=bi.divide(BigInteger.TEN);
			}
			
			System.out.println(value);
		}
	}  
}