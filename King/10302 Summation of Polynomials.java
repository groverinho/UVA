import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		//formula for summation of cubes = [n^2 (n+1)^2] / 4
		while ((s=br.readLine())!=null) {
			long n=Integer.parseInt(s);
			System.out.println((n*n*(n+1)*(n+1))/4);
		}


	}
}