import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class euler2 {
	
	public static int [][] adjList;
	public static int [] adjCount;

	public static int dfsCount;
	public static int [] dfsNum;
	public static int [] dfsLow;
	public static int [] dfsParent;
	public static int [] childCount;
	public static boolean [] isAP;

	public static class Bombsite implements Comparable<Bombsite> {
		int id;
		int pigeon;
		
		@Override
		public int compareTo(Bombsite b) {
			if (b.pigeon==this.pigeon) {
				return this.id-b.id;
			}
			return b.pigeon-this.pigeon;
		}
	}
	
	public static void dfs (int u) {
		dfsNum[u]=dfsCount;
		dfsLow[u]=dfsCount;
		dfsCount++;
		for (int i=0;i<adjCount[u];i++) {
			int v=adjList[u][i];
			if (dfsNum[v]==Integer.MAX_VALUE) {
				dfsParent[v]=u;
				childCount[u]++;
				
				dfs(v);
				if (dfsLow[v]>=dfsNum[u]) {   
					isAP[u]=true;
				}
				dfsLow[u]=Math.min(dfsLow[u],dfsLow[v]);
			} else if (dfsParent[u]!=v) { 
				dfsLow[u]=Math.min(dfsLow[u],dfsNum[v]);
			}
		}
	}
	
	public static boolean [] visited;
	
	public static void fill (int id) {
		if (!visited[id]) {
			visited[id]=true;
			for (int i=0;i<adjCount[id];i++) {
				fill(adjList[id][i]);
			}
		}
	}
	
	public static int computeCC (int id) {
		Arrays.fill(visited,false);
		if (id!=-1) {
			visited[id]=true;
		}
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
		String [] sAry;
		while ((s=br.readLine())!=null) {
			sAry=s.split(" ");
			int n=Integer.parseInt(sAry[0]);
			int m=Integer.parseInt(sAry[1]);
			if (n==0 && m==0) {
				break;
			}
			
			adjList=new int [n][n];
			adjCount=new int [n];
			HashSet<String> railways=new HashSet<>();
			while (true) {
				sAry=br.readLine().split(" ");
				int src=Integer.parseInt(sAry[0]);
				int dest=Integer.parseInt(sAry[1]);
				if (src==-1 && dest==-1) {
					break;
				}
				if (src!=dest && src>=0 && src<n && dest>=0 && dest<n) {
					StringBuilder sb1=new StringBuilder();
					sb1.append(src);
					sb1.append('_');
					sb1.append(dest);
					String key1=sb1.toString();
					if (!railways.contains(key1)) {
						adjList[src][adjCount[src]++]=dest;
						railways.add(key1);
					}
					
					StringBuilder sb2=new StringBuilder();
					sb2.append(dest);
					sb2.append('_');
					sb2.append(src);
					String key2=sb2.toString();
					if (!railways.contains(key2)) {
						adjList[dest][adjCount[dest]++]=src;
						railways.add(key2);
					}
				}
			}
			
			dfsCount=0;
			dfsParent=new int [n];
			Arrays.fill(dfsParent, -1);
			dfsNum=new int [n];
			Arrays.fill(dfsNum,Integer.MAX_VALUE);
			dfsLow=new int [n];
			isAP=new boolean [n];
			childCount=new int [n];
			for (int i=0;i<n;i++) {
				if (dfsNum[i]==Integer.MAX_VALUE) {
					dfs(i);
					isAP[i]=(childCount[i]>1);
				}
			}
			
			visited=new boolean [n];
			Bombsite [] bs=new Bombsite [n];
			for (int i=0;i<n;i++) {
				Bombsite b=new Bombsite();
				b.id=i;
				if (isAP[i]) {
					b.pigeon=computeCC(i);
				} else {
					b.pigeon=1;
				}
				bs[i]=b;
			}
			
			Arrays.sort(bs);
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<m;i++) {
				sb.append(bs[i].id);
				sb.append(' ');
				sb.append(bs[i].pigeon);
				sb.append('\n');
			}
			System.out.println(sb.toString());
		}
	}
}