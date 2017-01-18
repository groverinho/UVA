import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s; int testCase=1;
		
		while ((s=br.readLine())!=null && !s.startsWith("-"))
			System.out.println("Case "+testCase+++": "+(int)Math.ceil(Math.log(Double.parseDouble(s))/Math.log(2)));
	}
}