import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
	
	private static class Cake implements Comparable<Cake> {
		String n;
		long cost;

		public Cake (String n, long c) {
			this.n=n;
			this.cost=c;
		}
		
		@Override
		public int compareTo(Cake arg0) {
			long diff=this.cost-arg0.cost;
			if (diff==0) return this.n.compareTo(arg0.n);
			else if (diff>0) return 1;
			else return -1;
		}
	}
	public static void main (String [] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			String title=br.readLine().toUpperCase();
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			long B=Integer.parseInt(st.nextToken());
			
			HashMap<String,Integer> map=new HashMap<>();
			for (int m=0;m<M;m++) {
				st=new StringTokenizer(br.readLine());
				map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
			}
			
			TreeSet<Cake> set=new TreeSet<>();
			for (int n=0;n<N;n++) {
				String name=br.readLine();
				int K=Integer.parseInt(br.readLine());
				long b=0;
				for (int k=0;k<K;k++) {
					st=new StringTokenizer(br.readLine());
					b+=(map.get(st.nextToken())*Integer.parseInt(st.nextToken()));
				}
				if (b<=B) set.add(new Cake(name,b));
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append(title);
			sb.append('\n');
			if (set.size()==0) sb.append("Too expensive!\n");
			else for (Cake c : set) sb.append(c.n+"\n");
			
			System.out.println(sb.toString());
		}
	}

}
