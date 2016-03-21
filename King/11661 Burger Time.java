import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("0")) {
			int length=Integer.parseInt(s);
			int minLength=length;
			char [] data=br.readLine().toCharArray();
			int lastPos=-1;
			for (int i=0;i<length;i++) {
				if (data[i]=='R' || data[i]=='D') {
					if (lastPos==-1 || data[i]==data[lastPos]) {
						lastPos=i;
					} else if (data[i]!=data[lastPos]){
						minLength=Math.min(minLength,i-lastPos);
						lastPos=i;
					}
				} else if (data[i]=='Z') {
					minLength=0;
					break;
				}
			}
			System.out.println(minLength);
		}
	}
}