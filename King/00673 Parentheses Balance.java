import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	
	public static void main (String [] abc) throws IOException {
		char [] pair=new char [128];
		pair[')']='('; pair[']']='[';
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			boolean fail=false;
			Stack<Character> stk=new Stack<>();
			for (char c : br.readLine().toCharArray()) {
				if (c=='(' || c=='[') {
					stk.push(c);
				} else if (c==')' || c==']') {
					if (stk.isEmpty() || pair[c]!=stk.peek()) {
						fail=true;
						break;
					} else stk.pop();
				}
			}
			fail=fail || !stk.empty();
			if (fail) System.out.println("No");
			else System.out.println("Yes");
		}
	}
}