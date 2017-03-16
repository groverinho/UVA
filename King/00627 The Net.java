import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	
	public static String bfs (PriorityQueue<Integer> [] adjList, int src, int dest) {
		boolean [] visited=new boolean [adjList.length];
		LinkedList<Integer> queue=new LinkedList<>();
		int [] previousNode=new int [adjList.length];
		Arrays.fill(previousNode, -1);
		
		queue.add(src);
		visited[src]=true;
		
		while (!queue.isEmpty()) {
			int curr=queue.removeFirst();
			if (curr==dest) break;
			else {
				for (int neighbour : adjList[curr]) if (!visited[neighbour]) {
					queue.add(neighbour);
					previousNode[neighbour]=curr;
					visited[neighbour]=true;
				}
			}
		}
		
		if (previousNode[dest]==-1) return "connection impossible";
		else {
			Stack<Integer> stk=new Stack<>();
			while (dest!=-1) {
				stk.push(dest);
				dest=previousNode[dest];
			}
			
			StringBuilder sb=new StringBuilder();
			while (!stk.isEmpty()) {
				sb.append(stk.pop());
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			return sb.toString();
		}
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			PriorityQueue<Integer> [] adjList=new PriorityQueue [n+1];
			for (int i=1;i<adjList.length;i++) adjList[i]=new PriorityQueue<>();
			
			for (int i=0;i<n;i++) {
				String [] lineSplit1=br.readLine().split("-");
				
				if (lineSplit1.length>1) {
					String [] lineSplit2=lineSplit1[1].split(",");
					
					int src=Integer.parseInt(lineSplit1[0]);
					for (String node : lineSplit2) {
						int dest=Integer.parseInt(node);
						if (!adjList[src].contains(dest)) adjList[src].offer(dest);
						//if (!adjList[dest].contains(src)) adjList[dest].offer(src);
					}
				}
			}
			
			System.out.println("-----");
			int m=Integer.parseInt(br.readLine());
			for (int i=0;i<m;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				int dest=Integer.parseInt(st.nextToken());
				System.out.println(bfs(adjList,src,dest));
			}
		}
	}
	
}