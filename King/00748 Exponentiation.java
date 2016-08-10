import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			BigDecimal bd=new BigDecimal(st.nextToken()).pow(Integer.parseInt(st.nextToken()));
			String str=bd.toPlainString();
			int lastZero=str.length()-1;
			if (str.indexOf('.')>=0) {
				while (str.charAt(lastZero)=='0') {
					lastZero--;
				}
				str=str.substring(0,lastZero+1);
			}
			if (str.startsWith("0.")) {
				str=str.substring(1,str.length());
			}
			System.out.println(str);
		}
	}
}