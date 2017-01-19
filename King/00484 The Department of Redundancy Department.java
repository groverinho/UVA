import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String,Integer> map=new HashMap<>();

		LinkedList<String> displayList=new LinkedList<>();
		
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			while (st.hasMoreTokens()) {
				s=st.nextToken();
				if (!map.containsKey(s)) displayList.add(s);
					
				map.put(s,map.getOrDefault(s,0)+1);
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (String num : displayList) {
			sb.append(num);
			sb.append(" ");
			sb.append(map.get(num));
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
}