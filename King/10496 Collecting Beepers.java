import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static int [][] coordinate;
	public static int minLength;
	
	public static void search (int mask, int count, int [] currLoc, int currLength) {
		if (count==coordinate.length) {
			minLength=Math.min(minLength, currLength+Math.abs(coordinate[0][0]-currLoc[0])+Math.abs(coordinate[0][1]-currLoc[1]));
		} else if (currLength<minLength) {
			for (int i=1;i<coordinate.length;i++) {
				if ((mask & (1<<i)) == 0) {
					search(mask | (1 << i),count+1,coordinate[i],currLength+Math.abs(coordinate[i][0]-currLoc[0])+Math.abs(coordinate[i][1]-currLoc[1]));
				}
			}
		}
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int wx=Integer.parseInt(st.nextToken());
			int wy=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			int startX=Integer.parseInt(st.nextToken());
			int startY=Integer.parseInt(st.nextToken());
			
			int N=Integer.parseInt(br.readLine());
			coordinate=new int [N+1][2];
			coordinate[0][0]=startX;
			coordinate[0][1]=startY;
			
			for (int i=1;i<=N;i++) {
				st=new StringTokenizer(br.readLine());
				coordinate[i][0]=Integer.parseInt(st.nextToken());
				coordinate[i][1]=Integer.parseInt(st.nextToken());
			}
			
			minLength=Integer.MAX_VALUE;
			int mask=0;
			search((mask | 1 << 0),1,coordinate[0],0);
			
			System.out.println("The shortest path has length "+minLength);
		}
	}
}