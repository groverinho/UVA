import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while((s=br.readLine())!=null){
            LinkedList a = new LinkedList();
            StringBuilder st = new StringBuilder();
            
            boolean homeKey = false;
            int homePressed=0;
            boolean endKey = true;
            
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='['){
                    homeKey = true;
                    homePressed=0;
                    endKey = false;
                }else if(s.charAt(i)==']'){
                    endKey = true;
                    homeKey = false;
                }else{
                    if(homeKey){
                        if(homePressed==0){
                            a.addFirst(s.charAt(i));
                            homePressed+=1;
                        }else if(homePressed!=0){
                            a.add(homePressed, s.charAt(i));
                            homePressed+=1;
                        }
                    }else{
                        a.addLast(s.charAt(i));
                    }
                }
            }
            
            String b = a.toString();
            for(int i=0;i<b.length();i++){
                if(b.charAt(i)!='['&&b.charAt(i)!=']'&&b.charAt(i)!=','&&b.charAt(i)!=' ')
                    st.append(b.charAt(i));
            }
            
            System.out.println(st.toString());
        }    
    }
}
