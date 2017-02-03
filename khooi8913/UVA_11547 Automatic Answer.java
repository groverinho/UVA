import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        for(int i=1;i<=numCases;i++){
            int test = Integer.parseInt(br.readLine());
            test*=567;
            test/=9;
            test+=7492;
            test*=235;
            test/=47;
            test-=498;
            
            String s = test+"";
            System.out.println(s.charAt(s.length()-2));
            
        }
        
        
    }
    
}
