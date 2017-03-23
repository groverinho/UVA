import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("-1")) {
			int n=Integer.parseInt(s);
			
			long [] maleBee=new long [n+1];
			long [] femaleBee=new long [n+1];
			
			maleBee[0]=0;
			femaleBee[0]=1;
			for (int i=1;i<=n;i++) {
				maleBee[i]=femaleBee[i-1]+maleBee[i-1];
				femaleBee[i]=maleBee[i-1]+1;
			}
			
			System.out.println(maleBee[n]+" "+(maleBee[n]+femaleBee[n]));
		}
	}
	
}
