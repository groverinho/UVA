import java.io.*;

public class Main {
		
	private static int _amount = 0;
	//UVA357
	//Coin Change Problem
	public static void main(String args[]) throws IOException{
		
		int [] coins = {0, 1, 5, 10, 25, 50};
		long [] numWays;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		String input= "";
		while((input=br.readLine())!=null){
			_amount = Integer.parseInt(input);
			numWays = new long[_amount+1];
			
			numWays[0] = 1;
			for (int i=1; i<coins.length; i++){
				for(int j=coins[i]; j<=_amount; j++ ){
					numWays[j] += numWays[j-coins[i]]; 
				}
			}
			String results = numWays[_amount] < 2 ? 
					"There is only 1 way to produce " + _amount + " cents change." :
					"There are " + numWays[_amount] +" ways to produce " + _amount + " cents change.";
			System.out.println(results);
		}
	}
}
