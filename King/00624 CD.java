import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static int currMax=0;
	public static int [] answer;
	public static int answerLevel=0;
	
	public static void search (int [] count, int countStartIndex, int [] stored, int storedLevel, int value, int max) {
		if (value>max) {
			return;
		} else {
			if (value>currMax) {
				answer=Arrays.copyOf(stored, storedLevel);
				answerLevel=storedLevel;
				currMax=value;
			}
			for (int i=countStartIndex;i<count.length;i++) {
				stored[storedLevel]=count[i];
				search(count,i+1,stored,storedLevel+1,value+stored[storedLevel],max);
				stored[storedLevel]=0;
			}
		}
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			currMax=0;
			answerLevel=0;
			StringTokenizer st=new StringTokenizer(s);
			int max=Integer.parseInt(st.nextToken());
			int [] count=new int [Integer.parseInt(st.nextToken())];
			for (int i=0;i<count.length;i++) {
				count[i]=Integer.parseInt(st.nextToken());
			}
			search(count,0,new int [count.length],0,0,max);
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<answerLevel;i++) {
				sb.append(answer[i]);
				sb.append(' ');
			}
			sb.append("sum:");
			sb.append(currMax);
			System.out.println(sb.toString());
		}
	}
}