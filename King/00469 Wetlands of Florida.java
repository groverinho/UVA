import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static char [][] mat;
	public static boolean [][] visited;
	public static int visitedCount;
	public static int [][] neighbour={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	public static void floodfill (int currX, int currY) {
		if (currX>=0 && currX<mat.length && currY>=0 && currY<mat[currX].length && mat[currX][currY]=='W' && !visited[currX][currY]) {
			visited[currX][currY]=true;
			visitedCount++;
			for (int i=0;i<neighbour.length;i++) {
				floodfill(currX+neighbour[i][0],currY+neighbour[i][1]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine();//blank.
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			ArrayList<String> slist=new ArrayList<>();
			String s;
			while (true) {
				s=br.readLine();
				if (s.charAt(0)=='L' || s.charAt(0)=='W') {
					slist.add(s);
				} else {
					break;
				}
			}
			
			mat=new char [slist.size()][];
			visited=new boolean [slist.size()][];
			for (int i=0;i<mat.length;i++) {
				mat[i]=slist.get(i).toCharArray();
				visited[i]=new boolean [mat[i].length];
			}

			if (testCase>0) {
				System.out.println();
			}
			while (s!=null && !s.isEmpty()) {
				StringTokenizer st=new StringTokenizer(s);
				int x=Integer.parseInt(st.nextToken())-1;
				int y=Integer.parseInt(st.nextToken())-1;
				for (boolean [] v : visited) {
					Arrays.fill(v,false);
				}
				visitedCount=0;
				floodfill(x,y);
				System.out.println(visitedCount);
				s=br.readLine();
			}
		}
	}
	
}