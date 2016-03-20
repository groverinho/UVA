import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int [] to=new int [101];
			for (int i=0;i<to.length;i++) {
				to[i]=i;
			}
			for (int i=0;i<b;i++) {
				st=new StringTokenizer(br.readLine());
				int v1=Integer.parseInt(st.nextToken());
				int v2=Integer.parseInt(st.nextToken());
				to[v1]=v2;
			}
			int [] pPos=new int [a];
			Arrays.fill(pPos, 1);
			boolean stop=false;
			for (int i=0;i<c;i++) {
				int value=Integer.parseInt(br.readLine());
				if (!stop) {
					pPos[i%a]=pPos[i%a]+value;
					if (pPos[i%a]>=100) {
						pPos[i%a]=100;
						stop=true;
					} else {
						int pId=i%a;
						while (pPos[pId]!=to[pPos[pId]]) {
							pPos[pId]=to[pPos[pId]];
						}
						if (pPos[i%a]>=100) {
							pPos[i%a]=100;
							stop=true;
						}
					}
				}
			}
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<a;i++) {
				sb.append("Position of player ");
				sb.append(i+1);
				sb.append(" is ");
				sb.append(pPos[i]);
				sb.append(".\n");
			}
			
			System.out.print(sb.toString());
		}
	}
}