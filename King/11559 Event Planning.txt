import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			int pNo = Integer.parseInt(st.nextToken());
			int budget = Integer.parseInt(st.nextToken());
			int hotelNo = Integer.parseInt(st.nextToken());
			int wNo = Integer.parseInt(st.nextToken());
			
			int [] hotelCost = new int [hotelNo];
			int [] hotelVacancy = new int [hotelNo];
			
			for (int i=0;i<hotelNo;i++) {
				hotelCost[i]=Integer.parseInt(br.readLine())*pNo;
				st=new StringTokenizer(br.readLine());
				for (int i2=0;i2<wNo;i2++) {
					hotelVacancy[i]=Math.max(hotelVacancy[i],Integer.parseInt(st.nextToken()));
				}
			}
			
			int minCost=Integer.MAX_VALUE;
			for (int i=0;i<hotelNo;i++) {
				if (hotelVacancy[i]>=pNo && hotelCost[i]<=budget) {
					minCost=Math.min(minCost,hotelCost[i]);
				}
			}
			
			if (minCost==Integer.MAX_VALUE) {
				System.out.println("stay home");
			} else {
				System.out.println(minCost);
			}
		}
	}
}