import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static int [][] dangerous;
	
	public static void queen (int x, int y, int value) {
		//flood fill algorithm.
		for (int i=0;i<dangerous.length;i++) {
			if (dangerous[x][i]!=-1) {
				dangerous[x][i]=dangerous[x][i]+value;
			}
		}
		for (int i=0;i<dangerous.length;i++) {
			if (dangerous[i][y]!=-1) {
				dangerous[i][y]=dangerous[i][y]+value;
			}
		}
		dangerous[x][y]=dangerous[x][y]-value;
		int tempx=x-1;
		int tempy=y-1;
		while (tempx>=0 && tempy>=0) {
			if (dangerous[tempx][tempy]!=-1) {
				dangerous[tempx][tempy]=dangerous[tempx][tempy]+value;
			}
			tempx--;
			tempy--;
		}
		
		tempx=x+1;
		tempy=y+1;
		while (tempx<dangerous.length && tempy<dangerous.length) {
			if (dangerous[tempx][tempy]!=-1) {
				dangerous[tempx][tempy]=dangerous[tempx][tempy]+value;
			}
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
	
	public static int settingsCount=0;
	
	public static void dfs (int level, boolean [] rowFlag) {
		if (level==rowFlag.length) {
			settingsCount++;
		} else {
			for (int i=0;i<rowFlag.length;i++) {
				if (!rowFlag[i] && dangerous[level][i]==0) {
					rowFlag[i]=true;
					queen(level,i,1);
					dfs(level+1,rowFlag);
					queen(level,i,-1);
					rowFlag[i]=false;
				}
			}
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int caseCount=1;
		while (!(s=br.readLine()).equals("0")) {
			settingsCount=0;
			int gridSize=Integer.parseInt(s);
			dangerous=new int [gridSize][gridSize];
			for (int i=0;i<gridSize;i++) {
				s=br.readLine();
				for (int i2=0;i2<gridSize;i2++) {
					if (s.charAt(i2)=='*') {
						dangerous[i][i2]=-1;
					}
				}
			}
			
			dfs(0,new boolean [gridSize]);
			System.out.println("Case "+caseCount+": "+settingsCount);
			caseCount++;
		}
	}
	
}