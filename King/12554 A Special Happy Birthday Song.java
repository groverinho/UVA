import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] names=new String[Integer.parseInt(br.readLine())];
		for (int i=0;i<names.length;i++) {
			names[i]=br.readLine();
		}
		String [] words=new String [] {"Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"};
		StringBuilder sb=new StringBuilder();
		if (names.length<words.length) {
			for (int count=0;count<words.length;count++) {
				sb.append(names[count%names.length]);
				sb.append(": ");
				sb.append(words[count%words.length]);
				sb.append("\n");
			}
		} else {
			for (int count=0;count<names.length || (count>=names.length && count%words.length!=0);count++) {
				sb.append(names[count%names.length]);
				sb.append(": ");
				sb.append(words[count%words.length]);
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}