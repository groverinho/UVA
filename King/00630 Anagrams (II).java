import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/* #### THE SAMPLE INPUT AND OUTPUT HAD BEEN CHANGED IN THE JUDGE SYSTEM
 	Sample Input :
 		<number of test cases>
 		<blank>
 		<dictionary words count>
 		<dictionary words>
 		<words to check>
 		END
 		<blank>
 		<dictionary words count>
 		....
 		
 		
 	Sample Output :
 		Anagrams for blah blah
 		....
 		<blank for next case>
 		Anagrams for blah blah
 		....
*/
class Main {

	public static String getKey (String s) {
		char [] c=s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int testCaseCount=Integer.parseInt(br.readLine());
    	for (int testCase=0;testCase<testCaseCount;testCase++) {
        	br.readLine();//blank space...
	    	int vocabCount=Integer.parseInt(br.readLine());
	    	HashMap<String,ArrayList<String>> dictionary=new HashMap<>();
	    	String [] vocabs=new String[vocabCount];
	    	for (int i=0;i<vocabCount;i++) {
	    		vocabs[i]=br.readLine();
	    	}
	    	for (int i=0;i<vocabCount;i++) {
	    		String key=getKey(vocabs[i]);
	    		ArrayList<String> list=dictionary.get(key);
	    		if (list==null) {
	    			list=new ArrayList<>();
	    			dictionary.put(key, list);
	    		}
	    		list.add(vocabs[i]);
	    	}
	    	
	    	if (testCase>0) {
	    		System.out.println();
	    	}
	    	
	    	String s;
	    	while (!(s=br.readLine()).equals("END")) {
	    		StringBuilder sb=new StringBuilder("Anagrams for: ");
	    		sb.append(s);
	    		sb.append("\n");
	    		String key=getKey(s);
	    		ArrayList<String> list=dictionary.get(key);
	    		if (list==null) {
	    			sb.append("No anagrams for: ");
	    			sb.append(s);
	    			sb.append("\n");
	    		} else {
	    			Iterator<String> it=list.iterator();
	    			for (int i=1;it.hasNext();i++) {
	    				sb.append("  ");
	    				sb.append(i);
	    				sb.append(") ");
	    				sb.append(it.next());
	    				sb.append("\n");
	    			}
	    		}
	    		System.out.print(sb.toString());
	    	}
    	}
    }
	
}