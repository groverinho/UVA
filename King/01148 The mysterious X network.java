import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine(); //blank
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int N=Integer.parseInt(br.readLine());
			ArrayList<Integer> [] adjList=new ArrayList [N];
			for (int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				if (adjList[src]==null) adjList[src]=new ArrayList<>();
				
				int c=Integer.parseInt(st.nextToken());
				for (int i2=0;i2<c;i2++) {
					int dest=Integer.parseInt(st.nextToken());
					if (adjList[dest]==null) adjList[dest]=new ArrayList<>();
					
					adjList[src].add(dest);
					adjList[dest].add(src);
				}
			}
			
			if (testCase>0) System.out.println();
			
			String query;
			while ((query=br.readLine())!=null && !query.isEmpty()) {
				StringTokenizer st=new StringTokenizer(query);
				int src=Integer.parseInt(st.nextToken());
				int dest=Integer.parseInt(st.nextToken());
				int [] hopCount=new int [N];
				Arrays.fill(hopCount, -1);
				
				Queue<Integer> queue=new ArrayDeque<Integer>();
				
				queue.offer(src);
				hopCount[src]=0;
				
				while (!queue.isEmpty()) {
					int curr=queue.poll();
					if (curr==dest) break;
					else {
						for (int next : adjList[curr]) if (hopCount[next]==-1) {
							queue.offer(next);
							hopCount[next]=hopCount[curr]+1;
						}
					}
				}
				
				System.out.println(src+" "+dest+" "+(hopCount[dest]-1));
			}
		}
	}
	
}