import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int commandCount=Integer.parseInt(br.readLine());
			String [] commands = new String [commandCount];
			for (int i=0;i<commandCount;i++) {
				String currCommand=br.readLine();
				if (currCommand.contains("SAME AS ")) {
					commands[i]=commands[Integer.parseInt(currCommand.substring(8, currCommand.length()))-1];
				} else {
					commands[i]=currCommand;
				}
			}
			
			int p=0;
			for (int i=0;i<commandCount;i++) {
				if (commands[i].equals("LEFT")) {
					p--;
				} else {
					p++;
				}
			}
			
			System.out.println(p);
		}
	}
}