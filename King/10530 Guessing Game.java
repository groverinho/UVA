import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		boolean [] impossibleFlag=new boolean [11];
		
		while (!(s=br.readLine()).equals("0")) {
			int guess=Integer.parseInt(s);
			s=br.readLine();
			switch (s) {
				case "too low" : {
					for (int i=guess;i>=1;i--) {
						impossibleFlag[i]=true;
					}
					break;
				}
				case "right on" : {
					if (!impossibleFlag[guess]) {
						System.out.println("Stan may be honest");
					} else {
						System.out.println("Stan is dishonest");
					}
					Arrays.fill(impossibleFlag, false);
					break;
				}
				case "too high" : {
					for (int i=guess;i<impossibleFlag.length;i++) {
						impossibleFlag[i]=true;
					}
					break;
				}
			}
		}
	}
}