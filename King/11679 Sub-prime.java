import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int bankCount = Integer.parseInt(st.nextToken());
			int debenturesCount = Integer.parseInt(st.nextToken());
			int [] monRes = new int [bankCount];
			
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<bankCount;i++) {
				monRes[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i=0;i<debenturesCount;i++) {
				st=new StringTokenizer(br.readLine());
				int dBank=Integer.parseInt(st.nextToken())-1;
				int cBank=Integer.parseInt(st.nextToken())-1;
				int value=Integer.parseInt(st.nextToken());
				monRes[dBank]-=value;
				monRes[cBank]+=value;
			}
			
			boolean allPositive=true;
			for (int i=0;i<bankCount && allPositive;i++) {
				allPositive=(monRes[i]>=0);
			}
			
			if (allPositive) {
				System.out.println('S');
			} else {
				System.out.println('N');
			}
		}
	}
}