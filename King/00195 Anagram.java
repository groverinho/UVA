import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Main {
	
	static int [] charValue=new int [128];
	
	static class ch implements Comparable<ch> {
		char c;
		
		public ch (char zz) {
			this.c=zz;
		}
		
		public int compareTo(ch z) {
			return charValue[this.c]-charValue[z.c];
		}
	}
	
	public static void setupCharCache() {
		for (int i='A';i<='Z';i++) {
			charValue[i]=(i-'A')*2;
		}
		for (int i='a';i<='z';i++) {
			charValue[i]=(i-'a')*2+1;
		}
	}
	
	static StringBuilder displayStr;
	static HashMap<String,Boolean> map;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int testCaseCount=Integer.parseInt(br.readLine());
    	setupCharCache();
    	for (int i=0;i<testCaseCount;i++) {
    		String s=br.readLine();
    		ch [] c=new ch [s.length()];
    		for (int i2=0;i2<s.length();i2++) {
    			c[i2]=new ch(s.charAt(i2));
    		}
    		Arrays.sort(c);
    		
    		char [] arranged=new char[c.length];
    		for (int i2=0;i2<c.length;i2++) {
    			arranged[i2]=c[i2].c;
    		}
    		
    		map=new HashMap<>(1000);
    		displayStr=new StringBuilder();
    		permutate("",0,arranged,new boolean [c.length]);
    		System.out.print(displayStr);
    	}
    }
    
	private static void permutate (String s, int level, char [] c, boolean [] b) {
		if (level==c.length) {
    		displayStr.append(s);
    		displayStr.append("\n");
		} else {
			for (int i=0;i<c.length;i++) {
				if (!b[i] && map.get(s+c[i])==null) {
					b[i]=true;
					map.put(s+c[i], true);
					permutate(s+c[i],level+1,c,b);
					b[i]=false;
				}
			}
		}
	}
}