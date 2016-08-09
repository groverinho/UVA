import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static boolean [][] cannotEast;
	public static boolean [][] cannotSouth;
	public static boolean [][] cannotNorth;
	public static boolean [][] cannotWest;
	public static int [][] fill;
	public static int [][] path;
	public static int pathCount;
	public static boolean found;
	
	public static void dfs (int [] end) {
		if (!found) {
			int currX=path[pathCount-1][0];
			int currY=path[pathCount-1][1];
			fill[currX][currY]=Integer.MAX_VALUE;
			if (currX==end[0] && currY==end[1]) {
				//backtracking.
				found=true;
				for (int i=0;i<pathCount;i++) {
					fill[path[i][0]][path[i][1]]=i+1;
				}
			} else {
				if (!cannotWest[currX][currY]) {
					path[pathCount][0]=currX;
					path[pathCount][1]=currY-1;
					if (fill[path[pathCount][0]][path[pathCount][1]]==0) {
						pathCount++;
						dfs(end);
						pathCount--;
					}
				}
				if (!cannotNorth[currX][currY]) {
					path[pathCount][0]=currX-1;
					path[pathCount][1]=currY;
					if (fill[path[pathCount][0]][path[pathCount][1]]==0) {
						pathCount++;
						dfs(end);
						pathCount--;
					}
				}
				if (!cannotEast[currX][currY]) {
					path[pathCount][0]=currX;
					path[pathCount][1]=currY+1;
					if (fill[path[pathCount][0]][path[pathCount][1]]==0) {
						pathCount++;
						dfs(end);
						pathCount--;
					}
				}
				if (!cannotSouth[currX][currY]) {
					path[pathCount][0]=currX+1;
					path[pathCount][1]=currY;
					if (fill[path[pathCount][0]][path[pathCount][1]]==0) {
						pathCount++;
						dfs(end);
						pathCount--;
					}
				}
			}
		}
	}
	
	public static StringTokenizer st;
	public static int nextInputInt (BufferedReader br) throws IOException {
		if (st==null || !st.hasMoreTokens()) {
			do {
				st=new StringTokenizer(br.readLine());
			} while (!st.hasMoreTokens());
		}
		return Integer.valueOf(st.nextToken());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=1;
		while (true) {
			int R=nextInputInt(br);
			int C=nextInputInt(br);
			if (R==0 && C==0) {
				break;
			}
			int currX=nextInputInt(br)-1;
			int currY=nextInputInt(br)-1;
			int endX=nextInputInt(br)-1;
			int endY=nextInputInt(br)-1;
			cannotEast = new boolean [R][C];
			cannotSouth = new boolean [R][C];
			cannotWest = new boolean [R][C];
			cannotNorth = new boolean [R][C];
			
			for (int i=0;i<R;i++) {
				st=new StringTokenizer(br.readLine());
				for (int i2=0;i2<C;i2++) {
					int v=Integer.parseInt(st.nextToken());
					if (v>=2) {
						cannotSouth[i][i2]=true;
						if (i<R-1) {
							cannotNorth[i+1][i2]=true;
						}
						v-=2;
					}
					if (v>=1) {
						cannotEast[i][i2]=true;
						if (i2<C-1) {
							cannotWest[i][i2+1]=true;
						}
						v-=1;
					}
					
					if (i==0) {
						cannotNorth[i][i2]=true;
					}
					if (i==R-1) {
						cannotSouth[i][i2]=true;
					}
					
					if (i2==0) {
						cannotWest[i][i2]=true;
					}
					if (i2==C-1) {
						cannotEast[i][i2]=true;
					}
				}
			}
			
			fill=new int [R][C];
			path=new int [R*C][2];
			pathCount=1;
			path[0][0]=currX;
			path[0][1]=currY;
			found=false;
			dfs(new int [] {endX,endY});
			
			System.out.println("Maze "+t++);
			System.out.println();
			StringBuilder sb=new StringBuilder();
			
			for (int i=0;i<R;i++) {
				sb.append('+');
				for (int i2=0;i2<C;i2++) {
					if (cannotNorth[i][i2]) {
						sb.append("---");
					} else {
						sb.append("   ");
					}
					sb.append('+');
				}
				sb.append("\n");
				sb.append("|");
				for (int i2=0;i2<C;i2++) {
					if (fill[i][i2]==0) {
						sb.append("   ");
					} else if (fill[i][i2]==Integer.MAX_VALUE) {
						sb.append("???");
					} else {
						if (fill[i][i2]<10) {
							sb.append("  ");
						} else if (fill[i][i2]<100) {
							sb.append(" ");
						}
						sb.append(fill[i][i2]);
					}
					if (cannotEast[i][i2]) {
						sb.append("|");
					} else {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
			sb.append('+');
			for (int i=0;i<C;i++) {
				sb.append("---+");
			}
			sb.append("\n\n");
			System.out.println(sb.toString());
		}
	}
	
}