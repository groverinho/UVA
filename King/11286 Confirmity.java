import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")){
			int n=Integer.parseInt(s);
			HashMap<String,Integer> map=new HashMap<>();

			for (int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				TreeSet<String> set=new TreeSet<>();
				for (int i2=0;i2<5;i2++) set.add(st.nextToken());
				String key=set.toString();
				map.put(key, map.getOrDefault(key,0)+1);
			}
			
			int max=Collections.max(map.values());
			System.out.println(map.values().stream().filter(i -> i == max).count()*max);
		}
	}

}