import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int C=Integer.parseInt(s);
			int c=0;
			for (int i=1;c<C;i++) {
				for (int i2=1;i2<i && c<C;i2++) {
					c++;
					if (c==C) {
						String ans="";
						if (i%2==0) ans=String.valueOf(i-i2)+"/"+String.valueOf(i2);
						else ans=String.valueOf(i2)+"/"+String.valueOf(i-i2);
						System.out.println("TERM "+s+" IS "+ans);
					}
				}
			}
			
		}
	}

}