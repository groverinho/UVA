import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;

class Main {

	public static void main(String[] args) throws IOException {
		MathContext mc35=new MathContext(35);
		MathContext mc30=new MathContext(30);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		for (int testCase=0;testCase<testCaseCount;testCase++){
			BigDecimal sum=BigDecimal.ZERO;
			String s;
			while (!(s=br.readLine()).equals("0")) {
				sum=sum.add(new BigDecimal(s),mc35);
			}
			String sumS=sum.round(mc30).toPlainString();
			int min=sumS.indexOf('.');
			if (min!=-1) {
				int max=sumS.length()-1;
				while (sumS.charAt(max)=='0') {
					max--;
				}
				if (sumS.charAt(max)=='.') {
					max--;
				}
				System.out.println(sumS.substring(0,max+1));
			} else {
				System.out.println(sumS);
			}
		}
	}
}