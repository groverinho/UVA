import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {                                                                                                                             
	public static boolean isValidTriangle (double [] l) {
		//Cosine rule : c^2 = a^2 + b^2 - 2ab cos (C);
		for (int i=0;i<l.length;i++) if (l[i]<=0) return false;
		if (l[0]+l[1]<=l[2]) return false;
		double A=Math.acos((l[0]*l[0]+l[1]*l[1]-l[2]*l[2])/(2*l[0]*l[1]));
		double B=Math.acos((l[1]*l[1]+l[2]*l[2]-l[0]*l[0])/(2*l[1]*l[2]));
		double C=Math.acos((l[0]*l[0]+l[2]*l[2]-l[1]*l[1])/(2*l[0]*l[2]));
		return (Math.round(A+B+C)==Math.round(Math.PI));
		
	}
	
	public static void main (String[]args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			double [] value={Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			Arrays.sort(value);
			if (!isValidTriangle(value)) System.out.println("Case "+testCase+": Invalid");
			else if (value[0]==value[1] && value[1]==value[2]) System.out.println("Case "+testCase+": Equilateral");
			else if (value[0]==value[1] || value[1]==value[2]) System.out.println("Case "+testCase+": Isosceles");
			else System.out.println("Case "+testCase+": Scalene");
		}
	}
}