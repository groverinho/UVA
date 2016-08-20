import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[]args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0 0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			int [] coor=new int [4];
			for (int i=0;i<coor.length;i++) {
				coor[i]=Integer.parseInt(st.nextToken());
			}
			
			if (coor[0]==coor[2] && coor[1]==coor[3]) {
				System.out.println("0");
			} else if (Math.abs(coor[0]-coor[2])==Math.abs(coor[1]-coor[3]) || coor[0]==coor[2] || coor[1]==coor[3]) {
				System.out.println("1");
			} else {
				System.out.println("2");
			}
		}
	}
	
}