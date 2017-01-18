import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int [] values=new int [128];
		values['B']=1; values['F']=1; values['P']=1; values['V']=1;
		values['C']=2; values['G']=2; values['J']=2; values['K']=2;
		values['Q']=2; values['S']=2; values['X']=2; values['Z']=2;
		values['D']=3; values['T']=3;
		values['L']=4;
		values['M']=5; values['N']=5;
		values['R']=6;
		
		String s;
		
		while ((s=br.readLine())!=null) {
			ArrayList<Integer> ans=new ArrayList<>();
			ans.add(values[s.charAt(0)]);
			
			for (int i=1;i<s.length();i++)
				if (values[s.charAt(i)]!=ans.get(ans.size()-1)) ans.add(values[s.charAt(i)]);
			
			StringBuilder sb=new StringBuilder();
			for (int i : ans) if (i!=0) sb.append(i);
			
			System.out.println(sb.toString());
		}
	}
}