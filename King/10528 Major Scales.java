import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	String [] notes={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
    	int [] addition={2,2,1,2,2,2,1};
    	HashMap<String,HashMap<String,Boolean>> map=new HashMap<>();
    	for (int i=0;i<notes.length;i++) {
    		map.put(notes[i],new HashMap<>());
    	}
    	for (int i=0;i<notes.length;i++) {
    		int currIndex=i;
    		map.get(notes[i]).put(notes[i],true);
    		for (int i2=0;i2<addition.length;i2++) {
    			currIndex=(currIndex+addition[i2])%notes.length;
    			map.get(notes[currIndex]).put(notes[i], true);
    		}
    	}
    	
    	String s;
    	while (!(s=br.readLine()).equals("END")) {
    		StringTokenizer st=new StringTokenizer(s);
    		String [] currNodes=new String[st.countTokens()];
    		for (int i=0;i<currNodes.length;i++) {
    			currNodes[i]=st.nextToken();
    		}
    		Arrays.sort(currNodes);
    		StringBuilder sb=new StringBuilder();
    		for (int i=0;i<notes.length;i++) {
    			boolean allIn=true;
    			for (int i2=0;i2<currNodes.length && allIn;i2++) {
    				if (i2==0 || !currNodes[i2].equals(currNodes[i2-1])) {
    					allIn=map.get(currNodes[i2]).get(notes[i])!=null;
    				}
    			}
    			if (allIn) {
    				sb.append(notes[i]);
    				sb.append(" ");
    			}
    		}
    		String disp=sb.toString();
    		if (disp.length()>0) {
    			disp=disp.substring(0,disp.length()-1);
    		}
    		System.out.println(disp);
    	}
    }
	
}