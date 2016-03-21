import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			int testCaseCount = Integer.parseInt(s);
			int xDivision=0;
			int yDivision=0;
			if (testCaseCount==0) {
				break;
			} else {
				StringTokenizer st=new StringTokenizer(br.readLine());
				xDivision=Integer.parseInt(st.nextToken());
				yDivision=Integer.parseInt(st.nextToken());
			}
			for (int testCase=0;testCase<testCaseCount;testCase++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				if (x==xDivision || y==yDivision) {
					System.out.println("divisa");
				} else {
					if (x<xDivision) {
						if (y<yDivision) {
							System.out.println("SO");
						} else {
							System.out.println("NO");
						}
					} else {
						if (y<yDivision) {
							System.out.println("SE");
						} else {
							System.out.println("NE");
						}
					}
				}
			}
		}
	}
}