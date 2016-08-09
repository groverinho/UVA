import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine();//empty.
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			ArrayList<Integer> missles=new ArrayList<>();
			String s;
			while (true) {
				s=br.readLine();
				if (s==null || s.equals("")) {
					break;
				}
				missles.add(Integer.parseInt(s));
			}
			
			int [] lis=new int [missles.size()];
			lis[0]=1;
			for (int i=1;i<lis.length;i++) {
				lis[i]=Math.max(lis[i], 1);
				for (int i2=0;i2<i;i2++) {
					if (missles.get(i)>missles.get(i2)) {
						lis[i]=Math.max(lis[i], lis[i2]+1);
					}
				}
			}
			
			int max=0;
			for (int i : lis) {
				max=Math.max(max, i);
			}
			
			System.out.println("Max hits: "+max);
			
			boolean first=true;
			int last=0;
			ArrayList<Integer> solution=new ArrayList<>();
			for (int i=missles.size()-1;i>=0 && max>0;i--) {
				if (lis[i]==max && (first || missles.get(i)<last)) {
					first=false;
					last=missles.get(i);
					solution.add(last);
					max--;
				}
			}
			
			for (int i=solution.size()-1;i>=0;i--) {
				System.out.println(solution.get(i));
			}
			if (testCase<testCaseCount-1) {
				System.out.println();
			}
		}
	}
}