import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	
	public static char [][] mat;
	
	public static void floodfill (int currX, int currY) {
		if (currX>=0 && currX<mat.length && currY>=0 && currY<mat[currX].length && mat[currX][currY]==' ') {
			mat[currX][currY]='#';
			floodfill(currX-1,currY);
			floodfill(currX+1,currY);
			floodfill(currX,currY-1);
			floodfill(currX,currY+1);
		}
	}
	
	public static boolean fullUnderscore (String s) {
		boolean flag=true;
		for (int i=0;i<s.length() && flag;i++) {
			flag=s.charAt(i)=='_';
		}
		return flag;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			ArrayList<String> sList=new ArrayList<>();
			
			String s;
			while (true) {
				s=br.readLine();
				sList.add(s);
				if (fullUnderscore(s)) {
					break;
				}
			}
			
			mat=new char [sList.size()][];
			for (int i=0;i<mat.length;i++) {
				mat[i]=sList.get(i).toCharArray();
			}
			
			for (int i=0;i<mat.length;i++) {
				for (int i2=0;i2<mat[i].length;i2++) {
					if (mat[i][i2]=='*') {
						mat[i][i2]=' ';
						floodfill(i,i2);
					}
				}
			}
			
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<mat.length;i++) {
				sb.append(new String(mat[i]));
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}
	
}