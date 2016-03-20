import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main (String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int sum=Integer.parseInt(st.nextToken());
			int diff=Integer.parseInt(st.nextToken());
			int b1=(sum-diff)/2;
			int a1=sum-b1;
			int b2=(diff+sum)/2;
			int a2=sum-b2;
			if (a1>=0 && b1>=0 && a1+b1==sum && Math.abs(a1-b1)==diff) {
			    System.out.println(Math.max(a1,b1)+" "+Math.min(a1,b1));
			} else if (a2>=0 && b2>=0 && a2+b2==sum && Math.abs(a2-b2)==diff) {
			    System.out.println(Math.max(a2,b2)+" "+Math.min(a2,b2));
			} else {
			    System.out.println("impossible");
			}
		}
	}
}