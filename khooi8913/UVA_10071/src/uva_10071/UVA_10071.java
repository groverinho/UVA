package uva_10071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_10071 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(s);
            int time = Integer.parseInt(st.nextToken());
            int velocity = Integer.parseInt(st.nextToken());
            if(time==0||velocity==0){
                System.out.println(0);
            }
            else{
                double acceleration = (double)velocity/time;
                time*=2;
//                System.out.println(time);
//                System.out.println(velocity);
//                System.out.println(acceleration);
                double displacement = 0.5*acceleration*Math.pow(time, 2);
                System.out.printf("%.0f\n",displacement);            
            }
            
        }
    }
    
}
