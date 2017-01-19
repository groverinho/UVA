import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

class Main {

	public static ArrayList<String> tokenize (String s) {
		StringBuilder sb=new StringBuilder();
		ArrayList<String> toReturn=new ArrayList<>();
		for (char c : (s+" ").toLowerCase().toCharArray()) {
			if (Character.isAlphabetic(c)) sb.append(c);
			else if (sb.length()>0) {
				toReturn.add(sb.toString());
				sb=new StringBuilder();
			}
		}
		return toReturn;
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		HashSet<String> set=new HashSet<>();
		PriorityQueue<String> queue=new PriorityQueue<>();
		
		while ((s=br.readLine())!=null) {
			ArrayList<String> list=tokenize(s);
			for (String word : list) {
				if (!set.contains(word)) {
					set.add(word);
					queue.offer(word);
				}
			}
		}
		
		while (!queue.isEmpty()) System.out.println(queue.poll());
	}
}