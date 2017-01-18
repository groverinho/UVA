import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());

		for (int testCase=0;testCase<testCaseCount;testCase++) {
			br.readLine(); //empty space.
			StringTokenizer st=new StringTokenizer(br.readLine());
			ArrayList<Integer> indexList=new ArrayList<>();
			
			int size=-1;
			while (st.hasMoreTokens()) {
				int index=Integer.parseInt(st.nextToken());
				indexList.add(index-1);
				size=Math.max(index,size);
			}
			
			String [] values=new String [size];
			st=new StringTokenizer(br.readLine());
			for (int i=0;i<size;i++) values[indexList.get(i)]=st.nextToken();
			
			for (String s : values) System.out.println(s);
			if (testCase<testCaseCount-1) System.out.println();
		}
	}
}