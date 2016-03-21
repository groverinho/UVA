import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Euler {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine();
			int n=Integer.parseInt(br.readLine());
			char [][] mines=new char [n][n];
			for (int i=0;i<n;i++) {
				mines[i]=br.readLine().toCharArray();
			}
			
			char [][] outputHL=new char [n][n];
			for (int i=0;i<n;i++) {
				outputHL[i]=br.readLine().toCharArray();
			}
			
			int [][] value=new int [n][n];
			for (int i=0;i<n;i++) {
				for (int i2=0;i2<n;i2++) {
					if (outputHL[i][i2]=='x') {
						//search surround mines.
						for (int x=i-1;x<=i+1;x++) {
							for (int y=i2-1;y<=i2+1;y++) {
								if (x>=0 && x<n && y>=0 && y<n && mines[x][y]=='*') {
									value[i][i2]++;
								}
							}
						}
					}
				}
			}
			
			boolean showMine=false;
			for (int i=0;i<n && !showMine;i++) {
				for (int i2=0;i2<n && !showMine;i2++) {
					showMine=(mines[i][i2]=='*' && outputHL[i][i2]=='x');
				}
			}
			
			StringBuilder sb=new StringBuilder();
			if (testCase>0) {
				sb.append("\n");
			}
			
			for (int i=0;i<n;i++) {
				for (int i2=0;i2<n;i2++) {
					if (outputHL[i][i2]=='x') {
						if (mines[i][i2]=='.') {
							sb.append(value[i][i2]);
						} else {
							sb.append('*');
						}	
					} else {
						if (showMine && mines[i][i2]=='*') {
							sb.append('*');
						} else {
							sb.append('.');
						}
					}
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}
}