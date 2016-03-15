import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char [] mirror=new char [128];
		mirror['A']='A';
		mirror['E']='3';
		mirror['3']='E';
		mirror['H']='H';
		mirror['I']='I';
		mirror['J']='L';
		mirror['L']='J';
		mirror['M']='M';
		mirror['O']='O';
		mirror['S']='2';
		mirror['2']='S';
		mirror['T']='T';
		mirror['U']='U';
		mirror['V']='V';
		mirror['W']='W';
		mirror['X']='X';
		mirror['Y']='Y';
		mirror['Z']='5';
		mirror['5']='Z';
		mirror['1']='1';
		mirror['8']='8';
		
		String s;

		while ((s=br.readLine())!=null && !s.equals("")) {
			boolean isPalin = true;
			boolean isMir = true;
			char [] c=s.replace("0","O").toCharArray();
			
			//check palin.
			for (int i=0;i<c.length/2 && isPalin;i++) {
				isPalin = (c[i]==c[c.length-1-i]);
			}
			
			for (int i=0;i<c.length/2 && isMir;i++) {
				isMir = (mirror[c[i]]==c[c.length-1-i]);
			}
			if (c.length%2==1) {
				isMir = isMir && mirror[c[c.length/2]]==c[c.length/2];
			}
			
			StringBuilder sb=new StringBuilder(s);
			if (!isPalin && !isMir) {
				sb.append(" -- is not a palindrome.\n");
			}else if (isPalin && !isMir) {
				sb.append(" -- is a regular palindrome.\n");
			} else if (!isPalin && isMir) {
				sb.append(" -- is a mirrored string.\n");
			} else {
				sb.append(" -- is a mirrored palindrome.\n");
			}
			
			System.out.println(sb.toString());
		}
	}
}