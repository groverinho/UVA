import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			LinkedList<String> cardValue=new LinkedList<> ();
			while (st.hasMoreTokens()) {
				String s=st.nextToken();
				cardValue.addFirst(s);
			}
			
			LinkedList<String> topCards=new LinkedList<>();
			for (int i=0;i<25;i++) {
				topCards.addLast(cardValue.removeFirst());
			}
			
			int Y=0;
			for (int loopC=0;loopC<3;loopC++) {
				int X=0;
				String s=cardValue.removeFirst();
				if (Character.isDigit(s.charAt(0))) {
					X=s.charAt(0)-'0';
				} else {
					X=10;
				}
				Y+=X;
				for (int i=0;i<10-X;i++) {
					cardValue.removeFirst();
				}
			}
			
			for (int i=0;i<25;i++) {
				cardValue.addFirst(topCards.removeLast());
			}

			StringBuilder sb=new StringBuilder("Case ");
			sb.append(testCase);
			sb.append(": ");
			sb.append(cardValue.get(cardValue.size()-Y));
			System.out.println(sb.toString());
		}

	}
}