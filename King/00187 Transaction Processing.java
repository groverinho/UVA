import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String [] accName=new String [1000];
		String blank="                                                 ";
		String s;
		while (!(s=br.readLine()).equals("000No such account")) {
			accName[Integer.parseInt(s.substring(0, 3))]=s.substring(3,s.length());
		}
		
		int lastTransactionId=0;
		int [] balance = null;
		ArrayList<Integer> accList=null;
		while (!(s=br.readLine()).equals("000000        0")) {
			StringTokenizer st=new StringTokenizer(s);
			String lel=st.nextToken();
			int tid=Integer.parseInt(lel.substring(0,3));
			int accId=Integer.parseInt(lel.substring(3,6));
			if (tid!=lastTransactionId) {
				//Print if needed.
				if (lastTransactionId!=0) {
					Collections.sort(accList);
					
					Iterator<Integer> it=accList.iterator();
					int balanceSum=0;
					while (it.hasNext()) {
						balanceSum+=balance[it.next()];
					}
					
					if (balanceSum!=0) {
						StringBuilder sb=new StringBuilder();
						sb.append("*** Transaction ");
						sb.append(lastTransactionId);
						sb.append(" is out of balance ***\n");
						it=accList.iterator();
						while (it.hasNext()) {
							int aid=it.next();
							if (balance[aid]!=0) {
								int blankSpaceNeeded=44-(3+accName[aid].length()+String.format("%.2f",balance[aid]/100.0).length());
								sb.append(aid);
								sb.append(" ");
								sb.append(accName[aid]);
								sb.append(blank.substring(0,blankSpaceNeeded));
								sb.append(String.format("%.2f",balance[aid]/100.0));
								sb.append("\n");
							}
						}
						balanceSum=-balanceSum;
						
						int blankSpaceNeeded=44-(3+16+String.format("%.2f",balanceSum/100.0).length());
						sb.append("999 Out of Balance ");
						sb.append(" ");
						sb.append(blank.substring(0,blankSpaceNeeded));
						sb.append(String.format("%.2f",balanceSum/100.0));
						sb.append("\n");
						System.out.println(sb.toString());
					}
				}
				//Create new.
				balance=new int [1000];
				accList=new ArrayList<>();
				lastTransactionId=tid;
			}
			if (!accList.contains(accId)) {
				accList.add(accId);
			}
			balance[accId]+=Integer.parseInt(st.nextToken());
		}
	}
}