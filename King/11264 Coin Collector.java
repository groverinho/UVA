import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static int [] moneyType;
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int N=Integer.parseInt(br.readLine());
			moneyType=new int [N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int currSum=0;
			int indexCount=1;
			for (int i=0;i<N;i++) {
				moneyType[i]=Integer.parseInt(st.nextToken());
				if (i>0) {
					if (currSum>=moneyType[i]) {
						currSum-=moneyType[i-1];
						currSum+=moneyType[i];
					} else {
						currSum+=moneyType[i];
						indexCount++;
					}
				} else {
					currSum=moneyType[i];
				}
			}
			System.out.println(indexCount);
		}
	}
}