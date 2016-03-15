import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int durationCount=Integer.parseInt(br.readLine());
			int mileCost = 0;
			int juiceCost = 0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int i=0;i<durationCount;i++) {
				int duration=Integer.parseInt(st.nextToken());
				mileCost+=((duration/30)+1)*10;
				juiceCost+=((duration/60)+1)*15;
			}
			
			StringBuilder sb=new StringBuilder("Case "+testCase+": ");
			if (mileCost<juiceCost) {
				sb.append("Mile ");
				sb.append(mileCost);
			} else if (juiceCost<mileCost) {
				sb.append("Juice ");
				sb.append(juiceCost);
			} else {
				sb.append("Mile Juice ");
				sb.append(mileCost);
			}
			System.out.println(sb);
		}
	}
}