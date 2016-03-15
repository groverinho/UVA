import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int wallCount=Integer.parseInt(br.readLine());
			int [] count=new int [2];
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int lastWall=Integer.parseInt(st.nextToken());
			for (int i=0;i<wallCount-1;i++) {
				int currWall=Integer.parseInt(st.nextToken());
				if (currWall>lastWall) {
					count[0]++;
				} else if (currWall<lastWall) {
					count[1]++;
				}
				lastWall=currWall;
			}
			
			System.out.println("Case "+testCase+": "+count[0]+" "+count[1]);
		}
	}
}