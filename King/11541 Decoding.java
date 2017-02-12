import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			String s=br.readLine();
			ArrayList<Integer> list=new ArrayList<>();
			for (int i=0;i<s.length();i++) if (Character.isAlphabetic(s.charAt(i))) list.add(i);
			list.add(s.length());
			
			StringBuilder ans=new StringBuilder();
			ans.append("Case ");
			ans.append(testCase);
			ans.append(": ");
			for (int i=0;i<list.size()-1;i++) {
				String code=s.substring(list.get(i),list.get(i+1));
				char c=code.charAt(0);
				int count=Integer.parseInt(code.substring(1));
				for (int i2=0;i2<count;i2++) ans.append(c);
			}
			
			System.out.println(ans.toString());
		}
	}
}