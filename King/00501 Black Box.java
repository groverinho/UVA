import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static void addQueued (ArrayList<Integer> list, int element) {
		int min=0;
		int max=list.size()-1;
		int mid=0;
		
		if (list.size()==0) list.add(element);
		else if (list.get(0)>=element) list.add(0,element);
		else if (list.get(list.size()-1)<=element) list.add(element);
		else {
			while (min<=max) {
				mid=(min+max)/2;
				int midValue=list.get(mid);
				if (midValue==element) break;
				else if (midValue>element) max=mid-1;
				else min=mid+1;
			}
			
			if (list.get(mid)>=element) list.add(mid,element);
			else list.add(mid+1,element);
		}
	}
	
	public static void main (String [] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int testCaseCount=sc.nextInt();
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int M=sc.nextInt();
			int N=sc.nextInt();
			int [] A=new int [M];
			for (int i=0;i<M;i++) A[i]=sc.nextInt();
			int [] u=new int [N];
			for (int i=0;i<N;i++) u[i]=sc.nextInt();
			Arrays.sort(u);
			int uCurr=0;
			int I=0;
			
			StringBuilder sb=new StringBuilder();
			ArrayList<Integer> queue=new ArrayList<>();
			for (int i=0;i<M & uCurr<N;i++) {
				addQueued(queue,A[i]);
				//System.out.println(queue);
				while (uCurr<N && u[uCurr]==queue.size()) {
					sb.append(queue.get(I++));
					sb.append('\n');
					uCurr++;
				}
			}
			
			if (testCase>0) System.out.println();
			System.out.print(sb.toString());
		}
		sc.close();
	}
}