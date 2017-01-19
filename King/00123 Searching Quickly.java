import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Main {
	
	public static class Sentence implements Comparable<Sentence>{
		private String str;
		private String keyword;
		private int position;
		
		public Sentence (String s, String k, int pos) {
			this.keyword=k;
			this.str=s;
			this.position=pos;
		}
		
		public String toString () {
			return this.str;
		}
		
		public int compareTo(Sentence s) {
			int v=this.keyword.compareTo(s.keyword);
			if (v==0) {
				v=this.position-s.position;
			}
			return v;
		}
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> toIgnore=new HashSet<>();
		String s;
		while (!(s=br.readLine()).equals("::")) toIgnore.add(s.toLowerCase());
		
		int lineCount=0;
		ArrayList<Sentence> list=new ArrayList<>();
		while ((s=br.readLine())!=null && !s.isEmpty()) {
			String [] split=s.split(" ");
			for (int i=0;i<split.length;i++) {
				if (!toIgnore.contains(split[i].toLowerCase())) {
					StringBuilder sb=new StringBuilder();
					
					for (int i2=0;i2<i;i2++) {
						sb.append(split[i2].toLowerCase());
						sb.append(" ");
					}
					sb.append(split[i].toUpperCase());
					if (i<split.length-1) sb.append(" ");
					for (int i2=i+1;i2<split.length;i2++) {
						sb.append(split[i2].toLowerCase());
						if (i2<split.length-1) sb.append(" ");
					}
					
					
					list.add(new Sentence(sb.toString(),split[i].toUpperCase(),lineCount));
				}
			}
			lineCount++;
		}
		Collections.sort(list);
		
		for (Sentence sen : list) System.out.println(sen.toString());
	}
}