import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	public static class Location {
		public double x, y;
		public ArrayList<Location> adjList;
		public int hop=-1;
		
		public Location(double dx, double dy) {
			this.x=dx;
			this.y=dy;
			this.adjList=new ArrayList<>();
		}
	}
	
	public static double distanceBetween (Location l1, Location l2) {
		double dx=l1.x-l2.x;
		double dy=l1.y-l2.y;
		return Math.sqrt(dx*dx+dy*dy);
	}
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null && !s.equals("0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			double maxDistance=Double.parseDouble(st.nextToken())*Double.parseDouble(st.nextToken())*60;
			
			ArrayList<Location> list=new ArrayList<>();
			while ((s=br.readLine())!=null && !s.isEmpty()) {
				st=new StringTokenizer(s);
				list.add(new Location(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())));
			}
			
			for (int i=0;i<list.size();i++) for (int i2=i+1;i2<list.size();i2++) {
				Location l1=list.get(i);
				Location l2=list.get(i2);
				if (distanceBetween(l1,l2)<=maxDistance) {
					l1.adjList.add(l2);
					l2.adjList.add(l1);
				}
			}
			
			Location start=list.get(0);
			Location end=list.get(1);
			
			Queue<Location> queue=new ArrayDeque<>();

			
			queue.add(start);
			start.hop=0;
			
			while (!queue.isEmpty()) {
				Location curr=queue.poll();
				if (curr.equals(end)) break;
				else {
					for (Location next : curr.adjList) if (next.hop==-1) {
						next.hop=curr.hop+1;
						queue.add(next);
					}
				}
			}
			
			if (end.hop==-1) System.out.println("No.");
			else System.out.println("Yes, visiting "+(end.hop-1)+" other holes.");
		}
	}
	
}
