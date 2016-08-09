import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [] order=new int [n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			order[i]=Integer.parseInt(st.nextToken());
		}
		
		String s;
		while ((s=br.readLine())!=null) {
			st=new StringTokenizer(s);
			int [] test=new int [n];
			for (int i=0;i<n;i++) {
				test[Integer.parseInt(st.nextToken())-1]=i;
				/*   Example of student's answer...
				 *    *****************
				 *   |  Event |  Order |
				 *   |********|********|
				 *   |   #1   |    3   |
				 *   |   #2   |    2   |
				 *   |   #3   |    1   |
				 *   |   #4   |    4   |
				 *    *****************
				 *   
				 *   Input is the "Order", so we need to put the value in invert way.
				 */
			}
			
			int [] lis=new int [n];
			lis[0]=1;
			for (int i=1;i<n;i++) {
				lis[i]=Math.max(1, lis[i]);
				for (int i2=0;i2<i;i2++) {
					if (order[test[i]]>order[test[i2]]) {
						lis[i]=Math.max(lis[i],1+lis[i2]);
					}
				}
			}
			
			int max=0;
			for (int i : lis) {
				max=Math.max(max, i);
			}
			
			System.out.println(max);
		}
	}
}