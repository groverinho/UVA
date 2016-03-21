import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	static int nameToDigit (String n) {
		int sum=0;
		for (int i=0;i<n.length();i++) {
			char currC=n.charAt(i);
			if (Character.isAlphabetic(currC)) {
				if (Character.isUpperCase(currC)) {
					sum+=(currC-'A'+1);
				} else {
					sum+=(currC-'a'+1);
				}
			}
		}
		return recurseSum(sum);
	}
	
	static int recurseSum (int i) {
		if (i<10) {
			return i;
		} else {
			int sum=0;
			while (i>0) {
				sum+=i%10;
				i/=10;
			}
			return recurseSum(sum);
		}
	}
	
	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s=br.readLine())!=null) {
			double value1=nameToDigit(s);
			double value2=nameToDigit(br.readLine());
			double ratio=(Math.min(value1, value2)/Math.max(value1, value2))*100;
			System.out.printf("%.2f %%\n",ratio);
		}
	}
}