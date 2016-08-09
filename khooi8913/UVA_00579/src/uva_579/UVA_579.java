package uva_579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_579 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        String a;
        
        while((a = systemInput.readLine())!=null && !a.equals("0:00")){
            String [] time = a.split(":");
            double hour = Double.parseDouble(time[0]);
            double minute = Double.parseDouble(time[1]);
            
            //calculate angle of minute
            double fractionHour = minute/60.0;
            double angleMinute = fractionHour*360.0;
//            System.out.println(angleMinute);
            
            //calculate angle of hour
            double angleHour = (hour/12.00)*360.00 + (fractionHour*(1.00/12.00)*360.00);
//            System.out.println(angleHour);
            
            double finalAngle;
            if(angleHour>angleMinute){
                finalAngle = angleHour - angleMinute;
            }
            else{
                finalAngle = angleMinute - angleHour;
            }
            
            if(finalAngle<180){
                System.out.printf("%.3f\n",finalAngle);
            }
            else{
                finalAngle=360-finalAngle;
                System.out.printf("%.3f\n",finalAngle);
            }
        }
        
    }
    
}
