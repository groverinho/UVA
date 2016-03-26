import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0 0 0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int [] princessCard=new int [3];
			boolean [] flag=new boolean [53];
			
			for (int i=0;i<princessCard.length;i++) {
				princessCard[i]=Integer.parseInt(st.nextToken());
				flag[princessCard[i]]=true;
			}
			Arrays.sort(princessCard);
			
			int [] princeCard=new int [2];
			for (int i=0;i<princeCard.length;i++) {
				princeCard[i]=Integer.parseInt(st.nextToken());
				flag[princeCard[i]]=true;
			}
			Arrays.sort(princeCard);
			
			LinkedList<Integer> candidateCards=new LinkedList<>();
			candidateCards.add(princessCard[0]);
			candidateCards.add(princessCard[1]);
			candidateCards.add(princessCard[2]);
			
			int win=2;
			for (int i=princeCard.length-1;i>=0;i--) {
				boolean foundJustLarger=false;
				for (int i2=0;i2<candidateCards.size();i2++) {
					if (candidateCards.get(i2)>princeCard[i]) {
						win--;
						candidateCards.remove(i2);
						foundJustLarger=true;
						break;
					}
				}
				
				if (!foundJustLarger) {
					candidateCards.removeFirst(); //Remove the first card to prevent wastage on bigger card.
				}
			}
			
			if (win==1) {
				boolean found=false;
				for (int i=candidateCards.getFirst()+1;i<53;i++) {
					if (!flag[i]) {
						System.out.println(i);
						found=true;
						break;
					}
				}
				
				if (!found) {
					System.out.println("-1");
				}
			} else if (win==2) {
				for (int i=1;i<candidateCards.getFirst();i++) {
					if (!flag[i]) {
						System.out.println(i);
						break;
					}
				}
			} else {
				System.out.println("-1");
			}
		}
	}
}