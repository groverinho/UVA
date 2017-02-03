import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(systemInput.readLine());
        int i=1;
        while(i<=numCases)
        {
            StringTokenizer st = new StringTokenizer(systemInput.readLine());
            int numStudent = Integer.parseInt(st.nextToken());
            int max=0;
            while(st.hasMoreTokens()){
                max=Math.max(max, Integer.parseInt(st.nextToken()));
            }
            System.out.println("Case "+ i+": "+max);
            i++;
        }
        
    }
    
}
