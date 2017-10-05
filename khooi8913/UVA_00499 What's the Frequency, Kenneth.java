import java.io.*;

public class Main {
	
	public static int [] _char;
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input= "";
		while((input=br.readLine())!=null){
			_char = new int [255];
			int max = 0;
			
			for(int i=0; i<input.length(); i++){
				char a = input.charAt(i);
				if (Character.isLetter(a)){
					_char[(int)a]+=1;
				}
				max = Math.max(max, _char[(int)a]);
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<_char.length;i++){
				if(_char[i]==max)	sb.append((char)i);
			}
			
			sb.append(" ");
			sb.append(max+"");
			
			System.out.println(sb.toString());
			
			
		}
				
	}

}
