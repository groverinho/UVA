import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		while (sc.hasNext()) {
			String s1=sc.next();
			int minBaseS1=0;
			for (int i=0;i<s1.length();i++) {
				if (Character.isAlphabetic(s1.charAt(i))) {
					minBaseS1=Math.max(minBaseS1,(s1.charAt(i)-'A')+10);
				} else {
					minBaseS1=Math.max(minBaseS1,(s1.charAt(i)-'0'));
				}
			}
			minBaseS1=Math.max(minBaseS1+1, 2);
			
			String s2=sc.next();
			int minBaseS2=0;
			for (int i=0;i<s2.length();i++) {
				if (Character.isAlphabetic(s2.charAt(i))) {
					minBaseS2=Math.max(minBaseS2,(s2.charAt(i)-'A')+10);
				} else {
					minBaseS2=Math.max(minBaseS2,(s2.charAt(i)-'0'));
				}
			}
			minBaseS2=Math.max(minBaseS2+1, 2);

			boolean found=false;
			for (int i=minBaseS1;i<=36 && !found;i++) {
				for (int i2=minBaseS2;i2<=36 && !found;i2++) {
					BigInteger test1=new BigInteger(s1,i);
					BigInteger test2=new BigInteger(s2,i2);
					if (test1.equals(test2)) {
						found=true;
						StringBuilder sb=new StringBuilder();
						sb.append(s1);
						sb.append(" ");
						sb.append("(base ");
						sb.append(i);
						sb.append(") = ");
						sb.append(s2);
						sb.append(" ");
						sb.append("(base ");
						sb.append(i2);
						sb.append(")");
						System.out.println(sb.toString());
					}
				}
			}

			if (!found) {
				StringBuilder sb=new StringBuilder();
				sb.append(s1);
				sb.append(" is not equal to ");
				sb.append(s2);
				sb.append(" in any base 2..36");
				System.out.println(sb.toString());
			}
			
		}
		sc.close();
	}
}