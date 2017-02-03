import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        
        for(int i=0;i<numCases;i++){
            String s = br.readLine();
            if(s.equals("1")||s.equals("4")||s.equals("78"))
                System.out.println("+");
            else if(s.charAt(s.length()-2)=='3'&&s.charAt(s.length()-1)=='5')
                System.out.println("-");
            else if(s.charAt(0)=='9'&&s.charAt(s.length()-1)=='4')
                System.out.println("*");
            else if(s.charAt(0)=='1'&&s.charAt(1)=='9'&&s.charAt(2)=='0')
                System.out.println("?");
        }
        
    }
    
}
