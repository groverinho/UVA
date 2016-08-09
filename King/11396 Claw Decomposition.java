import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n=Integer.parseInt(br.readLine());
			if (n==0) {
				break;
			}
			boolean [][] mat=new boolean [n+1][n+1];
			int [] color=new int [n+1];
			Arrays.fill(color, Integer.MAX_VALUE);
			while (true) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken());
				int dest=Integer.parseInt(st.nextToken());
				if (src==0 && dest==0) {
					break;
				}
				mat[src][dest]=true;
				mat[dest][src]=true;
			}
			
			boolean flag=true;
			LinkedList<Integer> queue=new LinkedList<>();
			for (int i=1;i<=n;i++) {
				if (color[i]==Integer.MAX_VALUE) {
					queue.add(i);
					color[i]=0;
					
					while (!queue.isEmpty() && flag) {
						int id=queue.removeFirst();
						for (int i2=1;i2<=n;i2++) {
							if (mat[id][i2]) {
								if (color[i2]==Integer.MAX_VALUE) {
									color[i2]=1-color[id];
									queue.addLast(i2);
								} else if (color[i2]!=1-color[id]) {
									flag=false;
									break;
								}
							}
						}
					}
				}
			}
			
			if (flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}