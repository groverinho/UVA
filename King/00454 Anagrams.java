import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

class Main {
	
	private static String preprocess (String s) {
		char [] c=new char [s.length()];
		int cCount=0;
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i)!=' ') {
				c[cCount++]=s.charAt(i);
			}
		}
		Arrays.sort(c,0,cCount);
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<cCount;i++) {
			sb.append(c[i]);
		}
		return sb.toString();
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int testCaseCount=Integer.parseInt(br.readLine());
    	br.readLine();
    	for (int testCase=0;testCase<testCaseCount;testCase++) {
    		ArrayList<String> sList=new ArrayList<>();
    		String s;
    		while ((s=br.readLine())!=null && !s.equals("")) {
    			sList.add(s);
    		}
    		
    		String [] sAry=sList.toArray(new String [sList.size()]);
    		Arrays.sort(sAry);
    		String [] key=new String[sAry.length];
    		
    		for (int i=0;i<sAry.length;i++) {
    			key[i]=preprocess(sAry[i]);
    		}
    		
    		ArrayList<String> toDisplay=new ArrayList<String> ();
    		for (int i=0;i<sAry.length;i++) {
    			for (int i2=i+1;i2<sAry.length;i2++) {
    				if (key[i].equals(key[i2])) {
    					StringBuilder sb=new StringBuilder(sAry[i]);
    					sb.append(" = ");
    					sb.append(sAry[i2]);
    					toDisplay.add(sb.toString());
    				}
    			}
    		}
    		
    		Collections.sort(toDisplay);
    		StringBuilder sb=new StringBuilder();
    		Iterator<String> it=toDisplay.iterator();
    		while (it.hasNext()) {
    			sb.append(it.next());
    			sb.append("\n");
    		}
    		
    		if (testCase>0) {
    			System.out.println();
    		}
    		System.out.print(sb.toString());
    	} 
    }

}