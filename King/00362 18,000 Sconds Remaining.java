import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int datasetCount=1;
		while (!(s=br.readLine()).equals("0")) {
			int size=Integer.parseInt(s);
			int currentSize=0;
			
			StringBuilder sb=new StringBuilder("Output for data set ");
			sb.append(datasetCount);
			sb.append(", ");
			sb.append(size);
			sb.append(" bytes:\n");
			
			int last5sRate=0;
			int time=0;
			for (;currentSize<size;time++) {
				int rate=Integer.parseInt(br.readLine());
				last5sRate+=rate;
				currentSize+=rate;
				if (time%5==4) {
					sb.append("   Time remaining: ");
					if (last5sRate>0) {
						int remaining=size-currentSize;
						sb.append((int)Math.ceil(remaining/(last5sRate*0.2))); //divide 5 = wrong, multiply 0.2 = correct, wth UVA.
						sb.append(" seconds\n");
					} else {
						sb.append("stalled\n");
					}
					last5sRate=0;
				}
			}
			sb.append("Total time: ");
			sb.append(time);
			sb.append(" seconds\n");
			System.out.println(sb.toString());
			datasetCount++;
		}
	}
}