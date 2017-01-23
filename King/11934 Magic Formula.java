import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0 0 0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int [] values={Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			int count=0;
			for (int x=0;x<=values[4];x++) if (((values[0]*x*x+values[1]*x+values[2])%values[3])==0) count++;
			
			System.out.println(count);
		}
	}
}