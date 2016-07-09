import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine(); //blank space.
			String s=br.readLine(); //first line...
			int [][] matrix=new int [s.length()][s.length()];
			
			for (int i=0;i<matrix.length;i++) {
				matrix[0][i]=s.charAt(i)-'0';
			}
			
			for (int i=1;i<matrix.length;i++) {
				s=br.readLine();
				for (int i2=0;i2<matrix.length;i2++) {
					matrix[i][i2]=s.charAt(i2)-'0';
					
					if (matrix[i][i2]==0) {
						matrix[i][i2]=-625; //-(25*25)
					}
				}
			}
			
			//culmulative sum
			for (int i=0;i<matrix.length;i++) {
				for (int i2=0;i2<matrix.length;i2++) {
					if (i>0) {
						matrix[i][i2]+=matrix[i-1][i2];
					}
					if (i2>0) {
						matrix[i][i2]+=matrix[i][i2-1];
					}
					if (i>0 && i2>0) {
						matrix[i][i2]-=matrix[i-1][i2-1];
					}
				}
			}
			
			int max=0;
			for (int i=0;i<matrix.length;i++) {
				for (int i2=0;i2<matrix.length;i2++) {
					for (int x=i;x<matrix.length;x++) {
						for (int y=i2;y<matrix.length;y++) {
							int value=matrix[x][y];
							if (i>0) {
								value-=matrix[i-1][y];
							}
							if (i2>0) {
								value-=matrix[x][i2-1];
							}
							if (i>0 && i2>0) {
								value+=matrix[i-1][i2-1];
							}
							max=Math.max(max, value);
						}
					}
				}
			}
			
			if (testCase>0) {
				System.out.println();
			}
			System.out.println(max);
		}
	}
}