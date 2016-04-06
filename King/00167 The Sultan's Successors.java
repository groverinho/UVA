import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static int [][] dangerous;
	
	public static void queen (int x, int y, int value) {
		//flood fill algorithm.
		for (int i=0;i<dangerous.length;i++) {
			dangerous[x][i]=dangerous[x][i]+value;
		}
		for (int i=0;i<dangerous.length;i++) {
			dangerous[i][y]=dangerous[i][y]+value;
		}
		dangerous[x][y]=dangerous[x][y]-value;
		
		int tempx=x-1;
		int tempy=y-1;
		while (tempx>=0 && tempy>=0) {
			dangerous[tempx][tempy]=dangerous[tempx][tempy]+value;
			tempx--;
			tempy--;
		}
		
		tempx=x+1;
		tempy=y+1;
		while (tempx<dangerous.length && tempy<dangerous.length) {
			dangerous[tempx][tempy]=dangerous[tempx][tempy]+value;
			tempx++;
			tempy++;
		}
		
		
		tempx=x+1;
		tempy=y-1;
		while (tempx<dangerous.length && tempy>=0) {
			dangerous[tempx][tempy]=dangerous[tempx][tempy]+value;
			tempx++;
			tempy--;
		}
		
		tempx=x-1;
		tempy=y+1;
		while (tempx>=0 && tempy<dangerous.length) {
			dangerous[tempx][tempy]=dangerous[tempx][tempy]+value;
			tempx--;
			tempy++;
		}
	}
	
	public static int MaxSum=Integer.MIN_VALUE;
	
	public static void dfs (int currCol, boolean [] rowFlag, int [][] valueGrid, int sum) {
		if (currCol==rowFlag.length) {
			MaxSum=Math.max(MaxSum, sum);
		} else {
			for (int i=0;i<rowFlag.length;i++) {
				if (!rowFlag[i] && dangerous[i][currCol]==0) {
					rowFlag[i]=true;
					queen(i,currCol,1);
					dfs(currCol+1,rowFlag,valueGrid,sum+valueGrid[i][currCol]);
					queen(i,currCol,-1);
					rowFlag[i]=false;
				}
			}
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		String space="    ";
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int [][] grid=new int [8][8];
			
			dangerous=new int [8][8];
			for (int i=0;i<grid.length;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for (int i2=0;i2<grid.length;i2++) {
					grid[i][i2]=Integer.parseInt(st.nextToken());
				}
			}
			MaxSum=Integer.MIN_VALUE;
			dfs(0,new boolean [grid.length],grid,0);
			int spaceLength=5-((int)Math.log10(MaxSum)+1);
			
			System.out.println(space.substring(0,spaceLength)+MaxSum);
		}
		
	}
	
}