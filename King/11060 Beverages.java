import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int t=1;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			String [] name=new String [n];
			HashMap<String,Integer> nameToId=new HashMap<>();
			for (int i=0;i<name.length;i++) {
				name[i]=br.readLine();
				nameToId.put(name[i], i);
			}
			
			boolean [][] mat=new boolean [n][n];
			int [] incomingDegree=new int [n];
			int m=Integer.parseInt(br.readLine());
			for (int i=0;i<m;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				String prev=st.nextToken();
				String next=st.nextToken();
				if (!mat[nameToId.get(prev)][nameToId.get(next)]) {
					//Judge's dataset contains duplicated pairs of wine. :/
					//Put this check to ensure incoming degree count is correct.
					mat[nameToId.get(prev)][nameToId.get(next)]=true;
					incomingDegree[nameToId.get(next)]++;
				}
			}
			
			//Kahn's Algorithm for topological sort.
			PriorityQueue<Integer> queue=new PriorityQueue<>();
			for (int i=0;i<n;i++) {
				if (incomingDegree[i]==0) {
					queue.offer(i);
				}
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("Case #");
			sb.append(t++);
			sb.append(": Dilbert should drink beverages in this order:");
			
			while (!queue.isEmpty()) {
				int id=queue.poll();
				sb.append(" ");
				sb.append(name[id]);
				for (int i=0;i<n;i++) {
					if (mat[id][i]) {
						if (--incomingDegree[i]==0) {
							queue.offer(i);
						}
					}
				}
			}
			
			sb.append(".\n\n");
			System.out.print(sb.toString());
			br.readLine(); //blank
		}
	}
}