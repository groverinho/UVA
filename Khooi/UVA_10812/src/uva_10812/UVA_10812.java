package uva_10812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_10812 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(systemInput.readLine());
        
        int i=1;
        while(i<=numCases)
        {
            StringTokenizer st = new StringTokenizer(systemInput.readLine());
            long sum = Integer.parseInt(st.nextToken());
            long difference = Integer.parseInt(st.nextToken());
            double a=0;
            double b=0;
            if(difference>sum){
                System.out.println("impossible");
            }
            else{
                a = (sum/2.0) + (difference/2.0);
                b = (sum/2.0) - (difference/2.0);
                
                long c = (long)a;
                long d = (long)b;
                
                if(a==(c) &&  b==(d))
                    System.out.println(c + " " + d);
                else
                    System.out.println("impossible");
            }
            i++;
        }
        
    }
    
}
