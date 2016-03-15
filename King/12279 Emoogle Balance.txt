import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=1;
		while ((s=br.readLine())!=null && !s.equals("0")) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int supposed=0;
			while (st.hasMoreTokens()) {
				if (Integer.parseInt(st.nextToken())>0) {
					supposed++;
				} else {
					supposed--;
				}
			}
			System.out.println("Case "+(testCase++)+": "+supposed);
		}
	}
}