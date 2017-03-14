import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Min {
	
	public static class TraverseData {
		String word;
		int depth;
		
		public TraverseData (String w, int d) {
			this.word=w;
			this.depth=d;
		}
	}
	
	public static boolean validAdjacency (String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		
		int diffCount=0;
		for (int i=0;i<s1.length();i++) if (s1.charAt(i)!=s2.charAt(i)) diffCount++;
		
		return diffCount==1;
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine();
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			ArrayList<String> words=new ArrayList<>();
			String word;
			while (!(word=br.readLine()).equals("*")) words.add(word);
			
			HashMap<String,ArrayList<String>> adjList=new HashMap<>();
			for (String s1 : words) for (String s2 : words) if (validAdjacency(s1,s2)) {
				if (!adjList.containsKey(s1)) adjList.put(s1, new ArrayList<>());
				adjList.get(s1).add(s2);
				
				if (!adjList.containsKey(s2)) adjList.put(s2, new ArrayList<>());
				adjList.get(s2).add(s1);
			}
			
			if (testCase>1) System.out.println();
			String query;
			while ((query=br.readLine())!=null && !query.isEmpty()) {
				StringTokenizer st=new StringTokenizer(query);
				String src=st.nextToken();
				String dest=st.nextToken();
				
				HashSet<String> visited=new HashSet<>();
				visited.add(src);
				
				LinkedList<TraverseData> queue=new LinkedList<>();
				queue.add(new TraverseData(src,0));
				
				int ans=-1;
				while (!queue.isEmpty()) {
					TraverseData dat=queue.removeFirst();
					
					if (dat.word.equals(dest)) {
						ans=dat.depth;
						break;
					} else if (adjList.containsKey(dat.word)){
						for (String neighbour : adjList.get(dat.word)) {
							if (!visited.contains(neighbour)) {
								visited.add(neighbour);
								queue.addLast(new TraverseData(neighbour,dat.depth+1));
							}
						}
					}
				}
				
				System.out.println(src+" "+dest+" "+ans);
			}
		}
	}
	
}