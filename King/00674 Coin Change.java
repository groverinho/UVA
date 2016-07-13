import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static long [][] dp;
	public static boolean [][] flag;
	public static int [] money={50,25,10,5,1};
	
	public static long query (int id, int remMoney) {
		if (!flag[id][remMoney]) {
			if (remMoney==0) {
				dp[id][remMoney]=1;
			} else if (id==money.length) {
				dp[id][remMoney]=0;
			} else {
				int ways=0;
				for (int i=id;i<money.length;i++) {
					if (remMoney>=money[i]) {
						ways+=query(i,remMoney-money[i]);
					}
				}
				dp[id][remMoney]=ways;
			}
			flag[id][remMoney]=true;
		}
		return dp[id][remMoney];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		dp=new long [money.length+1][7850];
		flag=new boolean [money.length+1][7850];
		
		String s;
		while ((s=br.readLine())!=null) {
			System.out.println(query(0,Integer.parseInt(s)));
		}
		
	}
}