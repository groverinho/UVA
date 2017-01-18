import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.startsWith("-")) {
			//formula = [n(n+1)/2]+1
			long l=Long.parseLong(s);
			System.out.println((l*(l+1))/2+1);
		}
	}
}