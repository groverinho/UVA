import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			PriorityQueue<Integer> num=new PriorityQueue<>();
			int N=Integer.parseInt(s);
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) num.offer(Integer.parseInt(st.nextToken()));
			
			int totalCost=0;
			while (!num.isEmpty()) {
				int cost=num.poll();
				if (!num.isEmpty()) {
					cost+=num.poll();
					totalCost+=cost;
					num.offer(cost);
				}
			}
			
			System.out.println(totalCost);
		}
		
	}
}