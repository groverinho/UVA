import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	
	public static int search (int [] ints, int endIndex, int target) {
		int min=0;
		int max=endIndex;
		int mid=0;
		
		while (min<=max) {
			mid=(min+max)/2;
			if (ints[mid]>target) {
				max=mid-1;
			} else if (ints[mid]<target) {
				min=mid+1;
			} else {
				return mid;
			}
		}
		if (ints[mid]<target) {
			return mid+1;
		} else {
			return mid;
		}
	}
	
	public static void main(String[]args) throws IOException {
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<>();
		
		while (sc.hasNextInt()) {
			list.add(sc.nextInt());
		}
		
		int [] ints=new int [list.size()];
		for (int i=0;i<ints.length;i++) {
			ints[i]=list.get(i);
		}
		
		int [] dp=new int [ints.length];
		int dpCount=1;
		dp[0]=ints[0];
		
		int [] lis=new int [ints.length];
		lis[0]=1;
		
		for (int i=1;i<ints.length;i++) {
			if (ints[i]>dp[dpCount-1]) {
				lis[i]=dpCount+1;
				dp[dpCount++]=ints[i];
			} else if (ints[i]<dp[dpCount-1]) {
				int index=search(dp,dpCount-1,ints[i]);
				lis[i]=index+1;
				dp[index]=ints[i];
			} else {
				lis[i]=dpCount;
			}
		}
		
		int [] solution=new int[dpCount];
		int solutionCount=0;
		int expected=dpCount;
		for (int i=ints.length-1;i>=0;i--) {
			if (lis[i]==expected && (solutionCount==0 || ints[i]<solution[solutionCount-1])) {
				solution[solutionCount++]=ints[i];
				expected--;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(dpCount);
		sb.append("\n-\n");
		for (int i=solutionCount-1;i>=0;i--) {
			sb.append(solution[i]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
		sc.close();
	}
}