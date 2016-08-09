import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	
	public static int R, C, M, N;
	public static boolean [][] water;
	public static boolean [][] visited;
	public static int [][] neighbour;
	
	public static void floodfill (int x, int y) {
		int [][] coordinate=new int [neighbour.length][2];
		for (int i=0;i<neighbour.length;i++) {
			coordinate[i][0]=x+neighbour[i][0];
			coordinate[i][1]=y+neighbour[i][1];
		}
		
		for (int i=0;i<coordinate.length;i++) {
			int currX=coordinate[i][0];
			int currY=coordinate[i][1];
			if (currX>=0 && currX<R && currY>=0 && currY<C && !water[currX][currY] && !visited[currX][currY]) {
				visited[currX][currY]=true;
				floodfill(currX,currY);
			}
		}
	}
	
	public static int countJump (int x, int y) {
		int [][] coordinate=new int [neighbour.length][2];
		for (int i=0;i<neighbour.length;i++) {
			coordinate[i][0]=x+neighbour[i][0];
			coordinate[i][1]=y+neighbour[i][1];
		}
		
		int count=0;
		HashSet<String> set=new HashSet<>();
		for (int i=0;i<coordinate.length;i++) {
			int currX=coordinate[i][0];
			int currY=coordinate[i][1];
			String key=currX+"_"+currY;
			if (currX>=0 && currX<R && currY>=0 && currY<C && visited[currX][currY] && !set.contains(key)) {
				set.add(key);
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			neighbour=new int [][] {{-M,-N},{-M,N},{M,-N},{M,N},{-N,-M},{-N,M},{N,-M},{N,M}};
			
			water=new boolean [R][C];
			for (int i=Integer.parseInt(br.readLine());i>0;i--) {
				st=new StringTokenizer(br.readLine());
				water[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
			}
			
			visited=new boolean [R][C];
			visited[0][0]=true;
			floodfill(0,0);

			int evenCount=0;
			int oddCount=0;
			for (int i=0;i<R;i++) {
				for (int i2=0;i2<C;i2++) {
					if (visited[i][i2]) {
						if (countJump(i,i2)%2==0) {
							evenCount++;
						} else {
							oddCount++;
						}
					}
				}
			}
			
			System.out.println("Case "+testCase+": "+evenCount+" "+oddCount);
		}
	}
}