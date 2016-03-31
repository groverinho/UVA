import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Main {
	
	public static HashMap<String,Boolean> generated;
	public static StringBuilder toDisplay;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int testCaseCount=Integer.parseInt(br.readLine());
    	for (int testCase=0;testCase<testCaseCount;testCase++) {
    		char [] c=br.readLine().toCharArray();
    		Arrays.sort(c);
    		generated=new HashMap<>();
    		toDisplay=new StringBuilder();
    		permutate(c,new boolean [c.length],"");
    		System.out.println(toDisplay.toString());
    	}
    }
	
	public static void permutate (char [] c, boolean [] flag, String result) {
		if (result.length()==c.length) {
			toDisplay.append(result);
			toDisplay.append("\n");
		} else {
			for (int i=0;i<c.length;i++) {
				if (!flag[i]) {
					String s=result+c[i];
					if (generated.get(s)==null) {
						flag[i]=true;
						generated.put(s, true);
						permutate(c,flag,s);
						flag[i]=false;
					}
				}
			}
		}
	}
}