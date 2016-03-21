import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			double n=Double.parseDouble(s);
			double p=Double.parseDouble(br.readLine());
			// k^n = p
			// k = p^(1/n)
			double kDouble=Math.pow(p, 1/n);
			//eliminate double's precision error by rounding off.
			kDouble=(kDouble*10+5)/10;
			System.out.println((int)kDouble);
		}
	}
}