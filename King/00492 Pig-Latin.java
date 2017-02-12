import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	
	public static boolean [] vowel=new boolean [128];
	
	public static String pigLatin (String word) {
		if (word.length()>0) {
			if (vowel[word.charAt(0)]) word+="ay";
			else word=word.substring(1)+word.charAt(0)+"ay";
			
			return word;
		}
		return "";
	}
	
	public static void main (String[]args) throws Exception {
		vowel['a']=true; vowel['e']=true; vowel['i']=true; vowel['o']=true; vowel['u']=true; 
		vowel['A']=true; vowel['E']=true; vowel['I']=true; vowel['O']=true; vowel['U']=true;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder word=new StringBuilder();
		int read;
		
		//No idea why. Presentation error when using BufferedReader.readLine() and StringBuilder. :/
		while ((read=br.read())!=-1) {
			char c=(char) read;
			if (Character.isAlphabetic(c)) {
				word.append(c);
			} else {
				System.out.print(pigLatin(word.toString()));
				System.out.print(c);
				word=new StringBuilder();
			}
		}
		System.out.print(pigLatin(word.toString()));
	}
}