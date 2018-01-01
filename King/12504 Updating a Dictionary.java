import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class Main {
	
	public static void updateDict (Map<String,String> dict, String str) {
		if (!str.equals("{}")) {
			str=str.substring(1,str.length()-1);
			StringTokenizer st=new StringTokenizer(str,",");
			while (st.hasMoreTokens()) {
				StringTokenizer st2=new StringTokenizer(st.nextToken(),":");
				dict.put(st2.nextToken(), st2.nextToken());
			}
		}
	}
	
	public static String toStr (String prefix, Set<String> set) {
		if (set.size()>0) {
			StringBuilder sb=new StringBuilder();
			sb.append(prefix);
			for (String s : set) {
				sb.append(s);
				sb.append(',');
			}
			sb.setLength(sb.length()-1);
			sb.append('\n');
			return sb.toString();
		}
		return "";
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int i=0;i<testCaseCount;i++) {
			TreeMap<String,String> oldDict=new TreeMap<>();
			TreeMap<String,String> newDict=new TreeMap<>();
			
			updateDict(oldDict,br.readLine());
			updateDict(newDict,br.readLine());
			
			TreeSet<String> newKeys=new TreeSet<>();
			newKeys.addAll(newDict.keySet());
			newKeys.removeAll(oldDict.keySet());
			
			TreeSet<String> removedKeys=new TreeSet<>();
			removedKeys.addAll(oldDict.keySet());
			removedKeys.removeAll(newDict.keySet());
			
			TreeSet<String> changedKeys=new TreeSet<>();
			changedKeys.addAll(oldDict.keySet());
			changedKeys.retainAll(newDict.keySet());
			String [] changedKeysAry=changedKeys.toArray(new String [changedKeys.size()]);
			for (String s : changedKeysAry) if (oldDict.get(s).equals(newDict.get(s))) changedKeys.remove(s);
			
			StringBuilder sb=new StringBuilder();
			sb.append(toStr("+",newKeys));
			sb.append(toStr("-",removedKeys));
			sb.append(toStr("*",changedKeys));
			
			if (sb.length()==0) sb.append("No changes\n");
			
			System.out.println(sb.toString());
		}
	}

}
