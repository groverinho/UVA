import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	
	public static ArrayList<String> tokenize (String s) {
		ArrayList<String> list=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) sb.append(c);
			else if (sb.length()>0) {
				list.add(sb.toString());
				sb=new StringBuilder();
			}
		}
		
		if (sb.length()>0) list.add(sb.toString());
		return list;
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=1;
		
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int K=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			
			HashSet<String> keywords=new HashSet<>();
			for (int i=0;i<K;i++) keywords.add(br.readLine());
			
			String [] sentence=new String[E];
			int [] occurence=new int [E];
			for (int i=0;i<E;i++) {
				sentence[i]=br.readLine();
				ArrayList<String> words=tokenize(sentence[i].toLowerCase());
				for (String word : words) if (keywords.contains(word)) occurence[i]++;
			}
			
			System.out.println("Excuse Set #"+testCase++);
			int max=Arrays.stream(occurence).max().getAsInt();
			for (int i=0;i<E;i++) if (occurence[i]==max) System.out.println(sentence[i]);
			System.out.println();
		}
	}
}