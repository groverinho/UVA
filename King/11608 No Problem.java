import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=1;
		while (true) {
			int [] qReady=new int [13];
			int [] qNeeded=new int [13];
			
			qReady[0]=Integer.parseInt(br.readLine());
			if (qReady[0]<0) break;
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i=1;i<13;i++) qReady[i]=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			for (int i=1;i<13;i++) qNeeded[i]=Integer.parseInt(st.nextToken());
			
			StringBuilder sb=new StringBuilder();
			sb.append("Case ");
			sb.append(testCase++);
			sb.append(":\n");
			for (int i=1;i<13;i++) {
				if (qNeeded[i]>qReady[i-1]) sb.append("No problem. :(\n");
				else {
					qReady[i-1]-=qNeeded[i];
					sb.append("No problem! :D\n");
				}
				qReady[i]+=qReady[i-1];
			}
			
			System.out.print(sb.toString());
		}
	}

}