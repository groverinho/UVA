import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static class Stringx implements Comparable<Stringx> {
		private String s;
		
		public Stringx (String s) {
			this.s=s;
		}
		
		public String toString() {
			return s;
		}
		
		public int compareTo(Stringx sx) {
			return (this.s+sx.s).compareTo(sx.s+this.s);
		}
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int N=Integer.parseInt(s);
			Stringx [] num=new Stringx[N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) num[i]=new Stringx(st.nextToken());
			
			Arrays.sort(num);
			StringBuilder ans=new StringBuilder();
			for (int i=N-1;i>=0;i--) ans.append(num[i]);
			
			System.out.println(ans.toString());
		}
	}
	
}