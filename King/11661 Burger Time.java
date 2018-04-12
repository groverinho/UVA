import java.util.Scanner;

/**
Name: Grover A. Irusta Miranda
Company: CodeRoad - Mojix
Date 12/04/18
 */
public class BurgerTime11661 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int n = in.nextInt();
			if(n==0){
				break;
			}
			String s = in.next();
			int minDistance = n;
	        int lastR = -n, lastD = -n;
	        for (int i = 0; i < n; ++i)
	        {
	            if (s.charAt(i)== 'Z')
	            {
	                minDistance = 0;
	                break;
	            }
	            else if (s.charAt(i)== 'R')
	            {
	                minDistance = Math.min(minDistance, i - lastD);
	                lastR = i;
	            }
	            else if (s.charAt(i) == 'D')
	            {
	                minDistance = Math.min(minDistance, i - lastR);
	                lastD = i;
	            }
	        }
	        System.out.println(minDistance);
		}
	}

}
