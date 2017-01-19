import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int total=0;
			int curr=0;
			for (char c : br.readLine().toCharArray()) {
				if (c=='O') {
					curr++;
					total+=curr;
				} else if (c=='X') {
					curr=0;
				}

			}
			System.out.println(total);
		}
	}
}