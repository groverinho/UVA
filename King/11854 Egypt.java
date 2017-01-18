import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;

		while ((s=br.readLine())!=null && !s.equals("0 0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int [] ints={Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			Arrays.sort(ints);
			if (ints[0]*ints[0]+ints[1]*ints[1]==ints[2]*ints[2]) System.out.println("right");
			else System.out.println("wrong");
		}


	}
}