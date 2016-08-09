import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

class Main {
	
	public static void main(String[] args) throws IOException {
		int [][] range={{1,21,2,19},
						{2,20,3,20},
						{3,21,4,20},
						{4,21,5,21},
						{5,22,6,21},
						{6,22,7,22},
						{7,23,8,21},
						{8,22,9,23},
						{9,24,10,23},
						{10,24,11,22},
						{11,23,12,22},
						{12,23,12,31},
						{1,1,1,20}};
		String [] rangeName={"aquarius","pisces","aries","taurus","gemini","cancer","leo","virgo","libra","scorpio","sagittarius","capricorn","capricorn"};
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			String s=br.readLine();
			LocalDateTime dt=LocalDateTime.of(Integer.parseInt(s.substring(4,8)),Integer.parseInt(s.substring(0,2)),Integer.parseInt(s.substring(2,4)),0,0);
			dt=dt.plusWeeks(40);
			int d=dt.getDayOfMonth();
			int m=dt.getMonthValue();
			int i=0;
			for (;i<range.length;i++) {
				if ((m==range[i][0] && d>=range[i][1]) || (m==range[i][2] && d<=range[i][3]))  {
					break;
				}
			}
			StringBuilder sb=new StringBuilder();
			sb.append(testCase);
			sb.append(" ");
			if (m<10) {
				sb.append("0");
			}
			sb.append(m);
			sb.append("/");
			if (d<10) {
				sb.append("0");
			}
			sb.append(d);
			sb.append("/");
			sb.append(dt.getYear());
			sb.append(" ");
			sb.append(rangeName[i]);
			System.out.println(sb.toString());
		}
	}
}