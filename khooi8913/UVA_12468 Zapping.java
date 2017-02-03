import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=br.readLine()).equals("-1 -1")){
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int diff = Math.abs(a-b);
            int min = diff;
            
            int diff1 = Math.abs((a+100)-b);
            if(diff1<min)
                min = diff1;
            
            int diff2 = Math.abs(a-(b+100));
            if(diff2<min)
                min=diff2;
            
            System.out.println(min);
            
        }    
    }
    
}
