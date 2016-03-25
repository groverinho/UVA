import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		HashMap<Character,Integer> strToValue=new HashMap<>();
		HashMap<Character,Integer> strToSuit=new HashMap<>();
		char [] suits = {'S','H','D','C'};
		
		for (int i=2;i<11;i++) {
			strToValue.put((char)(i+'0'), i);
		}
		strToValue.put('T', 10);
		strToValue.put('J', 11);
		strToValue.put('Q', 12);
		strToValue.put('K', 13);
		strToValue.put('A', 14);
		
		for (int i=0;i<suits.length;i++) {
			strToSuit.put(suits[i],i);
		}
		
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int [] value=new int [13];
			int [] suit=new int [13];
			int [] suitExistsCount=new int [4];
			boolean [] suitStopped=new boolean [4];
			
			for (int i=0;i<value.length;i++) {
				String card=st.nextToken();
				value[i]=strToValue.get(card.charAt(0));
				suit[i]=strToSuit.get(card.charAt(1));
				suitExistsCount[suit[i]]++;
			}
			
			int sum=0;
			//Rule 1 :
			for (int i=0;i<value.length;i++) {
				if (value[i]>=11) {
					sum+=(value[i]-10);
				}
			}

			//Rule 2 - 4 :
			for (int i=0;i<value.length;i++) {
				if (value[i]>=11 && value[i]<=14) {
					if (suitExistsCount[suit[i]]<=14-value[i]) {
						sum--;
					}
				}
			}
			
			int rule567Value=0;
			//Rule 5, 6 & 7
			for (int i=0;i<suitExistsCount.length;i++) {
				if (suitExistsCount[i]==2) {
					sum++;
					rule567Value++;
				} else if (suitExistsCount[i]<=1) {
					sum+=2;
					rule567Value+=2;
				}
			}
			
			//Check if suit stopped.
			for (int i=0;i<suitStopped.length;i++) {
				for (int currValue=14;currValue>11;currValue--) {
					if (!suitStopped[i]) {
						for (int i2=0;i2<value.length;i2++) {
							if (suit[i2]==i && value[i2]==currValue) {
								suitStopped[i]=(suitExistsCount[suit[i2]]>=15-currValue);
								break;
							}
						}
					}
				}
			}
			boolean allSuitStopped=suitStopped[0]&&suitStopped[1]&&suitStopped[2]&&suitStopped[3];
			
			if (sum<14) {
				System.out.println("PASS");
			} else if (sum-rule567Value>=16 && allSuitStopped) {
				System.out.println("BID NO-TRUMP");
			} else {
				int suitWithMaxExists=0;
				for (int i=1;i<suitExistsCount.length;i++) {
					if (suitExistsCount[suitWithMaxExists]<suitExistsCount[i]) {
						suitWithMaxExists=i;
					}
				}
				System.out.println("BID "+suits[suitWithMaxExists]);
			}
		}
	}
}