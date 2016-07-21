import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int [] numbers=new int [128];
		numbers['A']=2;
		numbers['B']=2;
		numbers['C']=2;
		
		numbers['D']=3;
		numbers['E']=3;
		numbers['F']=3;
		
		numbers['G']=4;
		numbers['H']=4;
		numbers['I']=4;
		
		numbers['J']=5;
		numbers['K']=5;
		numbers['L']=5;
		
		numbers['M']=6;
		numbers['N']=6;
		numbers['O']=6;
		
		numbers['P']=7;
		numbers['Q']=7;
		numbers['R']=7;
		numbers['S']=7;
		
		numbers['T']=8;
		numbers['U']=8;
		numbers['V']=8;
		
		numbers['W']=9;
		numbers['X']=9;
		numbers['Y']=9;
		numbers['Z']=9;
		
		String s;
		while ((s=br.readLine())!=null) {
			char [] c=s.toCharArray();
			for (int i=0;i<c.length;i++) {
				if (Character.isAlphabetic(c[i])) {
					c[i]=(char)(numbers[c[i]]+'0');
				}
			}
			
			System.out.println(c);
		}
	}    
}