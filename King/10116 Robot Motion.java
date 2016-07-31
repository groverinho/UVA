import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int [] moveX=new int [128];
		int [] moveY=new int [128];
		moveX['N']=-1;
		moveX['S']=1;
		moveY['E']=1;
		moveY['W']=-1;
		
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int currX=0;
			int currY=Integer.parseInt(st.nextToken())-1;
			
			if (x==-1 && y==-1 && currY==-1) {
				break;
			}
			
			char [][] mat=new char [x+1][];
			for (int i=0;i<mat.length;i++) {
				mat[i]=br.readLine().toCharArray();
			}
			
			HashMap<String,Integer> map=new HashMap<>();
			int pathCount=0;
			boolean loop=false;
			int loopPathCount=0;
			
			while (true) {
				if (currX<0 || currX>x || currY<0 || currY>y) {
					break;
				}
				String key=currX+","+currY;
				if (map.containsKey(key)) {
					loop=true;
					loopPathCount=pathCount-map.get(key);
					break;
				}
				map.put(key, pathCount++);
				int newX=currX+moveX[mat[currX][currY]];
				int newY=currY+moveY[mat[currX][currY]];
				currX=newX;
				currY=newY;
			}
			
			if (loop) {
				pathCount-=loopPathCount;
				System.out.println(pathCount+" step(s) before a loop of "+loopPathCount+" step(s)");
			} else {
				System.out.println(pathCount+" step(s) to exit");
			}
			
		}
	}
}