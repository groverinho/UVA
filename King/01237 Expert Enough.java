import java.io.*;
import java.util.*;

class Main {
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++) {
			int modelCount=Integer.parseInt(br.readLine());
			String [] name=new String[modelCount];
			int [] L=new int [modelCount];
			int [] H=new int [modelCount];
			for (int i=0;i<modelCount;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				name[i]=st.nextToken();
				L[i]=Integer.parseInt(st.nextToken());
				H[i]=Integer.parseInt(st.nextToken());
			}
			if (testCase>0) {
				pw.println();
			}
			int Q=Integer.parseInt(br.readLine());
			for (int i=0;i<Q;i++) {
				int amount=Integer.parseInt(br.readLine());
				String found="";
				int foundCount=0;
				for (int i2=0;i2<modelCount;i2++) {
					if (L[i2]<=amount && amount<=H[i2]) {
						found=name[i2];
						foundCount++;
					}
				}
				if (foundCount==1) {
					pw.println(found);
				} else {
					pw.println("UNDETERMINED");
				}
			}

		}
		pw.close();
	}
	
}