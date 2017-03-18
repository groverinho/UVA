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
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			
			ArrayList<Character> [] adjList=new ArrayList [128];
			double [] nodeValue=new double [128];
			for (int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				char src=st.nextToken().charAt(0);
				nodeValue[src]=Double.parseDouble(st.nextToken());
				
				if (adjList[src]==null) adjList[src]=new ArrayList<>();
				for (char dest : st.nextToken().toCharArray()) {
					adjList[src].add(dest);
					if (adjList[dest]==null) adjList[dest]=new ArrayList<>();
					adjList[dest].add(src);
				}
			}

			int [] hopCount=new int [128];
			Arrays.fill(hopCount,-1);
			Queue<Character> queue=new ArrayDeque<>();
			
			queue.offer('*');
			hopCount['*']=1;
			
			while (!queue.isEmpty()) {
				char curr=queue.poll();
				for (char next : adjList[curr]) if (hopCount[next]==-1) {
					queue.offer(next);
					hopCount[next]=hopCount[curr]+1;
				}
			}
			
			for (char c='A';c<='Z';c++) {
				if (hopCount[c]!=-1) nodeValue[c]=nodeValue[c]*Math.pow(0.95,hopCount[c]-2);
			}
			
			char maxChar='*';
			for (char c='A';c<='Z';c++) if (hopCount[c]!=-1 && nodeValue[c]>nodeValue[maxChar]) maxChar=c;
			
			System.out.println("Import from "+maxChar);
		}
	}
	
}