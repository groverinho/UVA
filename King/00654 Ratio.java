/* kingkingyyk, UVA 654 */
import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static double [] nums=new double [5000];
	public static int numsCount=0;
			
	public static boolean hasNum (double d) {
		for (int i=0;i<numsCount;i++) {
			if (nums[i]==d) {
				return true;
			}
		}
		return false;
	}
	
	public static void addNum(double d) {
		nums[numsCount++]=d;
	}
	
	public static void main (String [] args) {
		Scanner sc=new Scanner(System.in);
		String [] s;
		int count=0;
		while (sc.hasNextLine()) {
			if (count>0) {
				System.out.println();
			}
			count++;
			s=sc.nextLine().split(" ");
			double num1=Integer.parseInt(s[0]);
			double num2=Integer.parseInt(s[1]);
			double lastDiff=9999999.9;
			double divideDouble=num1/num2;
			Arrays.fill(nums,0);
			numsCount=0;
			int start;
			for (int i=1;i<=num2;i++) {
				start=(int)(divideDouble*i);
				double frac1=start/(double)i;
				double frac2=(start+1)/(double)i;
				double diff1=frac1-divideDouble;
				double diff2=frac2-divideDouble;
				if (diff1<0) {
					diff1=-diff1;
				}
				if (diff2<0) {
					diff2=-diff2;
				}
				if (diff1>diff2 && diff2<lastDiff && !hasNum(frac2)) {
					lastDiff=diff2;
					System.out.println((start+1)+"/"+i);
					addNum(frac2);
					if (diff2==0) {
						break;
					}
				} else if (diff2>diff1 && diff1<lastDiff && !hasNum(frac1)) {
					lastDiff=diff1;
					System.out.println(start+"/"+i);
					addNum(frac1);
					if (diff1==0) {
						break;
					}
				} else {
					if (!hasNum(frac2) && diff2<lastDiff) { //We opt for the larger ratio.
						lastDiff=diff2;
						System.out.println((start+1)+"/"+i);
						addNum(frac2);
						if (diff2==0) {
							break;
						}
					} else if (!hasNum(frac1) && diff1<lastDiff) {
						lastDiff=diff1;
						System.out.println(start+"/"+i);
						addNum(frac1);
						if (diff1==0) {
							break;
						}
					}
				}
			}
		}
	}
}