import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long [] values=new long [10000];
		int size=0;
		Arrays.fill(values, Long.MAX_VALUE);
		
		String s;
		while ((s=br.readLine())!=null) {
			values[size++]=Long.parseLong(new StringTokenizer(s).nextToken());
			Arrays.sort(values);

			if (size==1) {
				System.out.println(values[0]);
			} else if (size%2==0) {
				System.out.println((values[size/2-1]+values[size/2])/2);
			} else {
				System.out.println(values[size/2]);
			}
		}
	}    
}