import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		ArrayList<Integer> value=new ArrayList<>();
		while (!(s=br.readLine()).equals("0 0 0")) {
			while (!s.equals("0 0 0")) {
				StringTokenizer st=new StringTokenizer(s);
				while (st.hasMoreTokens()) {
					value.add(Integer.parseInt(st.nextToken()));
				}
				if (value.get(value.size()-1)==0) {
					break;
				} else {
					s=br.readLine();
				}
			}
			if (s.equals("0 0 0")) {
				System.exit(0);
			}
			value.remove(value.size()-1);
			
			int [][] status=new int [value.size()][1];
			int firstOrangeTime=Integer.MAX_VALUE;
			for (int i=0;i<value.size();i++) {
				int red=value.get(i);
				firstOrangeTime=Math.min(red-5, firstOrangeTime);
				
				status[i]=new int [red*2];
				for (int i2=0;i2<red-5;i2++) {
					status[i][i2]=3; //green
				}
				for (int i2=red-5;i2<red;i2++) {
					status[i][i2]=2; //orange
				}
				for (int i2=red;i2<status[i].length;i2++) {
					status[i][i2]=1; //red
				}
			}
			
			boolean foundSolution=false;
			for (int i=firstOrangeTime;i<=5*3600;i++) {
				boolean allGreen=true;
				for (int i2=0;i2<status.length;i2++) {
					allGreen=allGreen&&(status[i2][i%status[i2].length]==3);
				}
				if (allGreen) {
					foundSolution=true;
					int h=i/3600;
					int min=(i%3600)/60;
					int sec=i-h*3600-min*60;
					StringBuilder sb=new StringBuilder();
					if (h<10) {
						sb.append("0");
					}
					sb.append(h);
					sb.append(":");
					if (min<10) {
						sb.append("0");
					}
					sb.append(min);
					sb.append(":");
					if (sec<10) {
						sb.append("0");
					}
					sb.append(sec);
					System.out.println(sb.toString());
					break;
				}
			}
			if (!foundSolution) {
				System.out.println("Signals fail to synchronise in 5 hours");
			}
			value=new ArrayList<>();
		}
	}
}