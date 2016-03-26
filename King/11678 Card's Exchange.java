import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int [] a=new int [Integer.parseInt(st.nextToken())];
			int [] b=new int [Integer.parseInt(st.nextToken())];
			int aLength=0;
			int bLength=0;
			
			st=new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				a[aLength]=Integer.parseInt(st.nextToken());
				if (aLength>0 && a[aLength]==a[aLength-1]) {
					aLength--;
				}
				aLength++;
			}
			
			st=new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				b[bLength]=Integer.parseInt(st.nextToken());
				if (bLength>0 && b[bLength]==b[bLength-1]) {
					bLength--;
				}
				bLength++;
			}
			
			if (aLength<bLength) {
				int [] temp=a;
				a=b;
				b=temp;
				
				int tempL=aLength;
				aLength=bLength;
				bLength=tempL;
			}
			
			boolean [] has=new boolean [100001];
			for (int i=0;i<aLength;i++) {
				has[a[i]]=true;
			}
			
			int count=0;
			for (int i=0;i<bLength;i++) {
				if (!has[b[i]]) {
					has[b[i]]=true;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}