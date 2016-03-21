import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[]args)throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s=br.readLine()).equals("DONE")) {
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<s.length();i++) {
				if (Character.isAlphabetic(s.charAt(i))) {
					sb.append(Character.toLowerCase(s.charAt(i)));
				}
			}
			
			String cleanStr=sb.toString();
			boolean isPalindrome=true;
			int strLength=cleanStr.length();
			for (int i=0;i<strLength && isPalindrome;i++) {
				isPalindrome=cleanStr.charAt(i)==cleanStr.charAt(strLength-1-i);
			}
			
			if (isPalindrome) {
				System.out.println("You won't be eaten!");
			} else {
				System.out.println("Uh oh..");
			}
		}
	}
}