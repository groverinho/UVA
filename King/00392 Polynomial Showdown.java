import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		String [] postfix=new String[9];
		postfix[0]="";
		postfix[1]="x";
		for (int i=2;i<postfix.length;i++) postfix[i]="x^"+(i);
		
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int [] coeff=new int[9];
			for (int i=coeff.length-1;i>=0;i--) coeff[i]=Integer.parseInt(st.nextToken());
			
			StringBuilder sb=new StringBuilder();
			for (int i=coeff.length-1;i>=0;i--) {
				if (coeff[i]==1) {
					if (sb.length()>0) sb.append(" + ");
					if (i==0) sb.append(1);
					sb.append(postfix[i]);
				} else if (coeff[i]==-1) {
					if (sb.length()>0) sb.append(" - "); else sb.append('-');
					if (i==0) sb.append(1);
					sb.append(postfix[i]);
				} else if (coeff[i]>1) {
					if (sb.length()>0) sb.append(" + ");
					sb.append(coeff[i]);
					sb.append(postfix[i]);
				} else if (coeff[i]<-1) {
					if (sb.length()>0) sb.append(" - ");
					else sb.append('-');
					sb.append(coeff[i]*-1);
					sb.append(postfix[i]);
				}
			}
			
			if (sb.length()==0) sb.append("0");
			System.out.println(sb.toString());
		}
	}
}