import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        
        HashMap a = new HashMap();
        a.put("HELLO", "ENGLISH");
        a.put("HOLA", "SPANISH");
        a.put("HALLO", "GERMAN");
        a.put("BONJOUR", "FRENCH");
        a.put("CIAO", "ITALIAN");
        a.put("ZDRAVSTVUJTE", "RUSSIAN");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int i=1;
        while(!(s=br.readLine()).equals("#")){
            if(a.containsKey(s)){
                System.out.println("Case "+i+": "+a.get(s));
            }
            else{
                System.out.println("Case "+i+": UNKNOWN");
            }
            i++;
        }
    }
    
}
