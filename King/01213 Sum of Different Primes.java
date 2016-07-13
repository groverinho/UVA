import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static int [][][] dp;
	public static boolean [] notPrime=new boolean [1121];
	public static int [] primeNumbers=new int [550];
	public static int primeNumbersCount;
	
	public static void sieveOfEratosthenes() {
		for (int i=2;i*i<notPrime.length;i++) {
			if (!notPrime[i]) {
				for (int i2=i*i;i2<notPrime.length;i2+=i) {
					notPrime[i2]=true;
				}
			}
		}
		
		for (int i=2;i<notPrime.length;i++) {
			if (!notPrime[i]) {
				primeNumbers[primeNumbersCount++]=i;
			}
		}
	}
	
	public static int query (int id, int remNum, int remCount) {
		if (dp[id][remNum][remCount]==-1) {
			if (id>primeNumbersCount) {
				dp[id][remNum][remCount]=0;
			} else if (remCount==0) {
				if (remNum==0) {
					dp[id][remNum][remCount]=1;
				} else {
					dp[id][remNum][remCount]=0;
				}
			} else {
				dp[id][remNum][remCount]=query(id+1,remNum,remCount);
				if (remNum>=primeNumbers[id]) {
					dp[id][remNum][remCount]+=query(id+1,remNum-primeNumbers[id],remCount-1);
				}
			}
		}
		return dp[id][remNum][remCount];
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		sieveOfEratosthenes();
		dp=new int [primeNumbersCount+2][1121][15]; //prime numbers count = 187, total 188 prime numbers, hence size=189.
		System.out.println(dp.length);
		for (int i=0;i<dp.length;i++) {
			for (int i2=0;i2<dp[i].length;i2++) {
				for (int i3=0;i3<dp[i][i2].length;i3++) {
					dp[i][i2][i3]=-1;
				}
			}
		}
		
		
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			if (n==0 && k==0) {
				break;
			}
			System.out.println(query(0,n,k));
		}
	}
}