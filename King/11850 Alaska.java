import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int [] ints=new int [Integer.parseInt(s)];
			for (int i=0;i<ints.length;i++) ints[i]=Integer.parseInt(br.readLine());
			Arrays.sort(ints);
			
			boolean flag=true;
			for (int i=1;i<ints.length && flag;i++) flag=(ints[i]-ints[i-1])<=200;
			flag = flag & 2*(1422 - ints[ints.length-1]) <= 200;
			
			System.out.println(flag ? "POSSIBLE" : "IMPOSSIBLE" );
		}
	}

}