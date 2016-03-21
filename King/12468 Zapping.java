import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("-1 -1")) {
			StringTokenizer st=new StringTokenizer(s);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if (a>b) {
				// 9 1
				// 99 1
				System.out.println(Math.min(a-b,100+b-a));
			} else if (a==b) {
				System.out.println(0);
			} else {
				System.out.println(Math.min(b-a,100+a-b));
			}
		}
	}
}