import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken()); int n=Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> map=new HashMap<>();
		for (int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			map.put(st.nextToken(),Integer.parseInt(st.nextToken()));
		}
		
		for (int i=0;i<n;i++) {
			int value=0;
			String s;
			while (!(s=br.readLine()).equals(".")) 
				for (String word : s.split(" "))value+=map.getOrDefault(word,0);
			System.out.println(value);
		}
	}
}