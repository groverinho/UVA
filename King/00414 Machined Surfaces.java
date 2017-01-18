import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static int spaceCount (String s) {
		int count=0;
		for (char c : s.toCharArray()) if (c==' ') count++;
		return count;
	}
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while (!(s=br.readLine()).equals("0")) {
			int rowsCount=Integer.parseInt(s);
			int [] spaces=new int [rowsCount];
			int minSpace=Integer.MAX_VALUE;
			for (int i=0;i<rowsCount;i++) {
				spaces[i]=spaceCount(br.readLine());
				minSpace=Math.min(minSpace,spaces[i]);
			}
			
			int voids=0;
			for (int i=0;i<rowsCount;i++) voids+=(spaces[i]-minSpace);
			System.out.println(voids);
		}
	}
}