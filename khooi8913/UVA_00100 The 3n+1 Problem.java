import java.util.*;
import java.io.*;

public class Main{

	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while((s=br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(s);
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int min = Math.min(i, j);
			int max = Math.max(i, j);
			
			int maxCycleLength =0;
			
			while(min<=max){
				int cycleLength = 1;
				int n = min;
				
				while(n!=1){
					n = (n%2==0) ? n/2 : (n*3)+1 ;
					cycleLength++;
				}
				
				maxCycleLength = Math.max(cycleLength, maxCycleLength);
				min++;
			}
			
			System.out.printf("%d %d %d\n",i,j,maxCycleLength);
			
		}
		
	}

}