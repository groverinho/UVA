import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int E=Integer.parseInt(br.readLine());
		ArrayList<Integer> [] adj=new ArrayList [E];
		for (int i=0;i<E;i++) {
			adj[i]=new ArrayList<>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			for (int i2=0;i2<N;i2++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int T=Integer.parseInt(br.readLine());
		for (int i=0;i<T;i++) {
			int start=Integer.parseInt(br.readLine());
			
			boolean [] visited=new boolean [E];
			int [] eDepth=new int [E];
			int [] depthECount=new int [E];
			depthECount[0]=1;
			visited[start]=true;
			
			LinkedList<Integer> queue=new LinkedList<>();
			queue.add(start);
			while (!queue.isEmpty()) {
				int e=queue.removeFirst();
				for (int neighbour : adj[e]) if (!visited[neighbour]) {
					visited[neighbour]=true;
					eDepth[neighbour]=eDepth[e]+1;
					depthECount[eDepth[neighbour]]++;
					queue.addLast(neighbour);
				}
			}
			
			boolean isOnlySource=Arrays.stream(depthECount).sum()==1;
			if (isOnlySource) System.out.println("0");
			else {
				int maxBoom=Arrays.stream(depthECount).max().getAsInt();
				int day=-1;
				for (int i2=1;i2<E;i2++) if (depthECount[i2]==maxBoom) {
					day=i2;
					break;
				}
				
				System.out.println(maxBoom+" "+day);
			}
		}
	}
	
}