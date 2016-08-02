import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static char [][] mat;
	public static boolean whiteWins;
	public static boolean blackWins;
	public static int [][] neighbour={{-1,-1},{-1,0},{0,-1},{0,1},{1,0},{1,1}};
	
	public static void searchWhite (int x, int y) {
		if (x>=0 && x<mat.length && y>=0 && y<mat.length && mat[x][y]=='w') {
			mat[x][y]='.';
			
			if (y==mat.length-1) {
				whiteWins=true;
			}
			for (int i=0;i<neighbour.length;i++) {
				searchWhite(x+neighbour[i][0],y+neighbour[i][1]);
			}
		}
	}
	
	public static void searchBlack (int x, int y) {
		if (x>=0 && x<mat.length && y>=0 && y<mat.length && mat[x][y]=='b') {
			mat[x][y]='.';
			
			if (x==mat.length-1) {
				blackWins=true;
			}
			for (int i=0;i<neighbour.length;i++) {
				searchBlack(x+neighbour[i][0],y+neighbour[i][1]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=1;
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int n=Integer.parseInt(s);
			
			mat=new char [n][];
			for (int i=0;i<n;i++) {
				mat[i]=br.readLine().toCharArray();
			}
			
			whiteWins=false;
			blackWins=false;
			for (int i=0;i<n;i++) {
				searchWhite(i,0);
			}
			
			for (int i=0;i<n;i++) {
				searchBlack(0,i);
			}
			
			if (whiteWins) {
				System.out.println(t+" W");
			} else if (blackWins) {
				System.out.println(t+" B");
			}
			t++;
		}
	}
	
}