import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args)  throws IOException {  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BigInteger [] f=new BigInteger [5001];
		f[0]=BigInteger.ZERO;
		f[1]=BigInteger.ONE;
		for (int i=2;i<f.length;i++) {
			f[i]=f[i-1].add(f[i-2]);
		}
		
		String s;
		while ((s=br.readLine())!=null) {
			int i=Integer.parseInt(s);
			System.out.println("The Fibonacci number for "+i+" is "+f[i].toString());
		}
	}  
}