import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        int numLines = Integer.parseInt(systemInput.readLine());
        int i=0;
        while(i<numLines)
        {
            StringTokenizer st = new StringTokenizer(systemInput.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            if(a>b) System.out.println(">");
            else if(a<b)    System.out.println("<");
            else    System.out.println("=");
            i++;
        }
    }
    
}
