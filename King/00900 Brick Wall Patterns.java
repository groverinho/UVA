import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BigInteger [] value=new BigInteger [51];
		value[1]=BigInteger.ONE;
		value[2]=BigInteger.valueOf(2);
		
		for (int i=3;i<value.length;i++) value[i]=value[i-1].add(value[i-2]);
		
		String s;
		while (!(s=br.readLine()).equals("0")) System.out.println(value[Integer.parseInt(s)]);
	}
}