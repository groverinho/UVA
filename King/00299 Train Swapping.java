import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int numCount=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int [] num=new int [numCount];
			for (int i=0;i<numCount;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			int swapCount=0;
			for (int i=0;i<numCount-1;i++) {
				for (int i2=0;i2<numCount-(i+1);i2++) {
					if (num[i2]>num[i2+1]) {
						int temp=num[i2+1];
						num[i2+1]=num[i2];
						num[i2]=temp;
						swapCount++;
					}
				}
			}
			
			System.out.println("Optimal train swapping takes "+swapCount+" swaps.");
		}
	}
}