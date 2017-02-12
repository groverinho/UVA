import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static HashMap<Integer,Integer> cache=new HashMap<>();
	
	public static int numberOfDivisors (int num) {
		int ans=0;
		if (cache.containsKey(num)) ans=cache.get(num);
		else {
			if (BigInteger.valueOf(num).isProbablePrime(10)) return 2;
			
			int count=0;
			double sqrt=Math.sqrt(num);
			for (int i=1;i<sqrt;i++) if (num%i==0) count+=2;
			if ((int)sqrt*(int)sqrt==num) count++;
			ans=count;
			cache.put(num,count);
		}
		return ans;
	}
	
	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(st.nextToken());
			int U=Integer.parseInt(st.nextToken());
			
			int maxI=0;
			int maxDiv=0;
			for (int i=L;i<=U;i++) {
				int currDiv=numberOfDivisors(i);
				if (currDiv>maxDiv) {
					maxI=i;
					maxDiv=currDiv;
				}
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("Between ");
			sb.append(L);
			sb.append(" and ");
			sb.append(U);
			sb.append(", ");
			sb.append(maxI);
			sb.append(" has a maximum of ");
			sb.append(maxDiv);
			sb.append(" divisors.");
			System.out.println(sb.toString());
		}
	}
}