import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Main {

	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine();//empty
		
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			HashMap<String,Integer> map=new HashMap<>();
			ArrayList<String> displayList=new ArrayList<>();
			
			double total=0;
			String s;
			while ((s=br.readLine())!=null && !s.isEmpty()) {
				if (!map.containsKey(s)) displayList.add(s);	
				map.put(s,map.getOrDefault(s,0)+1);
				total++;
			}
			
			Collections.sort(displayList);
			StringBuilder sb=new StringBuilder();
			for (String tree : displayList) sb.append(String.format("%s %.4f\n",tree,(map.get(tree)/total)*100.0));
			if (testCase<testCaseCount-1) System.out.println(sb.toString());
			else System.out.print(sb.toString());
		}

	}
}