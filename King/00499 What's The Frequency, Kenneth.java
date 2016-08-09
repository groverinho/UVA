import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args)  throws IOException {  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int [] charCount=new int [128];
			int charCountMax=0;
			for (int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				if (Character.isAlphabetic(c)) {
					charCount[c]++;
					charCountMax=Math.max(charCountMax, charCount[s.charAt(i)]);
				}
			}
			
			StringBuilder sb=new StringBuilder();
			for (int i='A';i<='Z';i++) {
				if (charCount[i]==charCountMax) {
					sb.append((char)i);
				}
			}
			for (int i='a';i<='z';i++) {
				if (charCount[i]==charCountMax) {
					sb.append((char)i);
				}
			}
			sb.append(" ");
			sb.append(charCountMax);
			System.out.println(sb.toString());
		}
	}  
}