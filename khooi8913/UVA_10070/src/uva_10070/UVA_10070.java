package uva_10070;
//NOT SOLVED RTE
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_10070 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int z=0;
        while((s=br.readLine())!=null && !s.isEmpty()){
            
            long year = Long.parseLong(s);
            
            if(z>0)
                System.out.println("");
            
            boolean leapyear = false;
            boolean huluculu = false;
            boolean bulukulu = false;
            
            if( (year%4==0 && year%100!=0) || (year%400==0)){
                System.out.println("This is a leap year.");
                leapyear=true;
            }          
            if(year%15==0){
                System.out.println("This is huluculu festival year.");
                huluculu=true;
            }
            if(leapyear && year%55==0){
                System.out.println("This is bulukulu festival year.");
                bulukulu=true;
            }
            
            if(!bulukulu && !leapyear && !huluculu)
                System.out.println("This is an ordinary year.");
            
            z++;
        }
        
    }
    
}
