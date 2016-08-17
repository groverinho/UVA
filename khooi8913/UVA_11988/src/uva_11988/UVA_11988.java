package uva_11988;
//Not solved
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVA_11988 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while((s=br.readLine())!=null){
            LinkedList a = new LinkedList();
            StringBuilder st = new StringBuilder();
            boolean home = false;
            boolean end = true;
            
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='['){
                    i++;
                    home=true;
                    end=false;
                }
                else if(s.charAt(i)==']'){
                    i++;
                    home=false;
                    end=true;
                }
                
                if(end==true){
                    a.add(s.charAt(i));
                }
                else if(home==true){
                    a.addFirst(s.charAt(i));
                }

            }
            System.out.println(a.toString());
        }    
    }
    
}
