import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void fill (char [][] pixel, int x1, int y1, int x2, int y2, char c) {
		for (int i=Math.min(x1,x2);i<=Math.max(x1,x2);i++) for (int i2=Math.min(y1,y2);i2<=Math.max(y1,y2);i2++) pixel[i][i2]=c;
	}
	
	public static void floodfill (char [][] pixel, int x, int y, char find, char fill) {
		for (int i=Math.max(x-1,0);i<=Math.min(x+1,pixel.length-1);i++) {
			for (int i2=Math.max(y-1,0);i2<=Math.min(y+1,pixel[0].length-1);i2++) {
				if (pixel[i][i2]==find) {
					pixel[i][i2]=fill;
					floodfill(pixel,i,i2,find,fill);
				}
			}
		}

	}
	
	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		char [][] pixel=null;
		while (!(s=br.readLine()).equals("X")) {
			StringTokenizer st=new StringTokenizer(s);
			String op=st.nextToken();
			switch (op) {
				case "I" : {
					int Y=Integer.parseInt(st.nextToken());
					int X=Integer.parseInt(st.nextToken());
					pixel=new char [X][Y];
					fill(pixel,0,0,pixel.length-1,pixel[0].length-1,'O');
					break;
				}
				case "C" : {
					fill(pixel,0,0,pixel.length-1,pixel[0].length-1,'O');
					break;
				}
				case "L" : {
					int Y=Integer.parseInt(st.nextToken())-1;
					int X=Integer.parseInt(st.nextToken())-1;
					pixel[X][Y]=st.nextToken().charAt(0);
					break;
				}
				case "V" : {
					int Y=Integer.parseInt(st.nextToken())-1;
					int X1=Integer.parseInt(st.nextToken())-1;
					int X2=Integer.parseInt(st.nextToken())-1;
					fill(pixel,X1,Y,X2,Y,st.nextToken().charAt(0));
					break;
				}
				case "H" : {
					int Y1=Integer.parseInt(st.nextToken())-1;
					int Y2=Integer.parseInt(st.nextToken())-1;
					int X=Integer.parseInt(st.nextToken())-1;
					fill(pixel,X,Y1,X,Y2,st.nextToken().charAt(0));
					break;
				}
				case "K" : {
					int Y1=Integer.parseInt(st.nextToken())-1;
					int X1=Integer.parseInt(st.nextToken())-1;
					int Y2=Integer.parseInt(st.nextToken())-1;
					int X2=Integer.parseInt(st.nextToken())-1;
					fill(pixel,X1,Y1,X2,Y2,st.nextToken().charAt(0));
					break;
				}
				case "F" : {
					int Y=Integer.parseInt(st.nextToken())-1;
					int X=Integer.parseInt(st.nextToken())-1;
					char fill=st.nextToken().charAt(0);
					if (fill!=pixel[X][Y]) floodfill(pixel,X,Y,pixel[X][Y],fill);
					break;
				}
				case "S" : {
					StringBuilder sb=new StringBuilder();
					sb.append(st.nextToken());
					sb.append('\n');
					for (char [] cAry : pixel) {
						for (char c : cAry) sb.append(c);
						sb.append('\n');
					}
					System.out.print(sb.toString());
					break;
				}
			}
		}
	}
}