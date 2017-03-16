import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine(); //empty.
			StringTokenizer st=new StringTokenizer(br.readLine());
			int P=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			
			HashSet<Integer> [] adjList=new HashSet [P];
			for (int i=0;i<adjList.length;i++) adjList[i]=new HashSet<>();
			
			for (int i=0;i<D;i++) {
				st=new StringTokenizer(br.readLine());
				int p1=Integer.parseInt(st.nextToken());
				int p2=Integer.parseInt(st.nextToken());
				
				if (!adjList[p1].contains(p2)) adjList[p1].add(p2);
				if (!adjList[p2].contains(p1)) adjList[p2].add(p1);
			}
			
			Queue<Integer> queue=new ArrayDeque<>();
			int [] gN=new int [P];
			Arrays.fill(gN,-1);
			
			queue.add(0);
			gN[0]=0;
			
			while (!queue.isEmpty()) {
				int curr=queue.poll();
				for (int next : adjList[curr]) if (gN[next]==-1) {
					queue.add(next);
					gN[next]=gN[curr]+1;
				}
			}
			
			if (testCase>0) System.out.println();
			for (int i=1;i<gN.length;i++) System.out.println(gN[i]);
		}
	}
	
}
