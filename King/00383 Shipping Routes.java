import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	public static int bfs (HashMap<String,ArrayList<String>> adjList, String src, String dest) {
		if (src.equals(dest)) return 0;
		
		LinkedList<String> queue=new LinkedList<>();
		HashMap<String,Integer> dist=new HashMap<>();
		HashSet<String> visited=new HashSet<>();
		
		queue.add(src);
		visited.add(src);
		dist.put(src,0);
		
		while (!queue.isEmpty()) {
			String curr=queue.removeFirst();
			if (curr.equals(dest)) return dist.get(curr);
			
			for (String neighbour : adjList.get(curr)) if (!dist.containsKey(neighbour)) {
				queue.addLast(neighbour);
				dist.put(neighbour,dist.get(curr)+1);
			}
		}
		return -1;
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		StringBuilder sb=new StringBuilder();
		sb.append("SHIPPING ROUTES OUTPUT\n\n");
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			int P=Integer.parseInt(st.nextToken());
			
			HashMap<String,ArrayList<String>> adjacencyList=new HashMap<>();
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<M;i++) adjacencyList.put(st.nextToken(), new ArrayList<>());
			
			for (int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				String n1=st.nextToken();
				String n2=st.nextToken();
				adjacencyList.get(n1).add(n2);
				adjacencyList.get(n2).add(n1);
			}
			
			sb.append("DATA SET  ");
			sb.append(testCase);
			sb.append("\n\n");
			
			for (int i=0;i<P;i++) {
				st=new StringTokenizer(br.readLine());
				int size=Integer.parseInt(st.nextToken());
				int nodeCount=bfs(adjacencyList,st.nextToken(),st.nextToken());
				if (nodeCount==-1) sb.append("NO SHIPMENT POSSIBLE\n");
				else sb.append("$"+size*nodeCount*100+"\n");
			}
			sb.append("\n");
		}
		sb.append("END OF OUTPUT");
		System.out.println(sb.toString());
	}
	
}