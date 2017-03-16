import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	public static String bfs (HashMap<String,ArrayList<String>> adjList, String src, String dest) {
		Queue<String> queue=new ArrayDeque<>();
		HashMap<String,String> prevNode=new HashMap<>();
	
		queue.offer(src);
		prevNode.put(src,null);
		
		while (!queue.isEmpty()) {
			String curr=queue.poll();
			if (curr.equals(dest)) break;
			else if (adjList.containsKey(curr)) {
				for (String neighbour : adjList.get(curr)) if (!prevNode.containsKey(neighbour)) {
					queue.offer(neighbour);
					prevNode.put(neighbour, curr);
				}
			}
		}
		
		if (!prevNode.containsKey(dest)) return "";
		else {
			ArrayList<String> list=new ArrayList<>();
			while (dest!=null) {
				list.add(0,dest);
				dest=prevNode.getOrDefault(dest,null);
			}
			
			StringBuilder sb=new StringBuilder();
			for (String s : list) sb.append(s.charAt(0));
			
			return sb.toString();
		}
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine(); //empty.
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			
			HashMap<String,ArrayList<String>> adjList=new HashMap<>();
			for (int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				String c1=st.nextToken();
				String c2=st.nextToken();
				if (!adjList.containsKey(c1)) adjList.put(c1, new ArrayList<>());
				if (!adjList.containsKey(c2)) adjList.put(c2, new ArrayList<>());
				
				adjList.get(c1).add(c2);
				adjList.get(c2).add(c1);
			}
			
			if (testCase>0) System.out.println();
			for (int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				System.out.println(bfs(adjList,st.nextToken(),st.nextToken()));
			}
		}
	}
	
}