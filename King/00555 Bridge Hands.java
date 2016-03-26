import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Main {
	
	static HashMap<Character,Integer> value=new HashMap<>();
	static HashMap<Character,Integer> suitValue=new HashMap<>();
	
	static class Card implements Comparable<Card> {
		int value;
		int suit;
		char valueC;
		char suitC;
		
		@Override
		public int compareTo(Card c) {
			if (this.suit!=c.suit) {
				return this.suit-c.suit;
			}
			return this.value-c.value;
		}
	}
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		for (int i=2;i<11;i++) {
			value.put((char)(i+'0'), i);
		}
		value.put('T', 10);
		value.put('J', 11);
		value.put('Q', 12);
		value.put('K', 13);
		value.put('A', 14);
		
		char [] suits={'C','D','S','H'};
		for (int i=0;i<suits.length;i++) {
			suitValue.put(suits[i],i);
		}
		
		char [] players={'N','E','S','W'};
		HashMap<Character,Integer> playerPos=new HashMap<>();
		for (int i=0;i<players.length;i++) {
			playerPos.put(players[i], i);
		}
		
		char [] displaySeq={'S','W','N','E'};
		while (!(s=br.readLine()).equals("#")) {
			int startingPlayer=(playerPos.get(s.charAt(0))+1)%players.length;
			StringBuilder sb=new StringBuilder(br.readLine());
			sb.append(br.readLine());
			
			ArrayList<Card> [] cardList=new ArrayList [4];
			for (int i=0;i<cardList.length;i++) {
				cardList[i]=new ArrayList<>();
			}
			
			int currPlayer=startingPlayer;
			String cardStr=sb.toString();
			for (int i=0;i<cardStr.length();i+=2) {
				Card c=new Card();
				c.suitC=cardStr.charAt(i);
				c.valueC=cardStr.charAt(i+1);
				c.suit=suitValue.get(c.suitC);
				c.value=value.get(c.valueC);
				cardList[currPlayer].add(c);
				currPlayer=(currPlayer+1)%players.length;
			}
			
			for (int i=0;i<cardList.length;i++) {
				Collections.sort(cardList[i]);
			}
			
			String [] str=new String [4];
			for (int i=0;i<cardList.length;i++) {
				sb=new StringBuilder();
				sb.append(players[i]);
				sb.append(": ");
				for (int i2=0;i2<cardList[i].size();i2++) {
					Card c=cardList[i].get(i2);
					sb.append(c.suitC);
					sb.append(c.valueC);
					sb.append(" ");
				}
				str[i]=sb.toString();
				str[i]=str[i].substring(0, str[i].length()-1);
				currPlayer=(currPlayer+1)%players.length;
			}
			
			sb=new StringBuilder();
			for (int i=0;i<displaySeq.length;i++) {
				sb.append(str[playerPos.get(displaySeq[i])]);
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}
}