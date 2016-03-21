import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int farmerCount=Integer.parseInt(br.readLine());
			double output=0;
			for (int farmer=0;farmer<farmerCount;farmer++) {
				String [] data=br.readLine().split(" ");
				int sqMeter = Integer.parseInt(data[0]);
				double animalCount = Integer.parseInt(data[1]);
				int enValue = Integer.parseInt(data[2]);
				output+=(sqMeter/animalCount)*enValue*animalCount;
			}
			System.out.println((int)output);
		}
	}
}