import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringBuilder sb=new StringBuilder();
			
			StringTokenizer st=new StringTokenizer(s);
			while (st.hasMoreTokens()) {
				String zz=st.nextToken();
				for (int i=zz.length()-1;i>=0;i--) {
					sb.append(zz.charAt(i));
				}
				sb.append(" ");
			}
			
			String disp=sb.toString();
			System.out.println(disp.substring(0, disp.length()-1));
		}
	}
}