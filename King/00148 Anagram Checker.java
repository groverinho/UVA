import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    static String [] dictionary;
    static int [] referListLetterOccurance;
    static StringBuilder toDisplay;
    static String currInput;
    static HashMap<String,Boolean> currInputSet;
    
	public static void main(String[] args) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	String s;
    	ArrayList<String> tempDict=new ArrayList<>();
    	while (!(s=br.readLine()).equals("#")) {
    		tempDict.add(s);
    	}
    	dictionary=tempDict.toArray(new String[tempDict.size()]);
    	while (!(s=br.readLine()).equals("#")) {
    		currInputSet=new HashMap<>();
    		
    		StringTokenizer st=new StringTokenizer(s);
    		StringBuilder sb=new StringBuilder();
    		while (st.hasMoreTokens()) {
    			String part=st.nextToken();
    			sb.append(part);
    			currInputSet.put(part,true);
    		}
    		char [] c=sb.toString().toCharArray();
    		Arrays.sort(c);
    		
    	    referListLetterOccurance=new int [128];
    		for (int i=0;i<c.length;i++) {
    			referListLetterOccurance[c[i]]++;
    		}
    		
    		toDisplay=new StringBuilder();
    		currInput=s;
    		permutate(c,new char [c.length],0,new int [256],"",0);
    		
    		System.out.print(toDisplay.toString());
    	}
    }
	
	public static boolean validateResult(String result) {
		StringTokenizer st=new StringTokenizer(result);
		while (st.hasMoreTokens()) {
			if (currInputSet.get(st.nextToken())!=null) {
				return false;
			}
		}
		return true;
	}
	
	public static void permutate (char [] referList, char [] currentList, int currentListSize, int [] currentListLetterOccurance, String result, int minStart) {
		if (currentListSize==referList.length) {
			result=result.substring(0,result.length()-1);
			if (validateResult(result)) {
				toDisplay.append(currInput);
				toDisplay.append(" = ");
				toDisplay.append(result);
				toDisplay.append("\n");
			}
		} else {
			for (int i=minStart;i<dictionary.length;i++) {
				if (currentListSize+dictionary[i].length()<=referList.length) {
					for (int i2=0;i2<dictionary[i].length();i2++) {
						currentList[i2+currentListSize]=dictionary[i].charAt(i2);
						currentListLetterOccurance[currentList[i2+currentListSize]]++;
					}
					
					int testLength=currentListSize+dictionary[i].length();
					if (compareOccurance(currentList,testLength,currentListLetterOccurance)) {
						StringBuilder sb=new StringBuilder(result);
						sb.append(dictionary[i]);
						sb.append(" ");
						permutate(referList,currentList,testLength,currentListLetterOccurance,sb.toString(),i+1);
					}
					
					for (int i2=0;i2<dictionary[i].length();i2++) {
						currentListLetterOccurance[currentList[i2+currentListSize]]--;
					}
				}
			}
		}
	}
	
	public static boolean compareOccurance(char [] c, int length, int [] occur) {
		for (int i=0;i<length;i++) {
			if (occur[c[i]]>referListLetterOccurance[c[i]]) {
				return false;
			}
		}
		return true;
	}
}