import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		boolean mode=true;
		while ((s=br.readLine())!=null) {
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<s.length();i++) {
				if (s.charAt(i)=='"') {
					if (mode) {
						sb.append("``");
					} else {
						sb.append("''");
					}
					mode=!mode;
				} else {
					sb.append(s.charAt(i));
				}
			}
			System.out.println(sb.toString());
		}
	}
}