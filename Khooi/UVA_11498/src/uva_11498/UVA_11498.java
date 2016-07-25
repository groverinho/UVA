package uva_11498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11498 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            
            int numCases = Integer.parseInt(systemInput.readLine());
            if(numCases==0) break;
            String division = systemInput.readLine();
            StringTokenizer st = new StringTokenizer(division);
            double X = Double.parseDouble(st.nextToken());
            double Y = Double.parseDouble(st.nextToken());

            int i=0;
            while(i<numCases)
            {
                StringTokenizer st1 = new StringTokenizer(systemInput.readLine());
                double a = Double.parseDouble(st1.nextToken());
                double b = Double.parseDouble(st1.nextToken());
                if(a>X && b>Y)      System.out.println("NE");
                else if(a>X && b<Y) System.out.println("SE");
                else if(a<X && b>Y) System.out.println("NO");
                else if(a<X && b<Y) System.out.println("SO");
                else    System.out.println("divisa");
                i++;
            }
        
        }
        
        
        
    }
    
}
