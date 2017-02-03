import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        int numLines = Integer.parseInt(systemInput.readLine());
        int i=1;
        while(i<=numLines)
        {
            StringTokenizer st = new StringTokenizer(systemInput.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ArrayList list = new ArrayList();
            list.add(a);
            list.add(b);
            list.add(c);
            Collections.sort(list);
            System.out.println("Case "+i+": "+ list.get(1));
            i++;
        }
        
    }
    
}
