import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0")) {
			int N=Integer.parseInt(s);
			StringTokenizer st=new StringTokenizer(br.readLine());
			int [] ints=new int [N];
			for (int n=0;n<ints.length;n++) ints[n]=Integer.parseInt(st.nextToken());
			
			int count=0;
			for (int i=0;i<ints.length;i++)
				if ((ints[Math.floorMod(i-1,ints.length)]-ints[i]>0 && ints[(i+1)%ints.length]-ints[i]>0) ||
					(ints[i]-ints[Math.floorMod(i-1,ints.length)]>0 && ints[i]-ints[(i+1)%ints.length]>0))
					count++;
			System.out.println(count);
		}
	}

}