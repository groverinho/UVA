import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=1;
		while ((s=br.readLine())!=null && !s.equals("0 0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int max=Integer.parseInt(st.nextToken());
			
			int [] consump=new int [n];
			boolean [] on=new boolean [n];
			for (int i=0;i<n;i++) {
				consump[i]=Integer.parseInt(br.readLine());
			}
			
			int currConsump=0;
			int maxCurrConsump=-Integer.MAX_VALUE;
			for (int i=0;i<m;i++) {
				int id=Integer.parseInt(br.readLine())-1;
				on[id]=!on[id];
				if (on[id]) {
					currConsump+=consump[id];
					maxCurrConsump=Math.max(maxCurrConsump, currConsump);
				} else {
					currConsump-=consump[id];
				}
			}
			
			System.out.println("Sequence "+(testCase++));
			if (maxCurrConsump<=max) {
				System.out.println("Fuse was not blown.\nMaximal power consumption was "+maxCurrConsump+" amperes.\n");
			} else {
				System.out.println("Fuse was blown.\n");
			}
		}
	}
}