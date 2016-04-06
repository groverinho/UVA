import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	
	public static int [][] settings=new int [100][8];
	public static int settingsCount=0;
	
	public static void dfs (int [] colValue, int colPos, boolean [] rowFlag) {
		if (colPos==colValue.length) {
			settings[settingsCount++]=Arrays.copyOf(colValue,colValue.length);
		} else {
			if (colValue[colPos]==-1) {
				for (int i=0;i<dangerous.length;i++) {
					if (!rowFlag[i] && dangerous[i][colPos]==0) {
						colValue[colPos]=i;
						queen(i, colPos, 1);
						rowFlag[i]=true;
						
						dfs(colValue,colPos+1,rowFlag);
						
						rowFlag[i]=false;
						queen(i, colPos, -1);
						colValue[colPos]=-1;
					}
				}
			} else {
				dfs(colValue,colPos+1,rowFlag);
			}
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine();
			dangerous=new int [8][8];
			settings=new int [100][8];
			settingsCount=0;
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int row=Integer.parseInt(st.nextToken())-1;
			int col=Integer.parseInt(st.nextToken())-1;
			queen(row,col,1);
	
			
			int [] colValue=new int [8];
			Arrays.fill(colValue,-1);
			colValue[col]=row;
			
			boolean [] flag=new boolean [8];
			flag[row]=true;
			dfs(colValue,0,flag);
			
			StringBuilder sb=new StringBuilder();
			if (testCase>0) {
				sb.append("\n");
			}
			
			sb.append("SOLN       COLUMN\n #      1 2 3 4 5 6 7 8\n\n");
			for (int i=0;i<settingsCount;i++) {
				if (i<9) {
					sb.append(" "+(i+1)+"      ");
				} else {
					sb.append((i+1)+"      ");
				}
				for (int i2=0;i2<settings[i].length;i2++) {
					sb.append(settings[i][i2]+1);
					if (i2!=settings[i].length-1) {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
			
			System.out.print(sb.toString());
		}
	}
	
}