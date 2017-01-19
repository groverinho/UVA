import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {

	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,String> map=new HashMap<>();
		
		String s;
		while ((s=br.readLine())!=null && !s.isEmpty()) {
			String [] split=s.split(" ");
			map.put(split[1],split[0]);
		}

		while ((s=br.readLine())!=null) System.out.println(map.getOrDefault(s,"eh"));
	}
}