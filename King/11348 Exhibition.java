import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
			int N=Integer.parseInt(br.readLine());
			for (int n=0;n<N;n++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int M=Integer.parseInt(st.nextToken());
				for (int m=0;m<M;m++) {
					int a=Integer.parseInt(st.nextToken());
					if (!map.containsKey(a)) map.put(a, new HashSet<>());
					map.get(a).add(n);
				}
			}
			for (int key : map.keySet().toArray(new Integer [map.keySet().size()])) if (map.get(key).size()!=1) map.remove(key);
			
			double [] bd=new double [N];
			if (map.size()!=0) {
				double total=0.0;
				for (HashSet<Integer> v : map.values()) {
					int id=v.iterator().next();
					bd[id]++;
					total++;
				}
				
				for (int i=0;i<bd.length;i++) bd[i]=(bd[i]*100.0)/total;
			} else for (int i=0;i<bd.length;i++) bd[i]=100.0/bd.length;
			
			StringBuilder sb=new StringBuilder();
			sb.append("Case ");
			sb.append(testCase);
			sb.append(':');
			for (int i=0;i<bd.length;i++) {
				sb.append(" ");
				sb.append(String.format("%.6f%%",bd[i]));
			}
			System.out.println(sb.toString());
		}
	}

}
