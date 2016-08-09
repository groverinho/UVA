import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static class Value implements Comparable<Value> {
		char ch;
		int count;
		
		public int compareTo (Value v) {
			int diffCount=v.count-this.count;
			if (diffCount!=0) {
				return diffCount;
			}
			return this.ch-v.ch;
		}
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int line=Integer.parseInt(br.readLine());
		Value [] count=new Value [128];
		for (int i=0;i<count.length;i++) {
			count[i]=new Value();
			count[i].ch=(char)i;
		}
		for (int l=0;l<line;l++) {
			String s=br.readLine();
			for (int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				if (Character.isAlphabetic(c)) {
					count[Character.toUpperCase(c)].count++;
				}
			}
		}
		
		Arrays.sort(count);
		for (int i=0;i<count.length;i++) {
			if (count[i].count==0) {
				break;
			}
			System.out.println(count[i].ch+" "+count[i].count);
		}
	}    
}