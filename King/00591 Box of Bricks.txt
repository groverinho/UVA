import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase = 1;
		while ((s=br.readLine())!=null) {
			int pillarCount=Integer.parseInt(s);
			if (pillarCount==0) {
				break;
			}
			
			int [] num=new int [pillarCount];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i=0;i<num.length;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			//Get the diff between brick and average, sum all up and divide by 2.
			//Question already stated the total is divisible by number of pillars.
			int avg=0;
			for (int i=0;i<num.length;i++) {
				avg+=num[i];
			}
			avg/=num.length;
			
			int diff=0;
			for (int i=0;i<num.length;i++) {
				diff+=Math.abs(num[i]-avg);
			}
			System.out.println("Set #"+(testCase++)+"\nThe minimum number of moves is "+diff/2+".\n");
		}
	}
}