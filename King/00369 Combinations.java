import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args)  throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger [] factorial=new BigInteger [101];
        factorial[0]=BigInteger.ONE;
        //cache.
        for (int i=1;i<factorial.length;i++) {
        	factorial[i]=factorial[i-1].multiply(BigInteger.valueOf(i));
        }
        
        while (true) {
        	StringTokenizer st=new StringTokenizer(br.readLine());
        	int n=Integer.parseInt(st.nextToken());
        	int m=Integer.parseInt(st.nextToken());
        	
        	if (n==0 && m==0) {
        		break;
        	}
        	
        	BigInteger C=factorial[n].divide(factorial[n-m].multiply(factorial[m]));
        	System.out.println(n+" things taken "+m+" at a time is "+C.toString()+" exactly.");
        }
	}  
}