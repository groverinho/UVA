import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int lel;
		StringBuilder sb=new StringBuilder();
		while ((lel=br.read())!=-1) {
			if (lel=='\n') {
				System.out.println(sb.toString());
				sb=new StringBuilder();
			} else {
				sb.append((char)(lel-7));
			}
		}
		
	}
}