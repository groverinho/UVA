import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

class Main {

	public static String getKey (String s) {
		char [] c=s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   	HashMap<String,ArrayList<String>> dictionary=new HashMap<>();
	   	String s;
	   	ArrayList<String> vocabs=new ArrayList<>();
		while (!(s=br.readLine()).equals("XXXXXX")) {
	    	vocabs.add(s);
	   	}
		Collections.sort(vocabs);
	    for (int i=0;i<vocabs.size();i++) {
	    	String key=getKey(vocabs.get(i));
	    	ArrayList<String> list=dictionary.get(key);
	    	if (list==null) {
	    		list=new ArrayList<>();
	    		dictionary.put(key, list);
	    	}
	    	list.add(vocabs.get(i));
	    }
		while (!(s=br.readLine()).equals("XXXXXX")) {
			String key=getKey(s);
			ArrayList<String> list=dictionary.get(key);
			StringBuilder sb=new StringBuilder();
			if (list!=null) {
				Iterator<String> it=list.iterator();
				while (it.hasNext()) {
					sb.append(it.next());
					sb.append("\n");
				}
			} else {
				sb.append("NOT A VALID WORD\n");
			}
			sb.append("******");
			System.out.println(sb.toString());
    	}
    }
	
}