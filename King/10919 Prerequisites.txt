import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("0")) {
			StringTokenizer st=new StringTokenizer(s);
			int noCourse=Integer.parseInt(st.nextToken());
			int noCategory=Integer.parseInt(st.nextToken());

			//taken = 1, not taken = 0. :D
			int [] courseTaken = new int [10001];
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<noCourse;i++) {
				courseTaken[Integer.parseInt(st.nextToken())]=1;
			}
			
			boolean ok=true;
			for (int i=0;i<noCategory;i++) {
				st=new StringTokenizer(br.readLine());
				int categoryCrsCount=Integer.parseInt(st.nextToken());
				int min=Integer.parseInt(st.nextToken());
				
				int curr=0;
				for (int i2=0;i2<categoryCrsCount;i2++) {
					curr+=courseTaken[Integer.parseInt(st.nextToken())];
				}
				
				ok=(ok && curr>=min);
			}
			
			if (ok) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}