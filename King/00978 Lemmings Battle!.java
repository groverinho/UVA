import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int B=Integer.parseInt(st.nextToken());
			int SG=Integer.parseInt(st.nextToken());
			int SB=Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> greenQueue=new PriorityQueue<>(Collections.reverseOrder());
			for (int i=0;i<SG;i++) greenQueue.add(Integer.parseInt(br.readLine()));
			
			PriorityQueue<Integer> blueQueue=new PriorityQueue<>(Collections.reverseOrder());
			for (int i=0;i<SB;i++) blueQueue.add(Integer.parseInt(br.readLine()));
			
			int [] greenLeftover=new int [B]; int greenLeftoverCount=0;
			int [] blueLeftover=new int [B]; int blueLeftoverCount=0;
			
			while (greenQueue.size()>0 && blueQueue.size()>0) {
				greenLeftoverCount=0;
				blueLeftoverCount=0;
				int round=Math.min(B,Math.min(greenQueue.size(),blueQueue.size()));
				for (int i=0;i<round;i++) {
					int green=greenQueue.poll();
					int blue=blueQueue.poll();
					if (green>blue) greenLeftover[greenLeftoverCount++]=green-blue;
					else if (blue>green) blueLeftover[blueLeftoverCount++]=blue-green;
				}
				
				for (int i=0;i<greenLeftoverCount;i++) greenQueue.add(greenLeftover[i]);
				for (int i=0;i<blueLeftoverCount;i++) blueQueue.add(blueLeftover[i]);
			}
			
			if (testCase>0) System.out.println();
			if (greenQueue.size()==0 && blueQueue.size()==0) System.out.println("green and blue died");
			else if (greenQueue.size()>0) {
				System.out.println("green wins");
				while (greenQueue.size()>0) System.out.println(greenQueue.poll());
			} else {
				System.out.println("blue wins");
				while (blueQueue.size()>0) System.out.println(blueQueue.poll());
			}
		}
	}
}