import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void floodfill (char [][] map, boolean [][] flag, int x, int y) {
		flag[x][y]=true;
		for (int i=Math.max(0, x-1);i<=Math.min(map.length-1,x+1);i++) {
			for (int i2=Math.max(0, y-1);i2<=Math.min(map[i].length-1,y+1);i2++) {
				if (map[i][i2]=='@' && !flag[i][i2]) {
					floodfill(map,flag,i,i2);
				}
			}
		}
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			if (x==0 && y==0) {
				break;
			}
			
			char [][] map=new char [x][y];
			for (int i=0;i<x;i++) {
				map[i]=br.readLine().toCharArray();
			}
			
			//flood fill algorithm
			boolean [][] flag=new boolean [x][y];
			int count=0;
			for (int i=0;i<x;i++) {
				for (int i2=0;i2<y;i2++) {
					if (map[i][i2]=='@' && !flag[i][i2]) {
						count++;
						floodfill(map,flag,i,i2);
					}
				}
			}
			
			System.out.println(count);
		}
	}  
}