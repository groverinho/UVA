import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=1;
		String s;
		HashMap<String,String> map=new HashMap<>();
		map.put("Hajj", "Hajj-e-Akbar");
		map.put("Umrah", "Hajj-e-Asghar");
		while ((s=br.readLine())!=null && !s.equals("*")) {
			System.out.println("Case "+(testCase++)+": "+map.get(s));
		}
	}
}