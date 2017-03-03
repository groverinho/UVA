import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {

        int i=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s="";
        while((s=br.readLine())!=null){
            StringBuilder st = new StringBuilder();

            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='\"'){
                    i++;
                    if(i%2==1){
                        st.append("``");
                    }else{
                        st.append("''");
                    }
                }
                else{
                    st.append(s.charAt(j));
                }
            }
            System.out.println(st.toString());
        }
    }
    
}
