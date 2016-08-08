import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {
	
	public static int [][] adjList;
	public static int [] adjCount;
	public static int [] disabledEdge;
	public static boolean [] visited;
	
	public static void fill (int id) {
		if (!visited[id]) {
			visited[id]=true;
			for (int i=0;i<adjCount[id];i++) {
				int nextId=adjList[id][i];
				//edge is not disabled.
				if (disabledEdge[0]!=Math.min(id, nextId) || disabledEdge[1]!=Math.max(id, nextId)) {
					fill(nextId);
				}
			}
		}
	}
	
	public static int calculateCC() {
		Arrays.fill(visited, false);
		int count=0;
		for (int i=0;i<adjList.length;i++) {
			if (!visited[i]) {
				fill(i);
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int N=Integer.parseInt(s);
			
			if (N==0) {
				br.readLine();
				System.out.println("0 critical links\n");
				continue;
			}
			adjList=new int [N][N];
			adjCount=new int [N];
			HashSet<String> adjExist=new HashSet<>();
			
			while ((s=br.readLine())!=null && !s.isEmpty()) {
				StringTokenizer st=new StringTokenizer(s);
				int src=Integer.parseInt(st.nextToken());
				int count=Integer.parseInt(st.nextToken().replaceAll("\\(","").replace(")",""));
				for (int i=0;i<count;i++) {
					int dest=Integer.parseInt(st.nextToken());
					//Safety check & add.
					if (src!=dest && src>=0 && src<N && dest>=0 && dest<N) {
						String key1=src+"_"+dest;
						String key2=dest+"_"+src;
						if (!adjExist.contains(key1)) {
							adjList[src][adjCount[src]++]=dest;
							adjExist.add(key1);
						}
						if (!adjExist.contains(key2)) {
							adjList[dest][adjCount[dest]++]=src;
							adjExist.add(key2);
						}
					}
				}
			}
			
			//Sort the edge according to id to fit the output format.
			for (int i=0;i<N;i++) {
				Arrays.sort(adjList[i],0,adjCount[i]);
			}
			
			//We have 2 copies of edge, so we reduce it into single (i - j, where i > j)
			ArrayList<String> directedAdjSet=new ArrayList<>();
			for (int i=0;i<N;i++) {
				for (int i2=0;i2<adjCount[i];i2++) {
					if (i<adjList[i][i2]) {
						directedAdjSet.add(i+"_"+adjList[i][i2]);
					}
				}
			}
			
			visited=new boolean [N];
			disabledEdge=new int [2];
			int clCount=0;
			StringBuilder cl=new StringBuilder();
			
			disabledEdge[0]=disabledEdge[1]=-1;
			int initCC=calculateCC();

			Iterator<String> allEdges=directedAdjSet.iterator();
			while (allEdges.hasNext()) {
				String edgeStr=allEdges.next();
				StringTokenizer st=new StringTokenizer(edgeStr,"_");
				int src=Integer.parseInt(st.nextToken());
				int dest=Integer.parseInt(st.nextToken());
				disabledEdge[0]=src;
				disabledEdge[1]=dest;
				int currCC=calculateCC();
				if (currCC>initCC) {
					clCount++;
					cl.append(src);
					cl.append(" - ");
					cl.append(dest);
					cl.append("\n");
				}
			}
			
			System.out.println(clCount+" critical links");
			System.out.println(cl.toString());
		}
	}
}