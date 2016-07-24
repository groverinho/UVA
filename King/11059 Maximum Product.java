import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=1;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);

			StringTokenizer st=new StringTokenizer(br.readLine());
			int [] ints=new int [n];
			for (int i=0;i<n;i++) {
				ints[i]=Integer.parseInt(st.nextToken());
			}
				
			
			long value=0;
			for (int min=0;min<n;min++) {
				if (ints[min]!=0) {
					long tempValue=1;
					for (int temp=min;temp<n&& tempValue!=0;temp++) {
						tempValue*=ints[temp];
						value=Math.max(tempValue, value);
					}
				}
			}
			
			System.out.println("Case #"+testCase+++": The maximum product is "+value+".\n");
			br.readLine();// blank.
		}
	}
}