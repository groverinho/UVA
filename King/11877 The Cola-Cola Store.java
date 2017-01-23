import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while (!(s=br.readLine()).equals("0")) {
			int coke=Integer.parseInt(s);
			int count=0;
			while (coke>=3) {
				count+=coke/3;
				coke=coke/3+coke%3;
			}
			if (coke==2) count++;
			System.out.println(count);
		}
	}
}