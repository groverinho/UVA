import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
	
	public static class Solution implements Comparable<Solution> {
		private int [] values;
		
		public Solution (int a, int b, int c, int d) {
			values=new int [] {a,b,c,d};
		}
		
		public String toString() {
			StringBuilder sb=new StringBuilder();
			sb.append("Cube = ");
			sb.append(values[0]);
			sb.append(", Triple = (");
			sb.append(values[1]);
			sb.append(',');
			sb.append(values[2]);
			sb.append(',');
			sb.append(values[3]);
			sb.append(')');
			return sb.toString();
		}
		
		public int compareTo(Solution s) {
			for (int i=0;i<this.values.length;i++) if (this.values[i]!=s.values[i]) return this.values[i]-s.values[i];
			return 0;
		}
	}
	
	public static void main (String [] args) throws IOException {
		double [] cube=new double [201];
		for (int i=0;i<cube.length;i++) cube[i]=i*i*i;
		
		PriorityQueue<Solution> list=new PriorityQueue<>();
		for (int b=2;b<=198;b++) {
			for (int c=b+1;c<=199;c++) {
				if (Math.cbrt(cube[b]+cube[c])<200) {
					for (int d=c+1;d<=200;d++) {
						int index=Arrays.binarySearch(cube,cube[b]+cube[c]+cube[d]);
						if (index>=0) list.add(new Solution(index,b,c,d));
					}
				} else break;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		while (!list.isEmpty()) {
			sb.append(list.poll().toString());
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
}