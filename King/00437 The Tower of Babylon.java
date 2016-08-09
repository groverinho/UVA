import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	
	public static class Tower implements Comparable<Tower> {
		public int [] size;
		
		public Tower () {
			this.size=new int [3];
		}
		
		public int compareTo(Tower t) {
			for (int i=0;i<3;i++) {
				if (this.size[i]!=t.size[i]) {
					return this.size[i]-t.size[i];
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int test=1;
		while ((s=br.readLine())!=null) {
			int n=Integer.parseInt(s);
			
			if (n==0) {
				break;
			}
			
			ArrayList<Tower> towerList=new ArrayList<>();
			HashSet<String> towerHash=new HashSet<>();
			for (int i=0;i<n;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int [] temp=new int [3];
				for (int i2=0;i2<3;i2++) {
					temp[i2]=Integer.parseInt(st.nextToken());
				}
				boolean [] flag=new boolean [3];
				for (int j=0;j<3;j++) {
					flag[j]=true;
					for (int k=0;k<3;k++) {
						if (!flag[k]) {
							flag[k]=true;
							for (int l=0;l<3;l++) {
								if (!flag[l] && !towerHash.contains(temp[j]+"_"+temp[k]+"_"+temp[l])) {
									Tower t=new Tower();
									t.size[0]=temp[j];
									t.size[1]=temp[k];
									t.size[2]=temp[l];
									towerList.add(t);
									towerHash.add(temp[j]+"_"+temp[k]+"_"+temp[l]);
								}
							}
							flag[k]=false;
						}
					}
					flag[j]=false;
				}
			}
			
			Tower [] tower=towerList.toArray(new Tower[towerList.size()]);
			Arrays.sort(tower);
			
			int [] lis=new int [tower.length];
			lis[0]=tower[0].size[2];
			for (int i=1;i<tower.length;i++) {
				lis[i]=Math.max(tower[i].size[2], lis[i]);
				for (int i2=0;i2<i;i2++) {
					if (tower[i].size[0]>tower[i2].size[0] && tower[i].size[1]>tower[i2].size[1]) {
						lis[i]=Math.max(lis[i], lis[i2]+tower[i].size[2]);
					}
				}
			}
			
			int max=0;
			for (int i : lis) {
				max=Math.max(max, i);
			}
			
			System.out.println("Case "+test+++": maximum height = "+max);
		}
	}
}