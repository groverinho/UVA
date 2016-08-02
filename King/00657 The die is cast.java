import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static char [][] mat;
	public static int [][] index;
	public static boolean [][] visitedX;
	
	public static void label (int currX, int currY, int id) {
		if (currX>=0 && currX<mat.length && currY>=0 && currY<mat[currX].length && (mat[currX][currY]=='*' || mat[currX][currY]=='X') && index[currX][currY]==-1) {
			index[currX][currY]=id;
			label(currX+1,currY,id);
			label(currX-1,currY,id);
			label(currX,currY-1,id);
			label(currX,currY+1,id);
		}
	}
	
	public static void floodX (int currX, int currY) {
		if (currX>=0 && currX<mat.length && currY>=0 && currY<mat[currX].length && mat[currX][currY]=='X' && !visitedX[currX][currY]) {
			visitedX[currX][currY]=true;
			floodX(currX-1,currY);
			floodX(currX+1,currY);
			floodX(currX,currY-1);
			floodX(currX,currY+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=1;
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int maxY=Integer.parseInt(st.nextToken());
			int maxX=Integer.parseInt(st.nextToken());
			if (maxY==0 && maxX==0) {
				break;
			}
			
			mat=new char [maxX][];
			for (int i=0;i<maxX;i++) {
				mat[i]=br.readLine().toCharArray();
			}
			
			index=new int [maxX][maxY];
			for (int [] indexS : index) {
				Arrays.fill(indexS, -1);
			}
			int idCount=0;
			for (int i=0;i<mat.length;i++) {
				for (int i2=0;i2<mat[i].length;i2++) {
					if ((mat[i][i2]=='*' || mat[i][i2]=='X') && index[i][i2]==-1) {
						label(i,i2,idCount++);
					}
				}
			}
			
			visitedX=new boolean [maxX][maxY];
			int [] xGroupsCount=new int [idCount];
			for (int i=0;i<mat.length;i++) {
				for (int i2=0;i2<mat[i].length;i2++) {
					if (mat[i][i2]=='X' && !visitedX[i][i2]) {
						xGroupsCount[index[i][i2]]++;
						floodX(i,i2);
					}
				}
			}
			Arrays.sort(xGroupsCount);

			System.out.println("Throw "+t++);
			for (int i=0;i<xGroupsCount.length;i++) {
				if (xGroupsCount[i]>0) {
					System.out.print(xGroupsCount[i]);
					if (i<xGroupsCount.length-1) {
						System.out.print(" ");
					}
				}
			}
			System.out.println("\n");
		}
	}
	
}