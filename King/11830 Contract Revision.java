import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			char fail=st.nextToken().charAt(0);
			StringBuilder sb=new StringBuilder();
			String str=st.nextToken();
			for (int i=0;i<str.length();i++)
				if (str.charAt(i)!=fail)
					sb.append(str.charAt(i));
			if (sb.length()==0)
				sb.append("0");
			System.out.println(new BigInteger(sb.toString()));
		}
	}
}