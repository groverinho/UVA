import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> strToValue=new HashMap<>();
		HashMap<String,Boolean> oudler=new HashMap<>();
		StringBuilder sb;
		
		String [] trumpValues=new String [] {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","twenty-one"};
		for (int i=1;i<trumpValues.length-1;i++) {
			sb=new StringBuilder(trumpValues[i]);
			sb.append(" of trumps");
			strToValue.put(sb.toString(), 1);
		}
		//1
		sb=new StringBuilder(trumpValues[0]);
		sb.append(" of trumps");
		strToValue.put(sb.toString(), 9);
		oudler.put(sb.toString(),true);
		
		//21
		sb=new StringBuilder(trumpValues[20]);
		sb.append(" of trumps");
		strToValue.put(sb.toString(), 9);
		oudler.put(sb.toString(),true);
		
		//21
		strToValue.put("fool", 9);
		oudler.put("fool",true);
		
		String [] normalWords = new String [] {"ace","two","three","four","five","six","seven","eight","nine","ten","jack","knight","queen","king"};
		String [] normalSuits = new String [] {"spades","diamonds","hearts","clubs"};
		int [] v={1,1,1,1,1,1,1,1,1,1,3,5,7,9};
		
		for (int i=0;i<normalSuits.length;i++) {
			for (int i2=0;i2<normalWords.length;i2++) {
				sb=new StringBuilder(normalWords[i2]);
				sb.append(" of ");
				sb.append(normalSuits[i]);
				strToValue.put(sb.toString(),v[i2]);
			}
		}
		
		int [] targetScores={56,51,41,36};
		
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int cardCount=Integer.parseInt(br.readLine());
			String [] cards=new String [cardCount];
			for (int i=0;i<cardCount;i++) {
				cards[i]=br.readLine();
			}
			
			int oudlersCount=0;
			for (int i=0;i<cardCount;i++) {
				if (oudler.containsKey(cards[i])) {
					oudlersCount++;
				}
			}
			
			int targetScore=targetScores[oudlersCount];
			int score=0;
			for (int i=0;i<cardCount;i++) {
				score+=strToValue.get(cards[i]);
			}
			score/=2;
			int diff=score-targetScore;
			
			sb=new StringBuilder();
			if (testCase>1) {
				sb.append("\n");
			}
			sb.append("Hand #");
			sb.append(testCase);
			sb.append("\nGame ");
			if (diff>=0) {
				sb.append("won by ");
				sb.append(diff);
			} else {
				sb.append("lost by ");
				sb.append(-diff);
			}
			sb.append(" point(s).");

			System.out.println(sb.toString());
		}
	}
}