import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		BigInteger eleven=new BigInteger("11");
		
		while (!(s=br.readLine()).equals("0")) {
			//Come I give you clap by including spaces in the line!
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<s.length();i++) {
				if (Character.isDigit(s.charAt(i))) {
					sb.append(s.charAt(i));
				}
			}
			
			BigInteger bi=new BigInteger(sb.toString());
			
			if (bi.mod(eleven).equals(BigInteger.ZERO)) {
				//Also need to clap cos need to include leading zero... wth!
				System.out.println(sb.toString()+" is a multiple of 11.");
			} else {
				System.out.println(sb.toString()+" is not a multiple of 11.");
			}
		}
	}    
}