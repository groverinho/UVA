import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		br.readLine(); //useless line. X)
		
		String s;
		StringBuilder sb=new StringBuilder();
		while (!(s=br.readLine()).equals("___________")) {
			s=s.replaceAll("|","");
			StringBuilder binary=new StringBuilder();
			for (char c : s.toCharArray()) if (c==' ') binary.append('0'); else if (c=='o') binary.append('1');
			sb.append((char)Integer.parseInt(binary.toString(),2));
		}
		System.out.print(sb.toString());
	}
}