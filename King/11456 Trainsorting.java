import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static int [] car;
	public static int [][] lis;
	public static boolean [][] lisFlag;
	
	public static int queryFront (int id, int minIndex) { // increasing...
		if (id<car.length) {
			if (!lisFlag[id][minIndex]) {
				int count=1;
				for (int i=id+1;i<car.length;i++) {
					if (car[i]>car[minIndex]) {

						count=Math.max(count, 1+queryFront(i,i));
					}
				}
				lis[id][minIndex]=count;
				lisFlag[id][minIndex]=true;
			}
		} else {
			return 0;
		}
		return lis[id][minIndex];
	}
	
	public static int [][] lds;
	public static boolean [][] ldsFlag;
	
	public static int queryBack (int id, int minIndex) {  // decreasing...
		if (id<car.length) {
			if (!ldsFlag[id][minIndex]) {
				int count=1;
				for (int i=id+1;i<car.length;i++) {
					if (car[minIndex]>car[i]) {
						count=Math.max(count, 1+queryBack(i,i));
					}
				}
				lds[id][minIndex]=count;
				ldsFlag[id][minIndex]=true;
			}
		} else {
			return 0;
		}
		return lds[id][minIndex];
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int n=Integer.parseInt(br.readLine());
			if (n==0) {
				System.out.println(0);
			} else {
				car=new int [n];
				for (int i=0;i<n;i++) {
					car[i]=Integer.parseInt(br.readLine());
				}
				
				lis=new int [n][n];
				lds=new int [n][n];
				lisFlag=new boolean [n][n];
				ldsFlag=new boolean [n][n];
				
				int max=0;
				for (int i=0;i<n;i++) {
					max=Math.max(max, queryFront(i,i)+queryBack(i,i)-1);
				}
				System.out.println(max);

			}
		}
	}
}