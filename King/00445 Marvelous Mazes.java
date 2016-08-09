import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args)  throws IOException {  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while ((s=br.readLine())!=null) {
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				if (c=='!') {
					sb.append("\n");
				} else if (c>='1' && c<='9') {
					int searchNext=i+1;
					int counter=(c-'0');
					while (s.charAt(searchNext)>='1' && s.charAt(searchNext)<='9') {
						counter=counter+(s.charAt(searchNext)-'0');
						searchNext++;
					}
					
					char c2=s.charAt(searchNext);
					char charToFill=c2;
					if (c2=='b') {
						charToFill=' ';
					}
					for (int i2=0;i2<counter;i2++) {
						sb.append(charToFill);
					}
					i=searchNext;
				}
			}
			System.out.println(sb.toString());
		}
	}  
}