import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			
			if (n==0 && d==0 && r==0) {
				break;
			}
			
			int [] driverDist=new int [n];
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				driverDist[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(driverDist);
			
			st=new StringTokenizer(br.readLine());
			int [] evening=new int [n];
			for (int i=0;i<n;i++) {
				evening[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(evening);

			for (int i=0;i<driverDist.length;i++) {
				driverDist[i]+=evening[driverDist.length-i-1];
			}
			
			int over=0;
			for (int i=0;i<n;i++) {
				over+=Math.max(0,driverDist[i]-d);
			}
			
			System.out.println(over*r);
		}
	}
}