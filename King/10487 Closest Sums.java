import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=1;
		while (!(s=br.readLine()).equals("0")) {
			int [] values=new int [Integer.parseInt(s)];
			for (int i=0;i<values.length;i++) {
				values[i]=Integer.parseInt(br.readLine());
			}
			int [] answers=new int [values.length*(values.length-1)];
			int answersCount=0;
			for (int i=0;i<values.length;i++) {
				for (int i2=i+1;i2<values.length;i2++) {
					answers[answersCount++]=values[i]*values[i2];
				}
			}
			Arrays.sort(answers);
			
			int queryCount=Integer.parseInt(br.readLine());
			
			StringBuilder sb=new StringBuilder();
			sb.append("Case ");
			sb.append(testCase);
			sb.append(":\n");
			for (int q=0;q<queryCount;q++) {
				int target=Integer.parseInt(br.readLine());
				int diff=Integer.MAX_VALUE;
				for (int i=0;i<values.length;i++) {
					for (int i2=i+1;i2<values.length;i2++) {
						int currDiff=target-(values[i]+values[i2]);
						if (Math.abs(currDiff)<Math.abs(diff)) {
							diff=currDiff;
						}
					}
				}
				sb.append("Closest sum to ");
				sb.append(target);
				sb.append(" is ");
				sb.append(target-diff);
				sb.append(".\n");
			}
			
			System.out.print(sb.toString());
			testCase++;
		}
	}
	
}