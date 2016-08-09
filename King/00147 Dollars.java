import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long [] dp=new long [30001];
		int [] money=new int [] {5,10,20,50,100,200,500,1000,2000,5000,10000};

		dp[0]=1;
		
		for (int i=0;i<money.length;i++) {
			for (int i2=money[i];i2<dp.length;i2++) {
				dp[i2]+=dp[i2-money[i]];
			}
		}

		String blank="                 ";
		DecimalFormat df=new DecimalFormat("0.00");
		while (true) {
			double d=Double.parseDouble(br.readLine());
			if (d==0) {
				break;
			}
			int i=(int)(d*100+0.005);
			String si=String.valueOf(dp[i]);
			String s1=df.format(d);
			String s2=blank.substring(0,blank.length()-si.length())+dp[i];
			
			System.out.println(blank.substring(0,6-s1.length())+s1+s2);
		}
	}
}