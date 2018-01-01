import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

class Main {
	
	public static String normalize (String s) {
		char [] c=s.replaceAll("-","").toCharArray();
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<c.length;i++) {
			if (i==3) sb.append('-');
			if (Character.isAlphabetic(c[i])) {
				if (c[i]>'Q') c[i]--;
				sb.append(((c[i]-'A')/3)+2);
			}
			else sb.append(c[i]);
		}
		return sb.toString();
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine();
			int N=Integer.parseInt(br.readLine());
			TreeMap<String,Integer> map=new TreeMap<>();
			
			for (int n=0;n<N;n++) {
				String key=normalize(br.readLine());
				map.put(key, map.getOrDefault(key,0)+1);
			}
			
			for (String key : map.keySet().toArray(new String [map.keySet().size()])) if (map.get(key)==1) map.remove(key);
			
			StringBuilder sb=new StringBuilder();
			if (testCase>0) sb.append('\n');
			if (map.keySet().size()==0) sb.append("No duplicates.\n");
			else {
				for (String key : map.keySet()) {
					sb.append(key);
					sb.append(' ');
					sb.append(map.get(key));
					sb.append('\n');
				}
			}
			System.out.print(sb.toString());
		}
	}

}