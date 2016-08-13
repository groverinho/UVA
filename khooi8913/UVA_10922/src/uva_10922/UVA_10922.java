package uva_10922;

import java.util.Scanner;

public class UVA_10922 {

    public static void main(String[] args) {
        
        Scanner br = new Scanner(System.in);
        String s;
        
        while(!(s=br.nextLine()).equals("0")){
            String z = s;
            int depth=0;
            while(true){
                
                int sum=0;
                for(int i=0;i<z.length();i++){
                    sum+=Integer.parseInt(z.charAt(i)+"");
                }
                    
                z=sum+"";
                depth++;

                if(z.length()==1){
                    int w = Integer.parseInt(z);
                    if(w%9==0){
                        System.out.println(s +" is a multiple of 9 and has 9-degree "+depth+".");
                        break;
                    }
                    else{
                        System.out.println(s +" is not a multiple of 9.");
                        break;
                    }
                }
            }
        }    
    }    
}
