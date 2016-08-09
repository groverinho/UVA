import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N=Integer.parseInt(br.readLine());
			if (N==0) {
				break;
			}
			
			int [][] ints=new int [N][N];
			for (int i=0;i<N;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for (int i2=0;i2<N;i2++) {
					ints[i][i2]=Integer.parseInt(st.nextToken());
				}
			}
			
			int [] rowSum=new int [N];
			int [] colSum=new int [N];
			
			for (int i=0;i<N;i++) {
				for (int n : ints[i]) {
					rowSum[i]+=n;
				}
			}
			
			for (int i=0;i<N;i++) {
				for (int i2=0;i2<N;i2++) {
					colSum[i2]+=ints[i][i2];
				}
			}
			
			boolean parity=true;
			for (int i=0;i<rowSum.length && parity;i++) {
				parity = parity & (rowSum[i]%2)==0;
			}
			
			for (int i=0;i<colSum.length && parity;i++) {
				parity = parity & (colSum[i]%2)==0;
			}
			
			if (parity) {
				System.out.println("OK");
			} else {
				int rowOddCount=0;
				for (int i=0;i<N;i++) {
					if (rowSum[i]%2==1) {
						rowOddCount++;
					}
				}
				
				int colOddCount=0;
				for (int i=0;i<N;i++) {
					if (colSum[i]%2==1) {
						colOddCount++;
					}
				}
				
				if (rowOddCount==1 && colOddCount==1) {
					int rowIndex=0;
					for (int i=0;i<N;i++) {
						if (rowSum[i]%2==1) {
							rowIndex=i;
							break;
						}
					}
					
					int colIndex=0;
					for (int i=0;i<N;i++) {
						if (colSum[i]%2==1) {
							colIndex=i;
							break;
						}
					}
					
					System.out.println("Change bit ("+(rowIndex+1)+","+(colIndex+1)+")");
				} else {
					System.out.println("Corrupt");
				}
			}
		}
	}  
}