import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	
	public static boolean isProperSubset (HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> testSet1=new HashSet<>();
		testSet1.addAll(set1);
		
		testSet1.removeAll(set2);
		return set2.size()>set1.size() && testSet1.size()==0;
	}
	
	public static boolean isDisjoint (HashSet<Integer> set1, HashSet<Integer> set2) {
		HashSet<Integer> testSet1=new HashSet<>();
		testSet1.addAll(set1);
		
		HashSet<Integer> testSet2=new HashSet<>();
		testSet2.addAll(set2);
		
		testSet1.removeAll(set2);
		testSet2.removeAll(set1);
		
		return testSet1.size()==set1.size() && testSet2.size()==set2.size();
	}
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while ((s=br.readLine())!=null) {
			HashSet<Integer> setA=new HashSet<>();
			HashSet<Integer> setB=new HashSet<>();
			
			StringTokenizer st=new StringTokenizer(s);
			while (st.hasMoreTokens()) setA.add(Integer.parseInt(st.nextToken()));
			
			st=new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) setB.add(Integer.parseInt(st.nextToken()));
			
			
			if (setA.equals(setB)) System.out.println("A equals B");
			else if (isProperSubset(setB,setA)) System.out.println("B is a proper subset of A");
			else if (isProperSubset(setA,setB)) System.out.println("A is a proper subset of B");
			else if (isDisjoint(setA,setB)) System.out.println("A and B are disjoint");
			else System.out.println("I'm confused!");
		}
	}
	
}