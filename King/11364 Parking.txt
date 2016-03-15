import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int posCount=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int [] pos=new int [posCount];
			for (int i=0;i<pos.length;i++){
				pos[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(pos);
			
			int length=0;
			for (int i=1;i<pos.length;i++) {
				length+=(pos[i]-pos[i-1]);
			}
			
			System.out.println(length*2);
		}
	}
}