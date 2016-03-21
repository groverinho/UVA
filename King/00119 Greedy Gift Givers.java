import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=0;
		while ((s=br.readLine())!=null) {
			int namesCount=Integer.parseInt(s);
			HashMap<String,Integer> map=new HashMap<>();
			String [] names=new String[namesCount];
			
			StringTokenizer st=new StringTokenizer (br.readLine());
			for (int i=0;i<namesCount;i++) {
				names[i]=st.nextToken();
				map.put(names[i], 0);
			}
			
			for (int i=0;i<namesCount;i++) {
				st=new StringTokenizer(br.readLine());
				String giver=st.nextToken();
				int amount=Integer.parseInt(st.nextToken());
				int receiverCount=Integer.parseInt(st.nextToken());
				if (receiverCount>0 && amount>=receiverCount) {
					int amountPerPerson=amount/receiverCount;
					map.put(giver, map.get(giver)-(amountPerPerson*receiverCount));
					
					for (int i2=0;i2<receiverCount;i2++) {
						String name=st.nextToken();
						map.put(name, map.get(name)+amountPerPerson);
					}
				}
			}
			
			StringBuilder sb=new StringBuilder();
			if (testCase>0) {
				sb.append("\n");
			}
			for (int i=0;i<names.length;i++) {
				sb.append(names[i]);
				sb.append(" ");
				sb.append(map.get(names[i]));
				sb.append("\n");
			}
			System.out.print(sb.toString());
			testCase++;
		}
	}
}