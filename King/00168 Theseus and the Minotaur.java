import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;

		while (!(s=br.readLine()).equals("#")) {
			StringTokenizer st=new StringTokenizer(s,".");
			StringTokenizer st2=new StringTokenizer(st.nextToken(),";");
			
			int [][] adjacencyList=new int [26][26];
			int [] adjacencyListCount=new int [26];
			boolean [] candle=new boolean [26];
			while (st2.hasMoreTokens()) {
				StringTokenizer st3=new StringTokenizer(st2.nextToken(),":");
				int src=st3.nextToken().charAt(0)-'A';
				if (st3.hasMoreTokens()) {
					for (char dest : st3.nextToken().toCharArray()) {
						adjacencyList[src][adjacencyListCount[src]++]=dest-'A';
					}
				}
			}
			
			StringTokenizer st3=new StringTokenizer(st.nextToken());
			int mStart=st3.nextToken().charAt(0)-'A';
			int tStart=st3.nextToken().charAt(0)-'A';
			int k=Integer.parseInt(st3.nextToken());
			
			StringBuilder sb=new StringBuilder();
			int count=0;
			while (true) {
				int temp=mStart;
				for (int i=0;i<adjacencyListCount[mStart];i++) {
					int next=adjacencyList[mStart][i];
					if (next!=tStart && !candle[next]) {
						mStart=next;
						break;
					}
				}
				tStart=temp;
				
				if (tStart==mStart) {
					sb.append('/');
					sb.append((char)(mStart+'A'));
					break;
				}
				
				count=(count+1)%k;
				if (count==0) {
					sb.append((char)(tStart+'A'));
					sb.append(" ");
					candle[tStart]=true;
				}
			}
			System.out.println(sb.toString());
		}
	}
	
}