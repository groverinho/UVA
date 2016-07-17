import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

	public static void main(String[] args)  throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while ((s=br.readLine())!=null) {
        	BigInteger b=new BigInteger(s);
        	BigInteger p=new BigInteger(br.readLine());
        	BigInteger m=new BigInteger(br.readLine());
        	
        	System.out.println(b.modPow(p, m));
        	
        	br.readLine();//empty line!
        }
	}  
}