import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int testCaseCount=Integer.parseInt(br.readLine());
    	for (int testCase=0;testCase<testCaseCount;testCase++) {
    		String s=br.readLine();
    		StringTokenizer st=new StringTokenizer(s,":");
    		int h=Integer.parseInt(st.nextToken());
    		int m=Integer.parseInt(st.nextToken());
    		do {
    			m=m+1;
    			if (m==60) {
    				m=0;
    				h=h+1;
    				if (h==24) {
    					h=0;
    				}
    			}
    			int check=h*100+m;
    			if (isPalindrome(String.valueOf(check))) {
    				StringBuilder sb=new StringBuilder();
    				if (h<10) {
    					sb.append("0");
    				}
    				sb.append(h);
    				sb.append(":");
    				if (m<10) {
    					sb.append("0");
    				}
    				sb.append(m);
    				System.out.println(sb.toString());
    				break;
    			}
    		} while (true);
    	}
    }
	
	public static boolean isPalindrome (String s) {
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i)!=s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
}