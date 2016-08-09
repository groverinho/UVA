import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			
			if (n==0 && m==0) {
				break;
			}
			
			int [] ns=new int [n];
			for (int i=0;i<ns.length;i++) {
				ns[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(ns);
			
			int [] ms=new int [m];
			for (int i=0;i<ms.length;i++) {
				ms[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(ms);
			
			boolean doomed=false;
			int cost=0;
			int mIndex=0;
			for (int i=0;i<ns.length;i++) {
				while (mIndex<ms.length && ms[mIndex]<ns[i]) {
					mIndex++;
				}
				if (mIndex==ms.length) {
					doomed=true;
					break;
				} else {
					cost+=ms[mIndex];
					mIndex++;
				}
			}
			
			if (doomed) {
				System.out.println("Loowater is doomed!");
			} else {
				System.out.println(cost);
			}
		}
	}
}