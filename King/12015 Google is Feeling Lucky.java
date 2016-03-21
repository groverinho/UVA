import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			String [] site=new String [10];
			int [] rating=new int [10];
			
			int maxRating=-Integer.MAX_VALUE;
			for (int i=0;i<10;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				site[i]=st.nextToken();
				rating[i]=Integer.parseInt(st.nextToken());
				
				maxRating=Math.max(maxRating, rating[i]);
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("Case #");
			sb.append(testCase);
			sb.append(":\n");
			for (int i=0;i<10;i++) {
				if (rating[i]==maxRating) {
					sb.append(site[i]);
					sb.append("\n");
				}
			}
			System.out.print(sb.toString());
		}
	}
}