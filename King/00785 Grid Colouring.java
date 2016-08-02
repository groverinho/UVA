import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static char [][] mat;
	
	public static void floodfill (int x, int y, char c) {
		if (x>=0 && x<mat.length && y>=0 && y<mat[x].length && mat[x][y]==' ') {
			mat[x][y]=c;
			floodfill(x-1,y,c);
			floodfill(x+1,y,c);
			floodfill(x,y-1,c);
			floodfill(x,y+1,c);
		}
	}
	
	public static boolean isFullUnderscore (String s) {
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i)!='_') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			ArrayList<String> slist=new ArrayList<>();
			
			while (true) {
				slist.add(s);
				if (isFullUnderscore(s)) {
					break;
				}
				s=br.readLine();
			}

			mat=new char [slist.size()][];
			for (int i=0;i<mat.length;i++) {
				mat[i]=slist.get(i).toCharArray();
			}
			
			for (int i=0;i<mat.length;i++) {
				for (int i2=0;i2<mat[i].length;i2++) {
					if (mat[i][i2]!='_' && mat[i][i2]!=' ' && mat[i][i2]!='X') {
						char c=mat[i][i2];
						mat[i][i2]=' ';
						floodfill(i,i2,c);
					}
				}
			}
			
			for (int i=0;i<mat.length;i++) {
				System.out.println(new String(mat[i]));
			}
		}
	}
	
}