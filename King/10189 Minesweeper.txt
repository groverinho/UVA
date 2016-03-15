import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	static void checkAndAdd(int [][] value, int x, int y) {
		for (int i=Math.max(0, x-1);i<Math.min(value.length,x+2);i++) {
			for (int i2=Math.max(0, y-1);i2<Math.min(value[i].length,y+2);i2++) {
				if (value[i][i2]!=-1) {
					value[i][i2]++;
				}
			}
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=1;
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int row=Integer.parseInt(st.nextToken());
			int col=Integer.parseInt(st.nextToken());
			if (row==0 || col==0) {
				break;
			}
			int [][] value=new int [row][col];
			
			//mark the mine position with -1.
			for (int i=0;i<row;i++) {
				char [] c=br.readLine().toCharArray();
				for (int i2=0;i2<col;i2++) {
					if (c[i2]=='*') {
						value[i][i2]=-1;
					}
				}
			}
			
			for (int i=0;i<row;i++) {
				for (int i2=0;i2<col;i2++) {
					if (value[i][i2]==-1) { //found mine!
						checkAndAdd(value,i,i2);
					}
				}
			}
			
			StringBuilder sb=new StringBuilder();
			if (testCase>1) {
				sb.append("\n");
			}
			sb.append("Field #");
			sb.append(testCase++);
			sb.append(":\n");
			for(int i=0;i<row;i++) {
				for (int i2=0;i2<col;i2++) {
					if (value[i][i2]==-1) {
						sb.append('*');
					} else {
						sb.append(value[i][i2]);
					}
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}
}