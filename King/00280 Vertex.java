import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static boolean [][] mat;
	public static boolean [] travelled;
	
	public static void floodfill (int start) {
		for (int i=0;i<mat.length;i++) {
			if (mat[start][i] && !travelled[i]) {
				travelled[i]=true;
				floodfill(i);
			}
		}
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			if (n==0) {
				break;
			}
			mat=new boolean [n][n];
			
			while (true) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int src=Integer.parseInt(st.nextToken())-1;
				if (src==-1) {
					break;
				}
				while (st.hasMoreTokens()) {
					int dest=Integer.parseInt(st.nextToken())-1;
					if (dest==-1) {
						break;
					}
					mat[src][dest]=true;
				}
			}
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int checkCount=Integer.parseInt(st.nextToken());
			for (int i=0;i<checkCount;i++) {
				int toCheck=Integer.parseInt(st.nextToken())-1;
				travelled=new boolean [n];
				floodfill(toCheck);
				int [] unavailableList=new int [n+1];
				for (int i2=0;i2<n;i2++) {
					if (!travelled[i2]) {
						unavailableList[++unavailableList[0]]=i2+1;
					}
				}
				
				for (int i2=0;i2<=unavailableList[0];i2++) {
					System.out.print(unavailableList[i2]);
					if (i2<unavailableList[0]) {
						System.out.print(' ');
					}
				}
				System.out.println();
			}
			

		}
	}
}