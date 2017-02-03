import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while((s=br.readLine())!=null){
			boolean alpha = false;
			int wordCount= 0;
			for(int i=0;i<s.length();i++){
				if(Character.isLetter(s.charAt(i)) &&!alpha){
					wordCount++;
					alpha = true;
				}else if(!Character.isLetter(s.charAt(i)) &&alpha){
					alpha = false;
				}
			}
			System.out.println(wordCount);
		}
	}
}
