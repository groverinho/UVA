import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {
	
	public static HashSet<Integer> travelled=new HashSet<>();
	
	public static int sumOfSquareOfDigits (int num) {
		int count=0;
		while (num>0) {
			count+=(num%10)*(num%10);
			num/=10;
		}
		return count;
	}
	
	public static boolean isHappy (int num) {
		travelled.clear();
		while (num!=1 && !travelled.contains(num)) {
			travelled.add(num);
			num=sumOfSquareOfDigits(num);
		}
		return num==1;
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int n=Integer.parseInt(br.readLine());
			if (isHappy(n)) System.out.println("Case #"+testCase+": "+n+" is a Happy number.");
			else System.out.println("Case #"+testCase+": "+n+" is an Unhappy number.");
		}
	}
	
}