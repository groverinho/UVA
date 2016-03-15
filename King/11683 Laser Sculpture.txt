import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int a=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int [] values=new int [c];
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<values.length;i++) {
				values[i]=Integer.parseInt(st.nextToken());
			}
			
			int cutCount=0;
			int last=a;
			for (int i=0;i<values.length;i++) {
				if (values[i]<last) {
					cutCount+=(last-values[i]);
				}
				last=values[i];
			}
			
			System.out.println(cutCount);
		}
	}
}