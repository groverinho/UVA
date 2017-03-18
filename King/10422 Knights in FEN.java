import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

class Main {
	
	public static class Setup implements Comparable<Setup> {
		private char [][] board;
		public int emptyX, emptyY;
		private String str;
		
		private Setup(char [][] data, int x, int y) {
			this.board=data;
			this.emptyX=x;
			this.emptyY=y;
			this.createStr();
		}
		
		public Setup (String [] table) {
			this.board=new char [5][5];
			for (int i=0;i<5;i++) this.board[i]=table[i].toCharArray();
			locateEmpty();
			this.createStr();
		}
		
		public void locateEmpty() {
			for (int i=0;i<board.length;i++) for (int i2=0;i2<board[i].length;i2++)
				if (board[i][i2]==' ') {
					emptyX=i;
					emptyY=i;
					return;
				}
		}
		
		private void createStr() {
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<board.length;i++) sb.append(new String(board[i]));
			this.str=sb.toString();
		}
		
		public ArrayList<Setup> feasibleMoves() {
			int [] x={-1,1,-1,1,-2,-2,2,2};
			int [] y={-2,-2,2,2,-1,1,-1,1};
			ArrayList<Setup> nextSetups=new ArrayList<>();
			for (int i=0;i<x.length;i++) {
				int newEmptyX=emptyX+x[i];
				int newEmptyY=emptyY+y[i];
				
				if (newEmptyX>=0 && newEmptyX<board.length && newEmptyY>=0 && newEmptyY<board[0].length) {
					char [][] newB=new char [5][5];
					for (int lol=0;lol<5;lol++) for (int lel=0;lel<5;lel++) newB[lol][lel]=this.board[lol][lel];
					newB[emptyX][emptyY]=newB[newEmptyX][newEmptyY];
					newB[newEmptyX][newEmptyY]=' ';
					nextSetups.add(new Setup(newB,newEmptyX,newEmptyY));
				}
			}
			return nextSetups;
		}
		
		public String toString () {
			return this.str;
		}
		
		public boolean equals(Setup s) {
			for (int i=0;i<this.board.length;i++) for (int i2=0;i2<this.board[i].length;i2++)
				if (this.board[i][i2]!=s.board[i][i2]) return false;
			return true;
		}

		@Override
		public int compareTo(Setup s) {
			return this.toString().compareTo(s.toString());
		}
	}
	
	public static void main(String[] args)  throws Exception {
        //Cache answer...
    	Setup initialSetup=new Setup(new String [] {"11111","01111","00 11","00001","00000"});
    	Queue<Setup> queue=new ArrayDeque<>();
    	HashMap<String,Integer> depth=new HashMap<>();
    	
    	queue.add(initialSetup);
    	depth.put(initialSetup.toString(),0);

    	while (!queue.isEmpty()) {
    		Setup currSetup=queue.poll();
    		int currDepth=depth.get(currSetup.toString());
    		if (currDepth<11) {
	    		for (Setup nextSetup : currSetup.feasibleMoves()) if (!depth.containsKey(nextSetup.toString())) {
	        		queue.offer(nextSetup);
	        		depth.put(nextSetup.toString(),currDepth+1);
	    		}
    		}
    	}
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount=Integer.parseInt(br.readLine());
        for (int testCase=0;testCase<testCaseCount;testCase++) {
        	String [] s=new String [5];
        	for (int i=0;i<s.length;i++) {
        		s[i]=br.readLine();
        		if (s[i].length()>5) s[i]=s[i].substring(0,5);
        		else if (s[i].length()<5) while (s[i].length()<5) s[i]=s[i]+" ";
        	}
        	
        	
        	Setup finalSetup=new Setup(s);
        	
        	int count=depth.getOrDefault(finalSetup.toString(),-1);
        	if (count==-1 || count>10) System.out.println("Unsolvable in less than 11 move(s).");
        	else System.out.println("Solvable in "+count+" move(s).");
        }
	}  
	
}