import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void permutate (int [] v, int [] set, boolean [] flag, int min, int level, StringBuilder sb) {
		if (level==6) {
			for (int i=0;i<v.length;i++) {
				sb.append(v[i]);
				if (i<v.length-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		} else {
			for (int i=min;i<set.length;i++) {
				if (!flag[i]) {
					flag[i]=true;
					v[level]=set[i];
					permutate(v,set,flag,i+1,level+1,sb);
					flag[i]=false;
				}
			}
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int count=0;
		while (!(s=br.readLine()).equals("0")) {
			StringTokenizer st=new StringTokenizer(s);
			int [] values=new int [Integer.parseInt(st.nextToken())];
			for (int i=0;i<values.length;i++) {
				values[i]=Integer.parseInt(st.nextToken());
			}
			StringBuilder sb=new StringBuilder();
			permutate(new int[6],values,new boolean [values.length],0,0,sb);
			if (count>0) {
				System.out.println();
			}
			System.out.print(sb);
			count++;
		}
	}
}