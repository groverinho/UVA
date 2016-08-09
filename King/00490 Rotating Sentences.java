import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static void main(String[] args)  throws IOException {  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<char []> list=new ArrayList<>();
		String s;
		
		int maxLength=0;
		while ((s=br.readLine())!=null) {
			if (s.equals("")) {
				break;
			}
			list.add(s.toCharArray());
			maxLength=Math.max(maxLength, s.length());
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<maxLength;i++) {
			for (int i2=list.size()-1;i2>=0;i2--) {
				if (i<list.get(i2).length) {
					sb.append(list.get(i2)[i]);
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}  
}