import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

class Main {
	
	public static class Information implements Comparable<Information> {
		int charId;
		int frequency;
		
		public Information (char c) {
			this.charId=c;
		}
		
		public void addFrequency () {
			this.frequency++;
		}
		
		@Override
		public int compareTo(Information arg0) {
			if (this.frequency!=arg0.frequency) return this.frequency-arg0.frequency;
			return arg0.charId-this.charId;
		}
		
	}
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s; int testCase=0;
		
		while ((s=br.readLine())!=null) {
			HashMap<Character,Information> map=new HashMap<>();
			for (char c : s.toCharArray()) {
				if (!map.containsKey(c)) map.put(c,new Information(c));
				map.get(c).addFrequency();
			}
			
			if (testCase>0) System.out.println();
			
			TreeSet<Information> set=new TreeSet<>();
			set.addAll(map.values());
			
			StringBuilder sb=new StringBuilder();
			for (Information i : set) {
				sb.append(i.charId);
				sb.append(' ');
				sb.append(i.frequency);
				sb.append('\n');
			}
			System.out.print(sb.toString());
			testCase++;
		}
	}
}