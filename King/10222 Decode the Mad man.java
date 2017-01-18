import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException {
		String [] lines={"qwertyuiop[]\\","asdfghjkl;'","zxcvbnm,./"};
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;

		while ((s=br.readLine())!=null) {
			StringBuilder sb=new StringBuilder();
			for (char c : s.toLowerCase().toCharArray()) {
				if (c==' ') sb.append(' ');
				else {
					String check=c+"";
					for (int i=0;i<lines.length;i++) {
						if (lines[i].contains(check)) {
							int index=(lines[i].indexOf(check)-2)%lines[i].length();
							sb.append(lines[i].substring(index,index+1));
							break;
						}
					}
				}
			}
			System.out.println(sb.toString());
		}


	}
}