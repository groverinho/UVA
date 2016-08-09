import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for (int i=0;i<t;i++) {
			double x=Double.parseDouble(br.readLine());
			/*
			 *              n
			 * Sn for AP = === [2a + (n-1)d]
			 *              2
			 * 
			 * In our case, given Sn, we know a = 1, d = 1, so we need to find floor of n.
			 * Let x be Sn.
			 * 
			 *      n
			 * x = === (2 + n-1)
			 *      2
			 * 
			 * 2x = n(1 + n)
			 * 
			 * n^2 + n - 2x = 0
			 * 
			 * Applying quadratic equation...
			 * 
			 *     -b+-sqrt(b^2-4ac)
			 * x = ================= where equation is in form of ax^2 + bx + c = 0
			 *           2a
			 * 
			 * We have :
			 * a=1, b=1, c=-2x.
			 * 
			 * Hence :
			 *     -1+-sqrt(1+8x)
			 * x = ================= where equation is in form of ax^2 + bx + c = 0
			 *           2
			 * 
			 */
			System.out.println((int)((-1+Math.sqrt(1+4*2*x))/2));
		}
	}
}