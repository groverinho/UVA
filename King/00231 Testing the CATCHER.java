import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		ArrayList<Integer> list=new ArrayList<>();
		int testCase=1;
		while (true) {
			s=br.readLine();
			int inputNum=Integer.parseInt(new StringTokenizer(s).nextToken());
			if (inputNum!=-1) {
				list.add(inputNum);
			} else if (!list.isEmpty()) {
				int [] ints=new int [list.size()];
				for (int i=0;i<ints.length;i++) {
					ints[i]=list.get(i);
				}
				
				int [] dp=new int [list.size()];
				int dpCount=1;
				dp[0]=ints[0];
				
				if (ints.length>1) {
					//dp[1]=ints[1];
					for (int i=1;i<ints.length;i++) {
						if (ints[i]<=dp[dpCount-1]) {
							dp[dpCount++]=ints[i];
							//values here should be sorted.
							
						} else if (ints[i]>dp[dpCount-1]) {
							int index=0;
							//search index with number larger than ints[i]
							for (;index<dpCount;index++) {
								if (dp[index]<ints[i]) {
									break;
								}
							}
							dp[index]=ints[i];
						}
					}
					
				}
					
				StringBuilder sb=new StringBuilder();
				if (testCase>1) {
					sb.append("\n");
				}
				sb.append("Test #");
				sb.append(testCase);
				sb.append(":\n");
				sb.append("  maximum possible interceptions: ");
				sb.append(dpCount);
				System.out.println(sb.toString());
				
				list=new ArrayList<>();
				testCase++;
			} else {
				break;
			}
		}
	}
}