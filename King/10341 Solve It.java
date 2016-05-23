import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {
	
	public static void main (String [] abc) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(str);
			double p=Double.parseDouble(st.nextToken());
			double q=Double.parseDouble(st.nextToken());
			double r=Double.parseDouble(st.nextToken());
			double s=Double.parseDouble(st.nextToken());
			double t=Double.parseDouble(st.nextToken());
			double u=Double.parseDouble(st.nextToken());
			
			double xMin=0.0;
			double xMax=1.0;
			double x=0.0;
			double value=0.0;
			
			double minValue=p*Math.exp(-xMin)+q*Math.sin(xMin)+r*Math.cos(xMin)+s*Math.tan(xMin)+t*xMin*xMin+u;
			double maxValue=p*Math.exp(-xMax)+q*Math.sin(xMax)+r*Math.cos(xMax)+s*Math.tan(xMax)+t*xMax*xMax+u;
			
			if (minValue>0 && maxValue<0) {
				for (int i=0;i<50;i++) {
					x=(xMin+xMax)/2;
					value=p*Math.exp(-x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*x*x+u;
					if (value<0) {
						xMax=x;
					} else if (value>0) {
						xMin=x;
					}
				}
				
				System.out.printf("%.4f\n",x);
			} else if (minValue==0){
				System.out.println("0.0000");
			} else if (maxValue==0) {
				System.out.println("1.0000");
			} else {
				System.out.println("No solution");
			}
		}
	}
	
}