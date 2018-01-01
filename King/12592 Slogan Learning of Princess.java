import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {

	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,String> map=new HashMap<>();
		int inCount=Integer.parseInt(br.readLine());
		for (int i=0;i<inCount;i++) map.put(br.readLine(), br.readLine());
		int tCount=Integer.parseInt(br.readLine());
		for (int i=0;i<tCount;i++) System.out.println(map.get(br.readLine()));
	}
}