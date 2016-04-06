import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static boolean possible=false;
	
	public static void dfs (int [] sticks, int min, int currLength, int targetLength) {
		if (currLength==targetLength) {
			possible=true;
		} else if (!possible) {
			for (int i=min;i<sticks.length;i++) {
				if (currLength+sticks[i]<=targetLength) {
					dfs(sticks,i+1,currLength+sticks[i],targetLength);
				}
			}
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int targetLength=Integer.parseInt(br.readLine());
			int stickCount=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int [] sticks=new int [stickCount];
			for (int i=0;i<stickCount;i++) {
				sticks[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(sticks);
			possible=false;
			dfs(sticks,0,0,targetLength);
			
			if (possible) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
 	}
}