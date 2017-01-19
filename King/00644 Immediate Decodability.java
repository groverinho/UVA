import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		int testCase=1;
		while ((s=br.readLine())!=null) {
			ArrayList<String> list=new ArrayList<>();
			do list.add(s); while (!(s=br.readLine()).equals("9"));
			
			Collections.sort(list);
			
			boolean fail=false;
			for (int i=0;i<list.size()-1 && !fail;i++)
				if (list.get(i+1).startsWith(list.get(i))) fail=true;
			
			if (fail) System.out.println("Set "+testCase+++" is not immediately decodable");
			else System.out.println("Set "+testCase+++" is immediately decodable");
		}
	}
}