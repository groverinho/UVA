import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args)  throws IOException {
		char [][] turn=new char [128][128];
		turn['N']['D']='L';
		turn['L']['D']='S';
		turn['S']['D']='O';
		turn['O']['D']='N';
		turn['N']['E']='O';
		turn['O']['E']='S';
		turn['S']['E']='L';
		turn['L']['E']='N';
		
		int [] moveX=new int [128];
		int [] moveY=new int [128];
		moveX['N']=-1;
		moveX['S']=1;
		moveY['L']=1;
		moveY['O']=-1;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			int S=Integer.parseInt(st.nextToken());
			if (M==0 && N==0 && S==0) {
				break;
			}
			
			boolean foundCurr=false;
			int currX=0;
			int currY=0;
			char facing='A';
			
			char [][] mat=new char [M][];
			for (int i=0;i<M;i++) {
				mat[i]=br.readLine().toCharArray();
				if (!foundCurr) {
					for (int i2=0;i2<mat[i].length;i2++) {
						if (mat[i][i2]=='N' || mat[i][i2]=='S' || mat[i][i2]=='L' || mat[i][i2]=='O') {
							currX=i;
							currY=i2;
							facing=mat[i][i2];
							foundCurr=true;
							break;
						}
					}
				}
			}
			
			int stickerCount=0;
			char [] command=br.readLine().toCharArray();
			for (int i=0;i<S;i++) {
				if (command[i]=='F') {
					int newX=currX+moveX[facing];
					int newY=currY+moveY[facing];
					if (newX>=0 && newX<M && newY>=0 && newY<N && mat[newX][newY]!='#') {
						currX=newX;
						currY=newY;
						if (mat[currX][currY]=='*') {
							stickerCount++;
							mat[currX][currY]='.';
						}
					}
				} else if (command[i]=='D' || command[i]=='E') {
					facing=turn[facing][command[i]];
				}
			}
			
			System.out.println(stickerCount);
		}
	}
}