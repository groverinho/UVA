import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

	public static void reversePut (HashMap<String,String> map, String s1, String s2) {
		map.put(s2,s1);
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		HashMap<String,String> map=new HashMap<>();
		
		reversePut(map,"A",".-"); reversePut(map,"B","-..."); reversePut(map,"C","-.-."); reversePut(map,"D","-..");
		reversePut(map,"E","."); reversePut(map,"F","..-."); reversePut(map,"G","--."); reversePut(map,"H","....");
		reversePut(map,"I",".."); reversePut(map,"J",".---"); reversePut(map,"K","-.-"); reversePut(map,"L",".-.."); 
		reversePut(map,"M","--"); reversePut(map,"N","-."); reversePut(map,"O","---"); reversePut(map,"P",".--.");
		reversePut(map,"Q","--.-"); reversePut(map,"R",".-."); reversePut(map,"S","..."); reversePut(map,"T","-");
		reversePut(map,"U","..-"); reversePut(map,"V","...-"); reversePut(map,"W",".--"); reversePut(map,"X","-..-");
		reversePut(map,"Y","-.--"); reversePut(map,"Z","--.."); reversePut(map,"0","-----"); reversePut(map,"1",".----");
		reversePut(map,"2","..---"); reversePut(map,"3","...--"); reversePut(map,"4","....-"); reversePut(map,"5",".....");
		reversePut(map,"6","-...."); reversePut(map,"7","--..."); reversePut(map,"8","---.."); reversePut(map,"9","----.");
		reversePut(map,".",".-.-.-"); reversePut(map,",","--..--"); reversePut(map,"?","..--.."); reversePut(map,"'",".----."); 
		reversePut(map,"!","-.-.--"); reversePut(map,"/","-..-."); reversePut(map,"(","-.--."); reversePut(map,")","-.--.-");
		reversePut(map,"&",".-..."); reversePut(map,":","---..."); reversePut(map,";","-.-.-."); reversePut(map,"=","-...-");
		reversePut(map,"=","-...-"); reversePut(map,"+",".-.-."); reversePut(map,"-","-....-"); reversePut(map,"_","..--.-");
		reversePut(map,"\"",".-..-."); reversePut(map,"@",".--.-."); reversePut(map," ","!");
		
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringBuilder sb=new StringBuilder();
			sb.append("Message #");
			sb.append(testCase);
			sb.append("\n");
			
			StringTokenizer st=new StringTokenizer(br.readLine().replaceAll("\\s{2,}"," ! "));
			while (st.hasMoreTokens()) sb.append(map.get(st.nextToken()));
			
			System.out.println(sb.toString());
			if (testCase<testCaseCount) System.out.println();
		}
	}
}