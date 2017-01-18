import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while (!(s=br.readLine()).equals("0")) {
			StringTokenizer st=new StringTokenizer(s);
			int length=Integer.parseInt(st.nextToken());
			String txt=st.nextToken();
			
			length=txt.length()/length;
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<txt.length();i+=length) {
				for (int i2=i+length-1;i2>=i;i2--) {
					sb.append(txt.charAt(i2));
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}