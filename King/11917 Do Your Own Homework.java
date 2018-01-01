import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int c=Integer.parseInt(br.readLine());
			HashMap<String,Integer> map=new HashMap<>();
			for (int i=0;i<c;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
			int d=Integer.parseInt(br.readLine());
			String target=br.readLine();
			if (!map.containsKey(target) || map.get(target)>d+5) System.out.println("Case "+testCase+": Do your own homework!");
			else if (map.get(target)>d) System.out.println("Case "+testCase+": Late");
			else System.out.println("Case "+testCase+": Yesss");
		}
	}

}