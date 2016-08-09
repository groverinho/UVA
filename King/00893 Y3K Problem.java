import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("0 0 0 0")) {
			StringTokenizer st=new StringTokenizer(s);
			//Java 8's library
			int [] data=new int [] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			LocalDateTime currentTime=LocalDateTime.of(data[3], data[2], data[1], 0, 0);
			currentTime=currentTime.plusDays(data[0]);
			System.out.println(currentTime.getDayOfMonth()+" "+currentTime.getMonthValue()+" "+currentTime.getYear());
		}
	}
}