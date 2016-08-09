import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	
	public static class Hole implements Comparable<Hole> {
		char c;
		int size;
		
		public int compareTo (Hole h) {
			if (this.size==h.size) {
				return this.c-h.c;
			}
			return h.size-this.size;
		}
	}
	
	public static char [][] mat;
	public static boolean [][] visited;
	public static int [][] neighbour={{0,-1},{0,1},{-1,0},{1,0}};
	
	public static int floodfill (int x, int y, char c) {
		if (x>=0 && x<mat.length && y>=0 && y<mat[x].length && mat[x][y]==c && !visited[x][y]) {
			visited[x][y]=true;
			int count=1;
			for (int i=0;i<neighbour.length;i++) {
				count+=floodfill(x+neighbour[i][0],y+neighbour[i][1],c);
			}
			return count;
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for (int testCase=1;true;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			if (x==0 && y==0) {
				break;
			}
			mat=new char [x][];
			visited=new boolean [x][];
			for (int i=0;i<x;i++) {
				mat[i]=br.readLine().toCharArray();
				visited[i]=new boolean [mat[i].length];
			}

			ArrayList<Hole> hlist=new ArrayList<>();
			for (int i=0;i<x;i++) {
				for (int i2=0;i2<y;i2++) {
					if (mat[i][i2]!='.') {
						int size=floodfill(i,i2,mat[i][i2]);
						if (size>0) {
							Hole h=new Hole();
							h.c=mat[i][i2];
							h.size=size;
							hlist.add(h);
						}
					}
				}
			}
			
			Collections.sort(hlist);
			System.out.println("Problem "+testCase+":");
			for (int i=0;i<hlist.size();i++) {
				Hole h=hlist.get(i);
				System.out.println(h.c+" "+h.size);
			}
		}
	}
	
}