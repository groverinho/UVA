import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	public static String [] strs;
	public static int strsCount=0;
	
	public static void dfs (String s, LinkedList<Character> clist, int [][] pairs, int pairsCount, int depth) {
		if (clist.size()==0) {
			int constraintCount=0;
			for (int i=0;i<s.length();i++) {
				for (int i2=i+1;i2<s.length();i2++) {
					constraintCount+=pairs[s.charAt(i)][s.charAt(i2)];
				}
			}
			if (constraintCount == pairsCount) {
				strs[strsCount++]=s;
			}
		} else {
			for (int i=0;i<clist.size();i++) {
				char c=clist.removeFirst();
				dfs(s+c,clist,pairs,pairsCount,depth+1);
				clist.addLast(c);
			}
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int testCase=0;
		while ((s=br.readLine())!=null) {
			String [] str = s.split(" ");
			
			LinkedList<Character> clist=new LinkedList<>();
			for (int i=0;i<str.length;i++) {
				clist.add(str[i].charAt(0));
			}
			
			str = br.readLine().split(" ");
			int [][] pairs = new int [128][128];
			int pairsCount = 0;
			for (int i=0;i<str.length;i+=2) {
				pairs[str[i].charAt(0)][str[i+1].charAt(0)]=1;
				pairsCount++;
			}
			
			if (testCase>0) {
				System.out.println();
			}
			
			strs=new String[300];
			strsCount=0;
			dfs("", clist,pairs,pairsCount,0);
			Arrays.sort(strs,0,strsCount);
			
			for (int i=0;i<strsCount;i++) {
				System.out.println(strs[i]);
			}
			testCase++;
		}
	}
}