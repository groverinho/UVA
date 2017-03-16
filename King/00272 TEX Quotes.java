import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args)  throws IOException {  
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	String s;
        	boolean start=true;
        
        	while ((s=br.readLine())!=null){
            		StringBuilder sb=new StringBuilder();
        		char [] c=s.toCharArray();
        		for (int i=0;i<c.length;i++) {
        			if (c[i]=='\"') {
					sb.append( start ? "``" : "''" );
        				start=!start;
        			} else {
    					sb.append(c[i]);
        			}
        		}
        	System.out.println(sb.toString());
        	}
	}  
}