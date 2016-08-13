import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("#")) {
			char [] c=s.toCharArray();
			int iMax=0;
			for (int i=0;i<c.length-1;i++) {
				if (c[i]<c[i+1]) {
					iMax=i;
				}
			}
			int jMax=0;
			for (int j=iMax+1;j<c.length;j++) {
				if (c[j]>c[iMax]) {
					jMax=j;
				}
			}
			char temp=c[jMax];
			c[jMax]=c[iMax];
			c[iMax]=temp;
			Arrays.sort(c,iMax+1,c.length);
			
			String ans=new String(c);
			if (!ans.equals(s)) {
				System.out.println(ans);
			} else {
				System.out.println("No Successor");
			}
		}
	}
}