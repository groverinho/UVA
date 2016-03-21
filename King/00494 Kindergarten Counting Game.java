import java.util.Scanner;

class Main {
	
	public static void main (String [] abc)  {
		Scanner sc=new Scanner(System.in);
		while (sc.hasNextLine()) {
			int wordCount=0;
			boolean toAdd=true;
			String word=sc.nextLine();
			for (int i=0;i<word.length();i++) {
				if (toAdd && Character.isAlphabetic(word.charAt(i))) {
					wordCount++;
					toAdd=false;
				} else if (!toAdd && !Character.isAlphabetic(word.charAt(i))) {
					toAdd=true;
				}
			}
			System.out.println(wordCount);
		}
		sc.close();
	}
}