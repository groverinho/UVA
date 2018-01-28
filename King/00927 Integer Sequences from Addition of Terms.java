import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] args) throws Exception {
		/*
		 * ===================================================
		 * 	Test Case Data :
		 *  ===================================================
		 * 		Line 1 -> x = (length of c-1)<space>c0<space>c1.....
		 * 		Line 2 -> d (repetition)
		 * 		Line 3 -> k (target position)
		 * 
		 * 	The sequence would be :
		 * 		c0, c0, ... (d times of c0), c1, c1, ... (2d times of c1), ..., c2, c2 (3d times of c2)...
		 *     |          B1				|			B2				|			B3					|
		 * 
		 * 	Bn is defined as the sequence of cn.
		 *  Now find the Bn such that k is in Bn-1 and Bn.
		 *  Get the n, then display the summation of : ci*n^i, where i=0,1,2...n
		 *  
		 *  ===================================================
		 *  Sample Input & Explanation :
		 *  ===================================================
		 *  1 0 1
		 *  1
		 *  6
		 *  
		 *  By reversing the sum of arithmetic series, we get n^2 + n - 2k/d = 0
		 *  Solve the quadratic equation and we can now get the answer.
		 * 
		 */
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			String [] split=br.readLine().split(" ");
			int [] cn=new int [split.length-1];
			for (int i=1;i<split.length;i++) cn[i-1]=Integer.parseInt(split[i]);
			int d=Integer.parseInt(br.readLine()), k=Integer.parseInt(br.readLine());
			
			int n= (int)Math.ceil((Math.sqrt(1+(8*k)/d)-1)/2);
			long sum=0;
			for (int i2=0;i2<cn.length;i2++) sum+=cn[i2]*(long)(Math.pow(n, i2));
			System.out.println(sum);
		}
	}

}