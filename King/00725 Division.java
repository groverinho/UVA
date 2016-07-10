import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static int target=0;
	public static boolean found=false;
	
	public static void search (boolean [] flag, int curr, int depth) {
		if (depth==5) {
			if (curr%target==0) {
				int divisor=curr/target;
				boolean [] flag2=new boolean [10];
				flag2[0]=(divisor<10000);
				while (divisor>0) {
					if (flag2[divisor%10]) {
						return;
					} else {
						flag2[divisor%10]=true;
					}
					divisor/=10;
				}
				for (int i=0;i<10;i++) {
					if (!flag[i]^flag2[i]) {
						return;
					}
				}
				divisor=curr/target;
				if (divisor<10000) {
					System.out.println(curr+" / 0"+divisor+" = "+target);
				} else {
					System.out.println(curr+" / "+divisor+" = "+target);
				}
				found=true;
			}
		} else {
			for (int i=0;i<10;i++) {
				if (!flag[i]) {
					flag[i]=true;
					search(flag,curr*10+i,depth+1);
					flag[i]=false;
				}
			}
		}
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int t=0;
		while (!(s=br.readLine()).equals("0")) {
			target=Integer.parseInt(s);
			found=false;
			
			if (t>0) {
				System.out.println();
			}
			
			search(new boolean [10],0,0);

			if (!found) {
				System.out.println("There are no solutions for "+target+".");
			}
			t++;
		}
	}
}