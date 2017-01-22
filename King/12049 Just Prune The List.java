import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			HashMap<Integer,Integer> set1=new HashMap<>();
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				int num=Integer.parseInt(st.nextToken());
				set1.put(num,set1.getOrDefault(num,0)+1);
			}
			
			HashMap<Integer,Integer> set2=new HashMap<>();
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<M;i++) {
				int num=Integer.parseInt(st.nextToken());
				set2.put(num,set2.getOrDefault(num,0)+1);
			}
			
			for (int key : set1.keySet()) {
				int value=Math.min(set1.get(key),set2.getOrDefault(key,0));
				set1.put(key,set1.get(key)-value);
				set2.put(key,set2.getOrDefault(key,0)-value);
			}
			
			System.out.println(set1.values().stream().reduce(0,Integer::sum)+set2.values().stream().reduce(0,Integer::sum));
		}
	}
}