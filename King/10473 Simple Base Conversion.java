import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[]args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine()).charAt(0)!='-') {
			if (s.startsWith("0x"))
				System.out.println(new BigInteger(s.substring(2,s.length()),16).toString());
			else
				System.out.println("0x"+new BigInteger(s).toString(16).toUpperCase());
		}
	}
	
}