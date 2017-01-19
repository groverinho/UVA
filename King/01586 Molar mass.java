import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static ArrayList<String> tokenize (String s) {
		ArrayList<String> list=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		
		char lastC=0;
		for (char c : s.toCharArray()) {
			if (lastC==0) sb.append(c);
			else if (Character.isDigit(c)) sb.append(c);
			else if (Character.isAlphabetic(c)) {
				if (sb.length()!=0) {
					if (sb.length()==1) sb.append('1');
					list.add(sb.toString());
				}
				sb=new StringBuilder();
				sb.append(c);
			}
			lastC=c;
		}
		if (sb.length()==1) sb.append('1');
		list.add(sb.toString());
		
		return list;
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		double [] weight=new double[128];
		weight['C']=12.01;
		weight['H']=1.008;
		weight['O']=16.00;
		weight['N']=14.01;
		
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			ArrayList<String> list=tokenize(br.readLine());
			double totalWeight=0.0;
			
			for (String s : list) totalWeight+=(weight[s.charAt(0)]*Integer.parseInt(s.substring(1,s.length())));
			
			System.out.printf("%.3f\n",totalWeight);
		}
	}
}