import java.io.*;
import java.util.Arrays;

public class Main {
		
	public static void main(String args[]) throws IOException{
		boolean [] SoE = SieveOfEratosthenes(1000000);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input= "";
		while(!(input=br.readLine()).equals("0")){
			int _number = Integer.parseInt(input);
			System.out.println(goldBachConjecture(SoE, _number));
		}
				
	}
	
	private static String goldBachConjecture(boolean [] SoE, int _number){
		for(int i=2; i<=_number/2; i++){
			//System.out.println(i + " " + (_number-i));
			if(SoE[i] && SoE[_number-i]){
				
				return String.format("%d = %d + %d", _number, i, _number-i);
			}
		}
		return "Goldbach's conjecture is wrong."; 
	}
	
	private static boolean [] SieveOfEratosthenes (int N){
		boolean [] SoE = new boolean [N];
		Arrays.fill(SoE, true);
		
		SoE[0] = false;
		SoE[1] = false;
		
		for(int i=2; i< N; i = (i==2) ? 3 : i+2){
			for(int j=i*2; SoE[i] && j < N; j+=i){
				SoE[j] = false;
			}
		}
		return SoE;
	}
}
