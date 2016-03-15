import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("0")) {
			int value=Integer.parseInt(s);
			while (value>=10) {
				int sum=0;
				while (value>0) {
					sum+=value%10;
					value/=10;
				}
				value=sum;
			}
			System.out.println(value);
		}
	}
}