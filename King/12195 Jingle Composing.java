import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int [] dur=new int [128];
    	dur['W']=64;
    	dur['H']=32;
    	dur['Q']=16;
    	dur['E']=8;
    	dur['S']=4;
    	dur['T']=2;
    	dur['X']=1;
    	String s;
    	while (!(s=br.readLine()).equals("*")) {
    		StringTokenizer st=new StringTokenizer(s,"//");
    		int matchCount=0;
    		
    		while (st.hasMoreTokens()) {
        		int currDur=0;
        		String currSeg=st.nextToken();
        		for (int i=0;i<currSeg.length();i++) {
        			currDur+=dur[currSeg.charAt(i)];
        		}
        		if (currDur==64) {
        			matchCount++;
        		}
    		}

    		System.out.println(matchCount);
    	}
    }
	
}