import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine();
			int n=Integer.parseInt(br.readLine());
			boolean [][] mat=new boolean [n+1][n+1];
			for (int i=1;i<=n;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int p=Integer.parseInt(st.nextToken());
				for (int i2=0;i2<p && st.hasMoreTokens();i2++) {
					int next=Integer.parseInt(st.nextToken());
					if (next>=1 && next<=n) { //safety check. A person might be enemy of himself. (wth?)
						mat[i][next]=true;
						mat[next][i]=true;
					}
				}
			}
			
			int [] color=new int [n+1];
			Arrays.fill(color,Integer.MAX_VALUE);
			
			LinkedList<Integer> queue=new LinkedList<>();
			int count=0;
			for (int i=1;i<=n;i++) {
				if (color[i]==Integer.MAX_VALUE) {
					queue.add(i);
					color[i]=0;
					
					boolean flag=true;
					int [] tempC=new int [2];
					//we allow the visit of whole graph to ensure we don't visit the non-bipartite graph again.
					while (!queue.isEmpty()) {
						int id=queue.removeFirst();
						tempC[color[id]]++;
						for (int i2=1;i2<=n;i2++) {
							if (mat[id][i2]) {
								if (color[i2]==Integer.MAX_VALUE) {
									color[i2]=1-color[id];
									queue.addLast(i2);
								} else if (color[i2]==color[id]) {
									flag=false;
								}
							}
						}
					}
					if (flag) {
						count+=Math.max(tempC[0],tempC[1]);
					}
				}
			}
			
			System.out.println(count);
		}
	}
}