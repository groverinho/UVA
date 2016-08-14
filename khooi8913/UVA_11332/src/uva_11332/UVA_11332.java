package uva_11332;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_11332 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s=br.readLine()).equals("0")){
            if(s.length()==1){
                System.out.println(s);
            }
            else{
                while(s.length()!=1){
                    int sum=0;
                    for(int i=0;i<s.length();i++){
                        sum+=Integer.parseInt(s.charAt(i)+"");
                    }
                    s=sum+"";
                }
                System.out.println(s);
            }
        }
        
    }
    
}
