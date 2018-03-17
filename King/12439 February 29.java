import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	
	public static int leapYearsSoFar(int [] date, boolean start) {
		if (date[2]%4 == 0 && (date[2]%100 != 0 || date[2]%400 == 0)) {
			if (date[1]>2) date[2]++;
			else if (start && date[1]==2 && date[0]==29) date[2]--;
			else if (!start && date[1]==2 && date[0]==29) date[2]++;
			else date[2]--;
		}
		return date[2]/4 - date[2]/100 + date[2]/400;
	}
	
	public static void main (String [] args) throws Exception {
		String [] months={"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		HashMap<String,Integer> map=new HashMap<>();
		for (int i=1;i<months.length;i++) map.put(months[i],i);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int [][] dates=new int [2][3];
			StringTokenizer st=new StringTokenizer(br.readLine());
			dates[0][1]=map.get(st.nextToken());
			dates[0][0]=Integer.parseInt(st.nextToken().split(",")[0]);
			dates[0][2]=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			dates[1][1]=map.get(st.nextToken());
			dates[1][0]=Integer.parseInt(st.nextToken().split(",")[0]);
			dates[1][2]=Integer.parseInt(st.nextToken());
			
			System.out.println("Case "+testCase+": "+(leapYearsSoFar(dates[1],false)-leapYearsSoFar(dates[0],true)));
		}
	}

}
