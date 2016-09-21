package uva_10878;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_10878 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb2 = new StringBuilder();
        
        while((s=br.readLine())!=null){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==' '){
                    sb.append(0);
                }
                else if(s.charAt(i)=='o'){
                    sb.append(1);
                }   
            }
            
            if(!sb.toString().equals("")){
                int charCode = Integer.parseInt(sb.toString(),2);
                sb2.append(new Character((char)charCode));
            }
        }
        sb2.deleteCharAt(sb2.toString().length()-1);
        System.out.println(sb2.toString());
    }
    
}
