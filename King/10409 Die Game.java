import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while (!(s=br.readLine()).equals("0")) {
			int opCount=Integer.parseInt(s);
			int north=2;
			int top=1;
			int south=5;
			int bottom=6;
			int west=3;
			int east=4;
			
			for (int i=0;i<opCount;i++) {
				s=br.readLine();
				switch (s) {
					case "north" : {
						int temp=north;
						north=top;
						top=south;
						south=bottom;
						bottom=temp;
						break;
					}
					case "south" : {
						int temp=bottom;
						bottom=south;
						south=top;
						top=north;
						north=temp;
						break;
					}
					case "east" : {
						int temp=bottom;
						bottom=east;
						east=top;
						top=west;
						west=temp;
						break;
					}
					case "west" : {
						int temp=bottom;
						bottom=west;
						west=top;
						top=east;
						east=temp;
						break;
					}
				}
			}
			System.out.println(top);
		}
	}
}