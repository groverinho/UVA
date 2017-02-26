import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static void main (String [] args) throws IOException {
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<62;i++) sb.append(' ');
		String emptySpace=sb.toString();
		
		sb=new StringBuilder();
		for (int i=0;i<60;i++) sb.append('-');
		sb.append('\n');
		String header=sb.toString();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			
			if (n==0) {
				System.out.print(header.toString());
			} else {
				String [] names=new String [n];
				for (int i=0;i<names.length;i++) names[i]=br.readLine();
				Arrays.sort(names);
				
				int columnSize=Arrays.stream(names).mapToInt(name -> name.length()).max().getAsInt();
				int columnCount=((60-columnSize)/(columnSize+2))+1;
				
				int rowCount=(int)Math.ceil(n/(double)columnCount);
				
				StringBuilder [] sbAry=new StringBuilder [rowCount];
				for (int i=0;i<rowCount;i++) sbAry[i]=new StringBuilder();
				
				columnSize+=2;
				for (int i=0;i<n;i++) {
					sbAry[i%rowCount].append(names[i]);
					sbAry[i%rowCount].append(emptySpace.substring(0,columnSize-names[i].length()));
				}
				
				sb=new StringBuilder();
				sb.append(header);
				for (int i=0;i<rowCount;i++) {
					sb.append(sbAry[i].toString());
					sb.deleteCharAt(sb.length()-1);
					sb.deleteCharAt(sb.length()-1);
					sb.append('\n');
				}
				System.out.print(sb.toString());
			}
		}
	}
	
}