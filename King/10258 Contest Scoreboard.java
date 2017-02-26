import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	
	public static class Contestant implements Comparable<Contestant> {
		private int id;
		private int solvedCount;
		private boolean [] solved;
		private int [] penalty;
		private int [] timeTaken;
		private boolean hasSubmission;
		
		public Contestant (int i) {
			this.id=i;
			this.solved=new boolean [10];
			this.penalty=new int [10];
			this.timeTaken=new int [10];
		}
		
		public void input(int qId, char op, int time) {
			hasSubmission=true;
			if (op=='C' && !solved[qId]) {
				solved[qId]=true;
				timeTaken[qId]=time+penalty[qId];
				solvedCount++;
			} else if (op=='I' && !solved[qId]) {
				penalty[qId]+=20;
			}
		}
		
		public boolean hasSubmission() {
			return hasSubmission;
		}
		
		public int getTimeTaken() {
			return Arrays.stream(timeTaken).sum();
		}
		
		public int compareTo(Contestant c) {
			if (this.solvedCount!=c.solvedCount) return this.solvedCount-c.solvedCount;
			if (this.getTimeTaken()!=c.getTimeTaken()) return c.getTimeTaken()-this.getTimeTaken();
			return c.id-this.id;
		}
		
		public String toString() {
			return this.id+" "+this.solvedCount+" "+this.getTimeTaken();
		}
	}
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		br.readLine(); //blank line.
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			String s;
			Contestant [] cList=new Contestant [101];
			while ((s=br.readLine())!=null && !s.isEmpty()) {
				StringTokenizer st=new StringTokenizer(s);
				int cId=Integer.parseInt(st.nextToken());
				if (cList[cId]==null) cList[cId]=new Contestant(cId);
				
				int qId=Integer.parseInt(st.nextToken());
				int time=Integer.parseInt(st.nextToken());
				char c=st.nextToken().charAt(0);
				
				cList[cId].input(qId, c, time);
			}
			
			ArrayList<Contestant> ansList=new ArrayList<>();
			for (int i=0;i<cList.length;i++) if (cList[i]!=null && cList[i].hasSubmission()) ansList.add(cList[i]);
			
			Collections.sort(ansList,Collections.reverseOrder());
			StringBuilder sb=new StringBuilder();
			for (Contestant c : ansList) {
				sb.append(c.toString());
				sb.append('\n');
			}
			
			if (testCase>0) System.out.println();
			System.out.print(sb.toString());
		}
		
	}
	
}