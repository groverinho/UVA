package uva_10114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_10114 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader systemInput=new BufferedReader(new InputStreamReader(System.in));
        String a;
        while((a=systemInput.readLine())!=null){
            StringTokenizer st = new StringTokenizer(a);
            int loanMonths = Integer.parseInt(st.nextToken());
                if(loanMonths<=0)   break;
            double downPayment = Double.parseDouble(st.nextToken());
            double loanAmount = Double.parseDouble(st.nextToken());
            int depreciationRec = Integer.parseInt(st.nextToken());
            double monthly = loanAmount/loanMonths;
            double carValue = loanAmount+downPayment;
            
            double depreciation[] = new double [loanMonths+1]; 
            
            for(int i=0;i<depreciationRec;i++){
                st = new StringTokenizer(systemInput.readLine());
                int month = Integer.parseInt(st.nextToken());
                double depreciationVal = Double.parseDouble(st.nextToken());
                for(int j=month;j<depreciation.length;j++){
                    depreciation[j]=depreciationVal;
                }
            }
            
            boolean check = false;
            
            int i=0;
            while(i<=loanMonths){
                carValue*=1-(depreciation[i]);
                if(i>=1){
                    loanAmount-=monthly;
                }    
                if(loanAmount<carValue){
                    check = true;
                    break;
                } 
                i++;
            }
            
            if(check){
                if(i==1)    System.out.println("1 month");
                else        System.out.println(i+" months");
            }
        }
        
    }
    
}
