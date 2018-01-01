import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

class Main {
	
	public static void addToMap (TreeMap<Integer,HashMap<String,Integer>> map, String s) {
		int length=s.length();
		if (!map.containsKey(length)) map.put(length, new HashMap<>());
		map.get(length).put(s,map.get(length).getOrDefault(s,0)+1);
	}
	
	public static void removeFromMap (TreeMap<Integer,HashMap<String,Integer>> map, String s) {
		int length=s.length();
		map.get(length).put(s,map.get(length).get(s)-1);
		if (map.get(length).get(s)==0) map.get(length).remove(s);
		if (map.get(length).size()==0) map.remove(length);
	}
	
	public static boolean solutionOK (String sol, TreeMap<Integer,HashMap<String,Integer>> map, int pairCountLeft) {
		if (map.size()==0) return true;
		else {
			boolean flag=false;
			int length=sol.length();
			Integer [] keySet = map.keySet().toArray(new Integer [map.keySet().size()]);
			for (int key : keySet) if (length/2<=key) {
				HashMap<String,Integer> leftMap=map.get(key);
				String [] leftSet = leftMap.keySet().toArray(new String [leftMap.keySet().size()]);
				for (String s1 : leftSet) if (!flag) {
					removeFromMap(map,s1);
					int pairLength=length-key;
					HashMap<String,Integer> rightMap=map.get(pairLength);
					String [] rightSet = rightMap.keySet().toArray(new String [rightMap.keySet().size()]);
					for (String s2 : rightSet) {
						if (!flag && (s1+s2).equals(sol)) {
							removeFromMap(map,s2);
							flag = solutionOK(sol,map,pairCountLeft-1);
							addToMap(map,s2);
						} else if (!flag && (s2+s1).equals(sol)) {
							removeFromMap(map,s2);
							flag = solutionOK(sol,map,pairCountLeft-1);
							addToMap(map,s2);
						}
					}
					addToMap(map,s1);
				}
			}

			return flag;
		}
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine(); //empty line
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			TreeMap<Integer,HashMap<String,Integer>> map=new TreeMap<>();
			String s;
			int sCount=0;
			while (true) {
				s=br.readLine();
				if (s!=null && s.length()>0) {
					addToMap(map,s);
					sCount++;
				} else {
					break;
				}
			}
			
			int minLength=map.firstKey();
			int maxLength=map.lastKey();
			TreeSet<String> possibleSol=new TreeSet<>();
			for (String s1 : map.get(minLength).keySet()) for (String s2 : map.get(maxLength).keySet()) {
				possibleSol.add(s1+s2);
				possibleSol.add(s2+s1);
			}
			
			boolean flag=false;
			for (String sol : possibleSol) {
				flag=solutionOK(sol,map,sCount/2);
				if (flag) {
					printSolution(testCase,sol);
					break;
				}
			}

			if (!flag) printSolution(testCase,possibleSol.iterator().next());
		}
	}
	
	public static void printSolution (int tID, String sol) {
		if (tID>0) System.out.println();
		System.out.println(sol);
	}
}