import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null && !s.isEmpty()){
            StringTokenizer st = new StringTokenizer(s);
            System.out.println(Math.abs(Long.parseLong(st.nextToken())-Long.parseLong(st.nextToken())));
        }
    }
}
