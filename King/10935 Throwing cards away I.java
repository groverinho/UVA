import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int N=Integer.parseInt(s);
			Queue<Integer> deck=new LinkedList<>();
			for (int i=1;i<=N;i++) deck.offer(i);
			
			Queue<Integer> ans=new LinkedList<>();
			
			while (deck.size()>=2) {
				ans.offer(deck.poll());
				deck.offer(deck.poll());
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("Discarded cards:");
			if (ans.size()>0) sb.append(" ");
			while (ans.size()>0) {
				sb.append(ans.poll());
				if (ans.size()>0) sb.append(", ");
			}
			sb.append("\nRemaining card: ");
			sb.append(deck.poll());
			System.out.println(sb.toString());
		}
	}
}