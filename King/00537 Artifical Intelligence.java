import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	private static String [] keywords={"P=","U=","I="};
	private static String [] unit={"W","V","A"};
	
	public static String [] tokenize (String s) {
		ArrayList<String> list=new ArrayList<>();
		for (int i=0;i<keywords.length;i++) {
			int lastIndex=-1;
			do {
				lastIndex=s.indexOf(keywords[i],lastIndex+1);
				if (lastIndex!=-1) list.add(s.substring(lastIndex, s.indexOf(unit[i],lastIndex)+1));
			} while (lastIndex!=-1);
		}
		
		return list.toArray(new String [list.size()]);
	}
	
	public static int searchContains(String [] str, String target) {
		for (int i=0;i<str.length;i++) if (str[i].startsWith(target)) return i;
		
		return -1;
	}
	
	public static double parse (String s, String header) {
		s=s.replaceAll(header,"");
		s=s.substring(0,s.length()-1);
		char c=s.charAt(s.length()-1);
		
		double factor=1.0;
		if (!Character.isDigit(c)) {
			if (c=='m') factor=0.001;
			else if (c=='k') factor=1000;
			else if (c=='M') factor=1000000;
			
			s=s.substring(0,s.length()-1);
		}
		
		return Double.parseDouble(s)*factor;
	}
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			String [] split=tokenize(br.readLine());
			int indexU=searchContains(split,"U=");
			int indexI=searchContains(split,"I=");
			int indexP=searchContains(split,"P=");
			
			StringBuilder sb=new StringBuilder("Problem #");
			sb.append(testCase);
			sb.append('\n');
			if (indexU==-1) {
				sb.append("U=");
				sb.append(String.format("%.2fV",parse(split[indexP],"P=")/parse(split[indexI],"I=")));
			} else if (indexI==-1) {
				sb.append("I=");
				sb.append(String.format("%.2fA",parse(split[indexP],"P=")/parse(split[indexU],"U=")));
			} else if (indexP==-1) {
				sb.append("P=");
				sb.append(String.format("%.2fW",parse(split[indexU],"U=")*parse(split[indexI],"I=")));
			}
			sb.append('\n');
			
			System.out.println(sb.toString());
		}
	}
	
}
