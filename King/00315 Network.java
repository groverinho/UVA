import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static boolean [][] edges;
	public static boolean [] visited;
	
	public static void visitNodes (int id) {
		if (!visited[id]) {
			visited[id]=true;
			for (int i=1;i<edges.length;i++) {
				if (edges[id][i]) {
					visitNodes(i);
				}
			}
		}
	}
	
	public static int countConnectedComponents (int disable) {
		Arrays.fill(visited, false);
		int count=0;
		if (disable!=-1) {
			visited[disable]=true;
		}
		for (int i=1;i<edges.length;i++) {
			if (!visited[i]) {
				visitNodes(i);
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N=Integer.parseInt(br.readLine());
			if (N==0) {
				break;
			}
			
			edges=new boolean [N+1][N+1];
			while (true) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				if (src==0) {
					break;
				} else {
					while (st.hasMoreTokens()) {
						int dest=Integer.parseInt(st.nextToken());
						if (dest>=1 && dest<=N) {
							edges[src][dest]=true;
							edges[dest][src]=true;
							//System.out.println(src+"->"+dest);
						}
					}
				}
			}
			
			
			visited=new boolean [N+1];
			//CC = connected components / number of graphs
			int initialCC=countConnectedComponents(-1);
			int criticalPoint=0;
			for (int currDisabled=1;currDisabled<=N;currDisabled++) {
				//Disable a node and calculate the number of graphs.
				//If it is an articulation point, number of graphs will increase.
				int currCC=countConnectedComponents(currDisabled);
				if (currCC>initialCC) {
					criticalPoint++;
				}
			}
			
			System.out.println(criticalPoint);
		}
	}
}