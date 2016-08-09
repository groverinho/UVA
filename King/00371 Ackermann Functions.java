import java.io.IOException;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		while (true) {
			int [] ints={sc.nextInt(),sc.nextInt()};
			int min=Math.min(ints[0],ints[1]);
			int max=Math.max(ints[0],ints[1]);
			if (min==0 && max==0) {
				break;
			}
			
			int maxLength=-1;
			int maxI=0;
			for (int i=min;i<=max;i++) {
				long temp=i;
				int length=0;
				do {
					if (temp%2==0) {
						temp/=2;
					} else {
						temp=3*temp+1;
					}
					length++;
				} while (temp>1);
				if (length>maxLength) {
					maxLength=length;
					maxI=i;
				}
			}
			StringBuilder sb=new StringBuilder();
			sb.append("Between ");
			sb.append(min);
			sb.append(" and ");
			sb.append(max);
			sb.append(", ");
			sb.append(maxI);
			sb.append(" generates the longest sequence of ");
			sb.append(maxLength);
			sb.append(" values.");
			System.out.println(sb.toString());
		}
	}
}