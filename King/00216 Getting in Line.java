import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

class Main {
	
	public static double minLength=0;
	public static int [] minSolution;
	
	public static void search (int [][] nodes, boolean [] flag, int [] ans, int ansLevel, double currLength) {
		if (ansLevel==nodes.length) {
			if (currLength<minLength) {
				for (int i=0;i<ansLevel;i++) {
					minSolution[i]=ans[i];
				}
				minLength=currLength;
			}
		} else {
			for (int i=0;i<nodes.length;i++) {
				if (!flag[i]) {
					flag[i]=true;
					ans[ansLevel]=i;
					if (ansLevel>0) {
						double dx=nodes[i][0]-nodes[ans[ansLevel-1]][0];
						double dy=nodes[i][1]-nodes[ans[ansLevel-1]][1];
						double d=currLength+Math.sqrt(dx*dx+dy*dy)+16;
						if (d<minLength) {
							search(nodes,flag,ans,ansLevel+1,d);
						}
					} else {
						search(nodes,flag,ans,ansLevel+1,0);
					}
					ans[ansLevel]=-1;
					flag[i]=false;
				}
			}
		}
	}
	
	public static void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=1;
		DecimalFormat df=new DecimalFormat("#.00");
		while (true) {
			int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			if (n==0) {
				break;
			}
			int [][] nodes=new int [n][2];
			
			for (int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				nodes[i][0]=Integer.parseInt(st.nextToken());
				nodes[i][1]=Integer.parseInt(st.nextToken());
			}
			
			int [] ans=new int [n];
			boolean [] flag=new boolean [n];
			
			minLength=Double.MAX_VALUE;
			minSolution=new int [n];
			search(nodes,flag,ans,0,0.0);
			
			StringBuilder sb=new StringBuilder();
			sb.append("**********************************************************\n");
			sb.append("Network #");
			sb.append(testCase);
			sb.append("\n");
			for (int i=1;i<n;i++) {
				sb.append("Cable requirement to connect (");
				sb.append(nodes[minSolution[i-1]][0]);
				sb.append(",");
				sb.append(nodes[minSolution[i-1]][1]);
				sb.append(") to (");
				sb.append(nodes[minSolution[i]][0]);
				sb.append(",");
				sb.append(nodes[minSolution[i]][1]);
				sb.append(") is ");
				
				double dx=nodes[minSolution[i]][0]-nodes[minSolution[i-1]][0];
				double dy=nodes[minSolution[i]][1]-nodes[minSolution[i-1]][1];
				sb.append(df.format(Math.sqrt(dx*dx+dy*dy)+16));
				
				sb.append(" feet.\n");
			}
			sb.append("Number of feet of cable required is ");
			sb.append(df.format(minLength));
			sb.append(".");
			System.out.println(sb.toString());
			testCase++;
		}
	}
}