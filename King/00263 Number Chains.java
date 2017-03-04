import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {
	
	public static int ascending (int num) {
		int [] count=new int [10];
		while (num>0) {
			count[num%10]++;
			num/=10;
		}
		
		int toReturn=0;
		for (int i=0;i<10;i++) {
			while (count[i]>0) {
				toReturn=toReturn*10+i;
				count[i]--;
			}
		}
		return toReturn;
	}
	
	public static int descending (int num) {
		int [] count=new int [10];
		while (num>0) {
			count[num%10]++;
			num/=10;
		}
		
		int toReturn=0;
		for (int i=9;i>=0;i--) {
			while (count[i]>0) {
				toReturn=toReturn*10+i;
				count[i]--;
			}
		}
		return toReturn;
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("0")) {
			int num=Integer.parseInt(s);
			int result=num;
			HashSet<Integer> set=new HashSet<>();
			
			StringBuilder sb=new StringBuilder("Original number was ");
			sb.append(num);
			sb.append("\n");
			while (true) {
				int n1=ascending(result);
				int n2=descending(result);
				int n3=n2-n1;
				sb.append(n2);
				sb.append(" - ");
				sb.append(n1);
				sb.append(" = ");
				sb.append(n3);
				sb.append("\n");
				
				if (set.contains(n3)) break;
				else {
					result=n3;
					set.add(result);
				}
			}
			sb.append("Chain length ");
			sb.append(set.size()+1);
			sb.append("\n");
			
			System.out.println(sb.toString());
		}
	}
	
}