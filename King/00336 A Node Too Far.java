import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

class Main {

	//Depth limited breadth first search
	public static void dlbfs (HashMap<Integer,ArrayList<Integer>> adjacency, HashSet<Integer> unvisited, int src, int depth) {
		HashMap<Integer,Integer> nodeDepth=new HashMap<>();
		nodeDepth.put(src,0);
		LinkedList<Integer> queue=new LinkedList<>();
		queue.add(src);
		
		unvisited.remove(src);
		while (!queue.isEmpty()) {
			int currSrc=queue.removeFirst();
			int currDepth=nodeDepth.get(currSrc);
			
			if (currDepth<depth && adjacency.containsKey(currSrc)) {
				for (int neighbor : adjacency.get(currSrc)) {
					if (unvisited.contains(neighbor)) {
						unvisited.remove(neighbor);
						queue.addLast(neighbor);
						nodeDepth.put(neighbor, currDepth+1);
					}
				}
			}
		}
	}
	
	public static void main (String [] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int caseCount=1;
		while (sc.hasNext()) {
			int pairs=sc.nextInt();
			if (pairs==0) break;
			HashMap<Integer,ArrayList<Integer>> adjacency=new HashMap<>();
			HashSet<Integer> nodeSet=new HashSet<>();
			for (int i=0;i<pairs;i++) {
				int n1=sc.nextInt(); int n2=sc.nextInt();
				if (!adjacency.containsKey(n1)) adjacency.put(n1, new ArrayList<Integer>());
				if (!adjacency.containsKey(n2)) adjacency.put(n2, new ArrayList<Integer>());
				
				adjacency.get(n1).add(n2);
				adjacency.get(n2).add(n1);
				
				if (!nodeSet.contains(n1)) nodeSet.add(n1);
				if (!nodeSet.contains(n2)) nodeSet.add(n2);
			}
			
			while (true) {
				int src=sc.nextInt(); int depth=sc.nextInt();
				if (src==0 && depth==0) break;
				
				HashSet<Integer> remainingNodes=new HashSet<>();
				remainingNodes.addAll(nodeSet);
				dlbfs(adjacency,remainingNodes,src,depth);
				
				StringBuilder sb=new StringBuilder();
				sb.append("Case ");
				sb.append(caseCount++);
				sb.append(": ");
				sb.append(remainingNodes.size());
				sb.append(" nodes not reachable from node ");
				sb.append(src);
				sb.append(" with TTL = ");
				sb.append(depth);
				sb.append('.');
				System.out.println(sb.toString());
			}
		}
	}
	
}