import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
	
	public static String formatNumber (String str) {
		StringBuilder sb=new StringBuilder();
		int startLoop=str.length()%3;
		if (startLoop>0) {
			sb.append(str.substring(0,startLoop));
		}
		if (str.length()-1>startLoop) {
			if (startLoop>0) {
				sb.append(',');
			}
			for (int i=startLoop;i<str.length();i++) {
				sb.append(str.charAt(i));
				if ((i+1)%3==startLoop && i!=startLoop && i<str.length()-1) {
					sb.append(',');
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BigInteger [] pow26=new BigInteger [22];
		pow26[0]=BigInteger.ONE;
		for (int i=1;i<pow26.length;i++) {
			pow26[i]=BigInteger.valueOf(26).multiply(pow26[i-1]);
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		String blank="                       ";
		while (!(s=br.readLine()).equals("*")) {
			String word="";
			String number="";
			if (Character.isAlphabetic(s.charAt(0))) {
				BigInteger value=BigInteger.valueOf(0);
				for (int i=0;i<s.length();i++) {
					value=value.add(pow26[s.length()-i-1].multiply(BigInteger.valueOf(s.charAt(i)-'a'+1)));
				}

				word=s;
				number=formatNumber(value.toString());
			} else {
				number=formatNumber(s);
				BigInteger bi=new BigInteger(s);
				StringBuilder sb=new StringBuilder();
	
				while (bi.compareTo(BigInteger.ZERO)>0) {
					bi=bi.subtract(BigInteger.ONE);
					sb.append((char)(bi.mod(pow26[1]).intValue()+'a'));
					bi=bi.divide(pow26[1]);
				}
				
				word=sb.reverse().toString();
			}
			StringBuilder sb=new StringBuilder();
			sb.append(word);
			sb.append(blank.substring(0,22-word.length()));
			sb.append(number);
			System.out.println(sb.toString());
		}
	}
}