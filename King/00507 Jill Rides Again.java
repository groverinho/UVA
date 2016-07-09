import java.io.IOException;
import java.util.Scanner;

class Main {
	
	public static void main(String[]args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int testCaseCount=sc.nextInt();
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int count=sc.nextInt();
			int [] values=new int [count-1];
			for (int i=0;i<values.length;i++) {
				values[i]=sc.nextInt();
			}
			
			int sum=0;
			int max=0;
			for (int i=0;i<values.length;i++) {
				sum+=values[i];
				max=Math.max(sum, max);
				if (sum<0) {
					sum=0;
				}
			}
			
			int minRide=0;
			int maxRide=0;
			
			int currMinRide=0;
			sum=0;
			for (int i=0;i<values.length;i++) {
				sum+=values[i];
				if (sum==max) {
					int currDist=i-currMinRide;
					int ansDist=maxRide-minRide;
					if (currDist>ansDist || (minRide==0 && maxRide==0)) {
						minRide=currMinRide+1; //array starts with 1...
						maxRide=i+2; //array starts with 1...
					}
				}
				if (sum<0) {
					sum=0;
					currMinRide=i+1;
				}
			}
			
			if (max>0) {
				System.out.println("The nicest part of route "+testCase+" is between stops "+minRide+" and "+maxRide);
			} else {
				System.out.println("Route "+testCase+" has no nice parts");
			}
		}
	}
}