import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		//Square root 100000 = 316/23
		int [] count=new int [100001];
		for (int i=1;i<=316;i++) {
			for (int i2=i*i;i2<count.length;i2++) {
				count[i2]++;
			}
		}
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;

		while ((s=br.readLine())!=null && !s.equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int min=Integer.parseInt(st.nextToken());
			int max=Integer.parseInt(st.nextToken());
			int ans=count[max]-count[min];
			if (count[min]>count[min-1])  ans++;
			System.out.println(ans);
		}


	}
}