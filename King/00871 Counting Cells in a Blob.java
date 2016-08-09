import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static char [][] mat;
	public static boolean [][] visited;
	public static int [][] neighbour={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static int getSize (int x, int y) {
		if (x>=0 && x<mat.length && y>=0 && y<mat[x].length && mat[x][y]=='1' && !visited[x][y]) {
			visited[x][y]=true;
			int count=1;
			for (int i=0;i<neighbour.length;i++) {
				count+=getSize(x+neighbour[i][0],y+neighbour[i][1]);
			}
			return count;
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine();
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			ArrayList<String> slist=new ArrayList<>();
			
			while (true) {
				String s=br.readLine();
				if (s==null || s.isEmpty()) {
					break;
				}
				slist.add(s);
			}
			
			mat=new char [slist.size()][];
			visited=new boolean [slist.size()][];
			for (int i=0;i<slist.size();i++) {
				mat[i]=slist.get(i).toCharArray();
				visited[i]=new boolean [mat[i].length];
			}
			
			int maxSize=0;
			for (int i=0;i<mat.length;i++) {
				for (int i2=0;i2<mat[i].length;i2++) {
					maxSize=Math.max(maxSize, getSize(i,i2));
				}
			}
			
			if (testCase>0) {
				System.out.println();
			}
			System.out.println(maxSize);
		}
	}
	
}