import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
	public static int [] xDiff={-1,1,0,0};
	public static int [] yDiff={0,0,-1,1};
	
	public static void floodfill (char [][] map, int x, int y) {
		map[x][y]='.';
		
		for (int i=0;i<xDiff.length;i++) {
			int newX=x+xDiff[i];
			int newY=y+yDiff[i];
			if (newX>=0 && newX<map.length && newY>=0 && newY<map.length && map[newX][newY]!='.') {
				map[newX][newY]='.';
				floodfill(map,newX,newY);
			}
		}
	}
	
	public static void main(String[] args)  throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int size=Integer.parseInt(br.readLine());
			char [][] map=new char [size][size];
			for (int i=0;i<size;i++) map[i]=br.readLine().toCharArray();
			
			int count=0;
			for (int i=0;i<size;i++) for (int i2=0;i2<size;i2++) if (map[i][i2]=='x') {
				floodfill(map, i, i2);
				count++;
			}
			
			System.out.println("Case "+testCase+": "+count);
		}
	}
	
}