import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static void print(int i, boolean flag) {
		if (flag) System.out.println("Guess #"+i+" was correct.");
		else System.out.println("Guess #"+i+" was incorrect.");
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int p=Integer.parseInt(st.nextToken());
		int g=Integer.parseInt(st.nextToken());
		HashMap<String,BigDecimal> map=new HashMap<>();
		for (int i=0;i<p;i++) {
			st=new StringTokenizer(br.readLine());
			map.put(st.nextToken(), new BigDecimal(st.nextToken()));
		}
		for (int i=1;i<=g;i++) {
			st=new StringTokenizer(br.readLine());
			ArrayList<String> list=new ArrayList<>();
			while (st.hasMoreTokens()) {
				String s=st.nextToken();
				if (!s.equals("+")) list.add(s);
			}
			BigDecimal value=BigDecimal.ZERO;
			for (int i2=0;i2<list.size()-2;i2++) value=value.add(map.get(list.get(i2)));
			BigDecimal rhsValue=new BigDecimal(list.get(list.size()-1));
			int compare=value.compareTo(rhsValue);
			switch (list.get(list.size()-2)) {
				case "<":	print(i,compare<0);
							break;
				case ">":	print(i,compare>0);
							break;
				case "<=":	print(i,compare<=0);
							break;
				case ">=":	print(i,compare>=0);
							break;
				case "=":	print(i,compare==0);
							break;
			}
		}
	}

}