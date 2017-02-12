import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			if (s.length()==0) System.out.println();
			else if (Character.isDigit(s.charAt(0))) {
				String inverted=new StringBuilder(s).reverse().toString();
				ArrayList<Integer> list=new ArrayList<>();
				int index=0;
				while (index<inverted.length()) {
					if (inverted.charAt(index)=='1') {
						list.add(Integer.parseInt(inverted.substring(index,index+3)));
						index+=3;
					} else {
						list.add(Integer.parseInt(inverted.substring(index,index+2)));
						index+=2;
					}
				}
				StringBuilder sb=new StringBuilder();
				for (int i : list) sb.append((char)i);
				System.out.println(sb.toString());
			} else {
				StringBuilder sb=new StringBuilder();
				for (char c : s.toCharArray()) sb.append((int)c);
				sb=sb.reverse();
				System.out.println(sb.toString());
			}
		}
	}
}