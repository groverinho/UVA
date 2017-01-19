import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

class Main {

	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		HashMap<String,Integer> map=new HashMap<>();
		int idCount=1;
		LinkedList<String> stk=new LinkedList<>();
		stk.add("");
		//bfs
		while (!stk.isEmpty() && idCount<=83681) {
			String str=stk.removeFirst();
			if (str.length()>0) map.put(str,idCount++);

			if (str.length()<5) {
				int start='a';
				if (str.length()>0) start=str.charAt(str.length()-1)+1;
				for (;start<='z';start++) stk.addLast(str+((char)(start)+""));
			}
		}
		
		while ((s=br.readLine())!=null) {
			System.out.println(map.getOrDefault(s,0));
		}
	}
}