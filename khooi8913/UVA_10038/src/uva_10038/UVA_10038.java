package uva_10038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UVA_10038 {

    public static void main (String [] abc) throws IOException  {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=br.readLine())!=null) {
            String [] _s =s.split(" ");
            int n = Integer.parseInt(_s[0]);
            
            int [] num=new int [n];
            for (int i=0;i<num.length;i++) {
                    num[i]=Integer.parseInt(_s[i+1]);
                }

            int [] difference = new int[n-1];
            for (int i=0;i<num.length-1;i++) {
                difference[i] =Math.abs(num[i]-num[i+1]);
            }
            
            boolean[] check = new boolean[difference.length];
            for(int i=1;i<=difference.length;i++){
                for(int j=0;j<difference.length;j++){
                    if(i==difference[j])    check[i-1]=true;
                }
            }
            
            boolean status=true;
            for(int i=0;i<check.length;i++){
                if(check[i]==false)
                    status = false;
            }
            
            if(status){
                System.out.println("Jolly");
            }
            else{
                System.out.println("Not jolly");
            }
	}
    }
}
    