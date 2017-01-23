import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while (!(s=br.readLine()).equals("0")) {
			int I=Integer.parseInt(s);
			String value=Integer.toBinaryString(I);
			int count=0;
			for (int i=0;i<32;i++) count+=(I >> i) & 1;
			System.out.println("The parity of "+value+" is "+count+" (mod 2).");
		}
	}
}