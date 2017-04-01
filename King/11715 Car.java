import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static double [] find1 (double []d) {
		double[] ans=new double [2];
		ans[1]=(d[1]-d[0])/d[2]; //a
		ans[0]=d[0]*d[2]+0.5*ans[1]*d[2]*d[2]; //s
		return ans;
	}
	
	public static double [] find2 (double []d) {
		double[] ans=new double [2];
		ans[0]=(d[1]*d[1]-d[0]*d[0])/(2*d[2]); //s
		ans[1]=(d[1]-d[0])/d[2]; //t
		return ans;
	}
	
	public static double [] find3 (double []d) {
		double[] ans=new double [2];
		ans[0]=Math.sqrt(d[0]*d[0]+2*d[1]*d[2]);
		ans[1]=(ans[0]-d[0])/d[1];
		return ans;
	}
	
	public static double [] find4 (double []d) {
		double[] ans=new double [2];
		ans[0]=Math.sqrt(d[0]*d[0]-2*d[1]*d[2]);
		ans[1]=(d[0]-ans[0])/d[1];
		return ans;
	}
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=1;
		while ((s=br.readLine())!=null && !s.equals("0")) {
			StringTokenizer st=new StringTokenizer(s);
			int funcId=Integer.parseInt(st.nextToken());
			double [] data=new double [3];
			data[0]=Double.parseDouble(st.nextToken());
			data[1]=Double.parseDouble(st.nextToken());
			data[2]=Double.parseDouble(st.nextToken());
			
			double [] ans=null;
			switch (funcId) {
				case 1 : {
					ans=find1(data);
					break;
				}
				case 2 : {
					ans=find2(data);
					break;
				}
				case 3 : {
					ans=find3(data);
					break;
				}
				case 4 : {
					ans=find4(data);
					break;
				}
			}
			
			System.out.printf("Case %d: %.3f %.3f\n",testCase++,ans[0],ans[1]);
		}
	}
	
}