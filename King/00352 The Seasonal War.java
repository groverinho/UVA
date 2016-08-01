import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static char [][] mat;
	public static int [][] fill;
	public static boolean filled;
	public static int fillCount;
	
	public static void floodfill (int currX, int currY, int currFill) {
		if (currX>=0 && currX<mat.length && currY>=0 && currY<mat.length && mat[currX][currY]=='1' && fill[currX][currY]==-1) {
			filled=true;
			fill[currX][currY]=currFill;
			floodfill(currX-1,currY-1,currFill);
			floodfill(currX-1,currY,currFill);
			floodfill(currX-1,currY+1,currFill);
			
			floodfill(currX,currY-1,currFill);
			floodfill(currX,currY+1,currFill);
			
			floodfill(currX+1,currY-1,currFill);
			floodfill(currX+1,currY,currFill);
			floodfill(currX+1,currY+1,currFill);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=1;
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			
			mat=new char [n][];
			for (int i=0;i<n;i++) {
				mat[i]=br.readLine().toCharArray();
			}
			
			fill=new int [n][n];
			for (int [] fillS : fill) {
				Arrays.fill(fillS,-1);
			}
			fillCount=0;
			
			for (int i=0;i<n;i++) {
				for (int i2=0;i2<n;i2++) {
					filled=false;
					floodfill(i,i2,fillCount);
					if (filled) {
						fillCount++;
					}
				}
			}
			
			System.out.println("Image number "+t+++" contains "+fillCount+" war eagles.");
		}
	}
	
}