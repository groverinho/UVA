import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			br.readLine();//blank.
			StringTokenizer st=new StringTokenizer(br.readLine(),"/");
			int [] n1=new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			Calendar d1=Calendar.getInstance();
			d1.set(n1[2],n1[1],n1[0],0,0);
			st=new StringTokenizer(br.readLine(),"/");
			int [] n2=new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			Calendar d2=Calendar.getInstance();
			d2.set(n2[2],n2[1],n2[0],0,0);
			if (d1.before(d2) && !(n1[0]==n2[0] && n1[1]==n2[1] && n1[2]==n2[2])) {
				System.out.println("Case #"+testCase+": Invalid birth date");
			} else {
				int diff=d1.get(Calendar.YEAR)-d2.get(Calendar.YEAR);
				if (d1.get(Calendar.MONTH)<d2.get(Calendar.MONTH) || (d2.get(Calendar.MONTH)==d1.get(Calendar.MONTH) && d1.get(Calendar.DAY_OF_MONTH)<d2.get(Calendar.DAY_OF_MONTH))) {
					diff--;
				}
				if (diff>130) {
					System.out.println("Case #"+testCase+": Check birth date");
				} else {
					System.out.println("Case #"+testCase+": "+diff);
				}
			}
		}
	}
}